package com.example.dao;

import com.example.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByUser_UserId(Long userID);
    List<Report> findByUser_UserIdAndPeriodContaining(Long userId, String period);
}
