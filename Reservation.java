package hotelApp;

import java.time.LocalDateTime;

public class Reservation{
    private String roomType;
    private LocalDateTime reservationDate;     //예약 날짜
    private String reservationNumber;
    private Customer customer;

    public Reservation() {}

    public Reservation(String name, String phoneNumber, String roomType, LocalDateTime reservationDate, String reservationNumber) {
        this.customer = new Customer(name,phoneNumber);
        this.roomType = roomType;
        this.reservationDate = reservationDate;
        this.reservationNumber = reservationNumber;
    }

    public String getRoomType() {
        return roomType;
    }
    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

}
