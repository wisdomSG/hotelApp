package hotelApp;

public class Reservation{
    private String roomType;
    private String reservationDate;     //예약 날짜
    private String reservationNumber;
    private Customer customer;

    public Reservation() {}

    public Reservation(String name, String phoneNumber, String roomType, String reservationDate) {
        this.customer = new Customer(name,phoneNumber);
        this.roomType = roomType;
        this.reservationDate = reservationDate;
    }

    public String getRoomType() {
        return roomType;
    }
    public String getReservationDate() {
        return reservationDate;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString(){
        return  "예약번호: " + reservationNumber + " 이름: " + customer.getName() + " 핸드폰번호: " + customer.getPhoneNumber()
                + " 방: " + roomType + " 예약날짜: "  + reservationDate;
    }
}
