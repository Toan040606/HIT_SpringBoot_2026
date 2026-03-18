package root.orderpayingsystem.service.impl;

import org.springframework.stereotype.Component;
import root.orderpayingsystem.service.IPaymentMethod;

@Component("bankTransfer")
public class BankTransferPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán thành công: " + amount);
    }

    @Override
    public String getMethodName() {
        return "Chuyển khoản ngân hàng";
    }
}
