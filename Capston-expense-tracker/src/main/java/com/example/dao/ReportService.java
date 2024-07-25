package com.example.dao;

import com.example.entity.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report getReport(Long reportID) {
        Optional<Report> report = reportRepository.findById(reportID);
        if (report.isPresent()) {
            return report.get();
        } else {
            throw new RuntimeException("Report not found");
        }
    }

    public List<Report> getAllReportsForUser(Long userId) {
        return reportRepository.findByUser_UserId(userId);
    }

    public List<Report> getReportsForPeriod(Long userId, String period) {
        return reportRepository.findByUser_UserIdAndPeriodContaining(userId, period);
    }
}
