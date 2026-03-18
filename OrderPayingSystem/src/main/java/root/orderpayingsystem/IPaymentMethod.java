package root.orderpayingsystem;

public interface IPaymentMethod {
    void pay(double amount);
    String getMethodName();
}
