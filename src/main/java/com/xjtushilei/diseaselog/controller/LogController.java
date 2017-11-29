package com.xjtushilei.diseaselog.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xjtushilei.diseaselog.dto.LineLog;
import com.xjtushilei.diseaselog.po.Evaluate;
import com.xjtushilei.diseaselog.po.IntelligentInterrogationLog;
import com.xjtushilei.diseaselog.repository.EvaluateRepository;
import com.xjtushilei.diseaselog.repository.IntelligentInterrogationLogRepository;
import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/api/log")
public class LogController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IntelligentInterrogationLogRepository intelligentInterrogationLogfRepository;

    @Autowired
    private EvaluateRepository evaluateRepository;

    @RequestMapping(value = "/getnotes", method = RequestMethod.GET)
    public List<Evaluate> getnotes(String sessionId) {
        return evaluateRepository.findBySessionId(sessionId);
    }

    @RequestMapping(value = "/getlog", method = RequestMethod.GET)
    public Map<String, Object> getLog(int page, int limit, int debug) {

        page = page - 1;
        Sort sort = new Sort(Sort.Direction.DESC, "time");
        Page<IntelligentInterrogationLog> pageList = null;
        if (debug == 1) {
            pageList = intelligentInterrogationLogfRepository.findAll(new PageRequest(page, limit, sort));
        } else {
            pageList = intelligentInterrogationLogfRepository.findAllByDebugIsFalseAndNameIsNot("J", new PageRequest(page, limit, sort));
        }
        //对 Comment 这个类中的一些字段进行过滤
        List<IntelligentInterrogationLog> data = new ArrayList<>();
        pageList.forEach(tag -> data.add(tag));

        List<LineLog> dtoLogs = new LinkedList<>();

        for (IntelligentInterrogationLog log : data) {
            LineLog lineLog = null;
            try {
                lineLog = new LineLog(evaluateRepository.countBySessionId(log.getSessionId()), log);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dtoLogs.add(lineLog);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("data", dtoLogs);
        result.put("code", 0);
        result.put("msg", "success");
        result.put("count", pageList.getTotalElements());
        return result;
    }


    @RequestMapping(value = "/uploadlog", method = RequestMethod.POST)
    public Map uploadlog(MultipartFile file) throws IOException {
        Map<String,Object> result=new HashMap();
        long count = 0;
        long log_count = 0;
        InputStream in=file.getInputStream();
        List<String> logFileList = IOUtils.readLines(in, "utf-8");
        for (String str : logFileList) {
            try {
                String[] split = str.split("---");
                if ("info_log".equals(split[3])) {
                    log_count++;

                    JsonParser parser = new JsonParser();
                    JsonElement root = parser.parse(split[5]);
                    JsonObject element = root.getAsJsonObject();
                    String sessionId = element.getAsJsonPrimitive("sessionId").getAsString();
                    if (intelligentInterrogationLogfRepository.exists(sessionId)) {
                        continue;
                    }
                    IntelligentInterrogationLog log = new IntelligentInterrogationLog();
                    log.setSessionId(sessionId);

                    log.setTime(element.getAsJsonPrimitive("time").getAsString());
                    log.setStatus(element.getAsJsonPrimitive("status").getAsString());
                    log.setDebug(element.getAsJsonPrimitive("debug").getAsBoolean());

                    log.setName(element.getAsJsonObject("patient").getAsJsonPrimitive("name").getAsString());
                    log.setDob(element.getAsJsonObject("patient").getAsJsonPrimitive("dob").getAsString());
                    log.setCardNo(element.getAsJsonObject("patient").getAsJsonPrimitive("cardNo").getAsString());
                    log.setSex(element.getAsJsonObject("patient").getAsJsonPrimitive("sex").getAsString());

                    log.setFinalDisease(element.getAsJsonArray("final_disease").toString());
                    log.setQuestions(element.getAsJsonArray("questions").toString());
                    log.setRecommendation(element.getAsJsonObject("recommendation").toString());
                    log.setAllLog(element.getAsJsonArray("all_log").toString());
                    intelligentInterrogationLogfRepository.save(log);
                    count++;
                }
                String re = "新加个数：" + String.valueOf(count) + ", 有效日志总个数:" + log_count + ",总行数:" + String.valueOf(logFileList.size());
                logger.info(re);
                result.put("data",re);
                in.close();
            } catch (Exception e) {
                in.close();
                e.printStackTrace();
                logger.error(e.getMessage(), e);
                result.put("data",e.getMessage());

            }
        }
        return result;
    }

    @RequestMapping(value = "/addnote", method = RequestMethod.POST)
    public boolean addnote(String sessionId, String note, String name) {
        Evaluate evaluate = new Evaluate(sessionId, note, name);
        evaluate = evaluateRepository.save(evaluate);
        if (evaluate.getId() != null) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/deletenote", method = RequestMethod.DELETE)
    public String addnote(Long id) {
        try {
            evaluateRepository.delete(id);
            return "删除成功！";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
