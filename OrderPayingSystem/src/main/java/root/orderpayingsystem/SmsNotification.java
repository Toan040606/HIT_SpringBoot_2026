package root.orderpayingsystem;

public class SmsNotification implements INotificationService{
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Đã gửi tin nhắn tới " + to + "\n" + message);
    }
}
