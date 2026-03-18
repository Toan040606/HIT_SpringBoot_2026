package root.orderpayingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import root.orderpayingsystem.service.OrderService;
import root.orderpayingsystem.service.impl.*;

@SpringBootApplication
public class OrderPayingSystemApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrderPayingSystemApplication.class, args);

        OrderService order1 = context.getBean(OrderService.class);
        OrderService order2 = context.getBean(OrderService.class);
        OrderService order3 = context.getBean(OrderService.class);

        order1.processOrder("Toàn", "Tai nghe", 300000);
        order2.processOrder("Trung", "Laptop", 1500000);
        order3.processOrder("Huy", "Điện thoại", 3000000);
    }

}
