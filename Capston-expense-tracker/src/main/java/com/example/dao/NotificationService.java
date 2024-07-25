package com.example.dao;

import com.example.entity.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification getNotification(Long notificationID) {
        Optional<Notification> notification = notificationRepository.findById(notificationID);
        if (notification.isPresent()) {
            return notification.get();
        } else {
            throw new RuntimeException("Notification not found");
        }
    }

    public List<Notification> getAllNotificationsForUser(Long userId) {
        return notificationRepository.findByUser_UserId(userId);
    }

    public void markNotificationAsRead(Long notificationID) {
        Notification notification = getNotification(notificationID);
        notification.setStatus("Read");
        notificationRepository.save(notification);
    }

    public void deleteNotification(Long notificationID) {
        if (notificationRepository.existsById(notificationID)) {
            notificationRepository.deleteById(notificationID);
        } else {
            throw new RuntimeException("Notification not found");
        }
    }

	public void markAsRead(Long notificationID) {
		// TODO Auto-generated method stub
		
	}
}
