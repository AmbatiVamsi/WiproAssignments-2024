package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String period; // Format can be "YYYY-MM" or "YYYY"

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private LocalDate generatedDate; // Date when the report was generated

    // Default constructor
    public Report() {}

    // Parameterized constructor
    public Report(User user, String period, Double totalAmount, LocalDate generatedDate) {
        this.user = user;
        this.period = period;
        this.totalAmount = totalAmount;
        this.generatedDate = generatedDate;
    }

    // Getters and Setters
    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }

    @Override
    public String toString() {
        return "Report [reportId=" + reportId + ", user=" + user + ", period=" + period + ", totalAmount=" + totalAmount
                + ", generatedDate=" + generatedDate + "]";
    }
}
