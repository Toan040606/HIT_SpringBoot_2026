package root.orderpayingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    private IPaymentMethod paymentMethod;

    @Autowired
    private INotificationService notificationService;

    public OrderService(@Qualifier("Cash") IPaymentMethod paymentMethod,
                        @Qualifier("email") INotificationService notificationService) {
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
