package root.orderpayingsystem;

public class EmailNotification implements INotificationService{
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Đã gửi email tới " + to + "\n" + message);
    }
}
