package src.hotelApp;


public class Reservation{
    private String roomType;
    private String reservationDate;     //예약 날짜
    private String reservationNumber;
    private Customer customer;

    public Reservation() {}

    public Reservation(String name, String phoneNumber, String roomType, String reservationDate,String reservationNumber) {
        this.customer = new Customer(name,phoneNumber);
        this.roomType = roomType;
        this.reservationDate = reservationDate;
        this.reservationNumber = reservationNumber;
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

    public void Cancel(){
        roomType = "";
        reservationDate = "";
        reservationNumber = "";
        customer = null;
    }


}
