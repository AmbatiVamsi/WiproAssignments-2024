package com.example.controller;

import com.example.dao.ReportService;
import com.example.entity.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report createdReport = reportService.createReport(report);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    @GetMapping("/{reportID}")
    public ResponseEntity<Report> getReport(@PathVariable Long reportID) {
        Report report = reportService.getReport(reportID);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<List<Report>> getAllReportsForUser(@PathVariable Long userID) {
        List<Report> reports = reportService.getAllReportsForUser(userID);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/users/{userID}/period")
    public ResponseEntity<List<Report>> getReportsForPeriod(
            @PathVariable Long userID,
            @RequestParam String month,
            @RequestParam String year) {
        String period = year + "-" + month;
        List<Report> reports = reportService.getReportsForPeriod(userID, period);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}
