package root.orderpayingsystem.service.impl;

import root.orderpayingsystem.service.INotificationService;

public class SmsNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Đã gửi tin nhắn tới " + to + "\n" + message);
    }
}
