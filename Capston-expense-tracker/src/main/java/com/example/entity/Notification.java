package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDate date; // Date when the notification was sent

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationStatus status; // Status of the notification (Read/Unread)

    // Default constructor
    public Notification() {}

    // Parameterized constructor
    public Notification(User user, String message, LocalDate date, NotificationStatus status) {
        this.user = user;
        this.message = message;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification [notificationId=" + notificationId + ", user=" + user + ", message=" + message
                + ", date=" + date + ", status=" + status + "]";
    }

	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}
}
