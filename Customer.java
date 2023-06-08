package hotelApp;

public class Customer {

    private String name;
    private String phoneNumber;
    private double money;
    public Customer() {}
    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.money = 0.0; // 초기자금 0으로 설정
    }


    public Customer(String name, String phoneNumber, double money) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.money = money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public double getMoney() {
        return money;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void refundMoney(double amount) {
        money += amount;
    }

}
