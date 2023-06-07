package hotelProject;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class Room {
    private double roomFee;
    private int roomSize;
    private boolean reservationStatus;

    public Room(double roomFee, int roomSize) {
        this.roomFee = roomFee;
        this.roomSize = roomSize;
        this.reservationStatus = false; // 처음에는 예약되지 않은 상태로 초기화
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

    public void setReservationStatus(boolean reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}