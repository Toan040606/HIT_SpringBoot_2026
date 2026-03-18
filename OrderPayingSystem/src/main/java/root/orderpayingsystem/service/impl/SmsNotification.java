package root.orderpayingsystem.service.impl;

import org.springframework.stereotype.Component;
import root.orderpayingsystem.service.INotificationService;

@Component("sms")
public class SmsNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Đã gửi tin nhắn tới " + to + "\n" + message);
    }
}
