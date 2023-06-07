package hotelProject;

public class Room {
    private String roomType;
    private double roomFee;
    private int roomSize;
    private boolean reservationStatus;

    public Room(String roomType, double roomFee, int roomSize, boolean reservationStatus) {
        this.roomType = roomType;
        this.roomFee = roomFee;
        this.roomSize = roomSize;
        this.reservationStatus = reservationStatus;
    }

    public double getRoomFee() {
        return roomFee;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public boolean getReservationStatus() {
        return reservationStatus;
    }

    public String getRoomType() {
        return roomType;
    }
}
