package root.orderpayingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import root.orderpayingsystem.service.OrderService;
import root.orderpayingsystem.service.impl.*;

@SpringBootApplication
public class OrderPayingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderPayingSystemApplication.class, args);

        OrderService order1 = new OrderService(new MoMoPayment(), new SmsNotification());
        OrderService order2 = new OrderService(new BankTransferPayment(), new EmailNotification());
        OrderService order3 = new OrderService(new MoMoPayment(), new SmsNotification());

        order1.processOrder("Toàn", "Tai nghe", 300000);
        order2.processOrder("Trung", "Laptop", 1500000);
        order3.processOrder("Huy", "Điện thoại", 3000000);
    }

}
