package root.orderpayingsystem.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import root.orderpayingsystem.service.INotificationService;

@Component("email")
@Primary
public class EmailNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Đã gửi email tới " + to + "\n" + message);
    }
}
