package root.orderpayingsystem.service;

public class OrderService {
    private final IPaymentMethod paymentMethod;
    private final INotificationService notificationService;

    public OrderService(IPaymentMethod paymentMethod, INotificationService notificationService) {
        this.paymentMethod = paymentMethod;
        this.notificationService = notificationService;
    }

    public void processOrder(String customer, String product, double amount) {
        paymentMethod.pay(amount);
        String message = "Bạn đã thanh toán " + product + " với giá " + amount
                + " qua phương thức thanh toán: " + paymentMethod.getMethodName();
        notificationService.sendNotification(customer,  message);
    }
}
