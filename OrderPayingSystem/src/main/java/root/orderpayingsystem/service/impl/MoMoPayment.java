package root.orderpayingsystem.service.impl;

import root.orderpayingsystem.service.IPaymentMethod;

public class MoMoPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán thành công: " + amount);
    }

    @Override
    public String getMethodName() {
        return "Momo";
    }
}
