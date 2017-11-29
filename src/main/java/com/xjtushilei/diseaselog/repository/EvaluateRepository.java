package com.xjtushilei.diseaselog.repository;

import com.xjtushilei.diseaselog.po.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluateRepository extends JpaRepository<Evaluate, Long> {

    List<Evaluate> findBySessionId(String sessionID);

    long countBySessionId(String sessionID);

}
