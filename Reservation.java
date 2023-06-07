package hotelProject;

public class Reservation extends Customer {
    int room;
    String reservationDate;


    public  Reservation() {}
    public void getRoom() {}
    public void getReservationDate() {}
    public Reservation(String name, String phoneNumber, int room, String reservationDate) {
        super(name, phoneNumber);
        this.room = room;
        this.reservationDate = reservationDate;
    }

}
