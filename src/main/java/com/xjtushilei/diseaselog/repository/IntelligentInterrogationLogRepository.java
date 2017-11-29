package com.xjtushilei.diseaselog.repository;

import com.xjtushilei.diseaselog.po.IntelligentInterrogationLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntelligentInterrogationLogRepository extends JpaRepository<IntelligentInterrogationLog, String> {

    Page<IntelligentInterrogationLog> findAllByDebugIsFalseAndNameIsNot(String name, Pageable pageable);
}
