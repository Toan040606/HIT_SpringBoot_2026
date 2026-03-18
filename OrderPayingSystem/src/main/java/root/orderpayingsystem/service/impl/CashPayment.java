package root.orderpayingsystem.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import root.orderpayingsystem.service.IPaymentMethod;

@Component("Cash")
@Primary
public class CashPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán thành công: " + amount);
    }

    @Override
    public String getMethodName() {
        return "Tiền mặt";
    }
}
