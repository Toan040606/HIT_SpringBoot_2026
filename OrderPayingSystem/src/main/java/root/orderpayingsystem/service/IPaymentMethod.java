package root.orderpayingsystem.service;

public interface IPaymentMethod {
    void pay(double amount);
    String getMethodName();
}
