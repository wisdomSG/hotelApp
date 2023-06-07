package src.hotelApp;

public class Room {
    String roomType;
    double roomFee;
    int roomSize;
    boolean reservationStatus;

    public void getRoomFee() {}

    public void getRoomSize() {}

    public void getReservationStatus() {}
    public void setReservationStatus(){
        reservationStatus = !reservationStatus;
    }
    private void initializeRoom(double roomFee, int roomSize, boolean reservationStatus) { // 객실 정보 4가지 작성

    }

}
