package com.xjtushilei.diseaselog.test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class t1 {
    public static void main(String[] args){
        //language=JSON
        String json="{\n" +
                "    \"questions\": [\n" +
                "        {\n" +
                "            \"seqno\": 1,\n" +
                "            \"choices\": [\n" +
                "                \"月经不调\",\n" +
                "                \"性交疼痛\",\n" +
                "                \"腹痛\",\n" +
                "                \"白带增多\",\n" +
                "                \"食欲不振\"\n" +
                "            ],\n" +
                "            \"choice\": \"白带增多\",\n" +
                "            \"type\": \"multiple\",\n" +
                "            \"query\": \"请问患者哪里不舒服?\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"seqno\": 2,\n" +
                "            \"choices\": [\n" +
                "                \"发烧\",\n" +
                "                \"阴道不规则出血\",\n" +
                "                \"尿道灼痛\",\n" +
                "                \"腰骶疼痛\",\n" +
                "                \"宫颈闭锁\",\n" +
                "                \"以上都没有\"\n" +
                "            ],\n" +
                "            \"choice\": \"阴道不规则出血,没有其他症状了\",\n" +
                "            \"type\": \"multiple\",\n" +
                "            \"query\": \"患者还有其他不适症状吗?\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"seqno\": 3,\n" +
                "            \"choices\": [\n" +
                "                \"阴道分泌物增多\",\n" +
                "                \"外阴瘙痒\",\n" +
                "                \"白带异常\",\n" +
                "                \"脓性白带\",\n" +
                "                \"以上都没有\"\n" +
                "            ],\n" +
                "            \"choice\": \"肚疼\",\n" +
                "            \"type\": \"multiple\",\n" +
                "            \"query\": \"患者还有其他不适症状吗?\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"all_log\": [\n" +
                "        {\n" +
                "            \"seqno\": 1,\n" +
                "            \"wangmeng症状推荐算法结果\": {\n" +
                "                \"recommend_sym_list\": [\n" +
                "                    {\n" +
                "                        \"name\": \"发烧\",\n" +
                "                        \"rate\": 70\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"阴道不规则出血\",\n" +
                "                        \"rate\": 12\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"尿道灼痛\",\n" +
                "                        \"rate\": 11\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"腰骶疼痛\",\n" +
                "                        \"rate\": 6\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"宫颈闭锁\",\n" +
                "                        \"rate\": 1\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"normal_recommendation\": true,\n" +
                "                \"diagnosis_list\": []\n" +
                "            },\n" +
                "            \"gender\": \"female\",\n" +
                "            \"age\": 26.73972602739726,\n" +
                "            \"本轮为止,用户没有选择的所有症状\": [\n" +
                "                \"月经不调\",\n" +
                "                \"性交疼痛\",\n" +
                "                \"腹痛\",\n" +
                "                \"食欲不振\"\n" +
                "            ],\n" +
                "            \"jingwei  pre_predict的计算值\": \"0.750526\",\n" +
                "            \"nlu历史记录\": [],\n" +
                "            \"jingwei首轮模型输入\": \"白带增多\",\n" +
                "            \"jingwei识别疾病：\": [\n" +
                "                [\n" +
                "                    \"阴道和外阴的其他炎症\",\n" +
                "                    0.7839270276618726,\n" +
                "                    \"N76\"\n" +
                "                ],\n" +
                "                [\n" +
                "                    \"宫颈恶性肿瘤\",\n" +
                "                    0.7221142842781361,\n" +
                "                    \"C53\"\n" +
                "                ],\n" +
                "                [\n" +
                "                    \"宫颈其他非炎性疾患\",\n" +
                "                    0.7188091842623953,\n" +
                "                    \"N88\"\n" +
                "                ],\n" +
                "                [\n" +
                "                    \"其他女性盆腔炎性疾病\",\n" +
                "                    0.7177031115928241,\n" +
                "                    \"N73\"\n" +
                "                ],\n" +
                "                [\n" +
                "                    \"念珠菌病\",\n" +
                "                    0.7078671259937922,\n" +
                "                    \"B37\"\n" +
                "                ]\n" +
                "            ],\n" +
                "            \"本轮为止,用户所有输入过的文本的分词\": [\n" +
                "                \"白带\",\n" +
                "                \"增多\",\n" +
                "                \"白带增多\"\n" +
                "            ],\n" +
                "            \"choice_now\": \"白带增多\",\n" +
                "            \"jingwei  pre_predict分到科室\": \"（非'遗传咨询', '男科', '产科'）[程序继续往下走]\",\n" +
                "            \"jingwei的预测专科模型输入\": \"白带增多\",\n" +
                "            \"nlu-response\": \"超时（250ms）或者json解析错误\",\n" +
                "            \"nlu输入\": \"白带增多\",\n" +
                "            \"jingwei识别症状：\": [\n" +
                "                \"白带增多\",\n" +
                "                \"外阴瘙痒\",\n" +
                "                \"阴道分泌物增多\",\n" +
                "                \"白带异常\",\n" +
                "                \"血性阴道排液\"\n" +
                "            ],\n" +
                "            \"nlu-提取结果\": [],\n" +
                "            \"info\": []\n" +
                "        }\n" +
                "    ],\n" +
                "    \"sessionId\": \"org_31065d1e2709d04865179fa41fdc8358\",\n" +
                "    \"time\": \"2017-11-27 20:01:50\",\n" +
                "    \"status\": \"doctors\",\n" +
                "    \"recommendation\": {\n" +
                "        \"doctors\": [\n" +
                "            {\n" +
                "                \"name\": \"杨沛\",\n" +
                "                \"label\": \"妇科|妇科、妇科肿瘤\",\n" +
                "                \"id\": \"00267\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"雷巍\",\n" +
                "                \"label\": \"妇科|擅长妇科、外阴宫颈病变、阴道镜，\",\n" +
                "                \"id\": \"00481\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"冯余宽\",\n" +
                "                \"label\": \"妇科|外阴宫颈病变、阴道镜\",\n" +
                "                \"id\": \"00281\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"李春梅\",\n" +
                "                \"label\": \"妇科|妇产科学、妇科肿瘤、医务管理\",\n" +
                "                \"id\": \"00432\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"彭秀琼\",\n" +
                "                \"label\": \"妇科|妇科、妇科激光\",\n" +
                "                \"id\": \"00113\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"蔡压西\",\n" +
                "                \"label\": \"妇科|妇科\",\n" +
                "                \"id\": \"00236\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"尹如铁\",\n" +
                "                \"label\": \"妇科|外阴阴道宫颈病变、妇科化疗\",\n" +
                "                \"id\": \"00357\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"王红静\",\n" +
                "                \"label\": \"妇科|妇产科学、妇科肿瘤、妇科\",\n" +
                "                \"id\": \"00265\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"刘辉\",\n" +
                "                \"label\": \"妇科|妇产科学、妇科肿瘤、妇科\",\n" +
                "                \"id\": \"00312\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"何跃东\",\n" +
                "                \"label\": \"妇科|妇科、妇科肿瘤、妇科腔镜、妇科盆底\",\n" +
                "                \"id\": \"00366\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"final_disease\": [\n" +
                "        [\n" +
                "            \"其他女性盆腔炎性疾病\",\n" +
                "            0.7251999298481865,\n" +
                "            \"N73\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"与女性生殖器官和月经周期有关的疼痛和其他情况\",\n" +
                "            0.7181281506199073,\n" +
                "            \"N94\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"背痛\",\n" +
                "            0.7166300558294716,\n" +
                "            \"M54\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"外阴和会阴的其他非炎性疾患\",\n" +
                "            0.7155195239752541,\n" +
                "            \"N90\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"宫颈其他非炎性疾患\",\n" +
                "            0.7096992766913875,\n" +
                "            \"N88\"\n" +
                "        ]\n" +
                "    ],\n" +
                "    \"patient\": {\n" +
                "        \"name\": \"J\",\n" +
                "        \"dob\": \"1991-03-09\",\n" +
                "        \"cardNo\": \"abc1231\",\n" +
                "        \"sex\": \"female\"\n" +
                "    },\n" +
                "    \"debug\": false\n" +
                "}";



        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(json);
        JsonObject element = root.getAsJsonObject();
        System.out.println(element.getAsJsonObject("recommendation"));

        ReadContext data = JsonPath.parse(json);
        System.out.println(JsonPath.read(json, "$.recommendation").toString());
        System.out.println(data.read("$.patient.sex", String.class));
        System.out.println(data.read("$.status", String.class));
        System.out.println(data.read("$.recommendation", Object.class).toString());
        System.out.println(data.read("$.all_log", Object.class).toString());

    }
}
