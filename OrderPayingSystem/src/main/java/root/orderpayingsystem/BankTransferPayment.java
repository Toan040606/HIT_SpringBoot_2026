package root.orderpayingsystem;

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
