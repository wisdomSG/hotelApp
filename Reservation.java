package hotelProject;

public class Reservation extends Customer {
    String roomType;
    String reservationDate;


    public  Reservation() {}
    public void getRoom() {}
    public void getReservationDate() {}
    public Reservation(String name, String phoneNumber, String roomType, String reservationDate) {
        super(name, phoneNumber);
        this.roomType = roomType;
        this.reservationDate = reservationDate;
    }
}
