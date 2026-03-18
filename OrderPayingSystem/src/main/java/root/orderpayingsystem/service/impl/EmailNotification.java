package root.orderpayingsystem.service.impl;

import root.orderpayingsystem.service.INotificationService;

public class EmailNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Đã gửi email tới " + to + "\n" + message);
    }
}
