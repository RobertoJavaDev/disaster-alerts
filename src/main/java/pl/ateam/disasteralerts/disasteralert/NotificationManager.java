package pl.ateam.disasteralerts.disasteralert;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.ateam.disasteralerts.disasteralert.dto.AlertAddDTO;
import pl.ateam.disasteralerts.user.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
class NotificationManager {

    private final EmailService emailService;
    private final SMSService smsService;

    private final List<NotificationListener> notificationListeners = new ArrayList<>();
    void sendNotifications(AlertAddDTO alertAddDTO, UserDTO interestedUser) {
        notificationListeners.forEach(notificationListener -> notificationListener.addedAlert(alertAddDTO, interestedUser));
    }

    void addEmailService() {
        notificationListeners.add(emailService);
    }

    void addSMSService() {
        notificationListeners.add(smsService);
    }

    void removeEmailService() {
        notificationListeners.remove(emailService);
    }

    void removeSMSService() {
        notificationListeners.remove(smsService);
    }

    void clearNotificationServices() {
        notificationListeners.clear();
    }
}