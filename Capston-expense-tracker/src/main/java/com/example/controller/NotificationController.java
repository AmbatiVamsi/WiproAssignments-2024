package com.example.controller;

import com.example.dao.NotificationService;
import com.example.entity.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Create a new notification
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    // Get notification details
    @GetMapping("/{notificationID}")
    public ResponseEntity<Notification> getNotification(@PathVariable Long notificationID) {
        Notification notification = notificationService.getNotification(notificationID);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    // Get all notifications for a user
    @GetMapping("/users/{userID}")
    public ResponseEntity<List<Notification>> getAllNotificationsForUser(@PathVariable Long userID) {
        List<Notification> notifications = notificationService.getAllNotificationsForUser(userID);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    // Mark a notification as read
    @PutMapping("/{notificationID}/read")
    public ResponseEntity<Void> markAsRead(@PathVariable Long notificationID) {
        notificationService.markAsRead(notificationID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Delete a notification
    @DeleteMapping("/{notificationID}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long notificationID) {
        notificationService.deleteNotification(notificationID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
