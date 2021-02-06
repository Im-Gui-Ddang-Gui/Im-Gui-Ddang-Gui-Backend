package com.example.ddangui.entity.report;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
}
