package hotelApp;
import java.util.ArrayList;
import java.util.Scanner;

class Hotel {
    ArrayList<Room> roomList;
    double revenue;
    ArrayList<Reservation> reservationList = new ArrayList<>();

    public void cancelRes(String resNum) {
        for (Reservation res : reservationList) {
            if (res.getReservationNumber().equals(resNum)) {
                for (Room room : roomList) {
                    if (res.getRoomType().equals(room.getRoomType())) {
                        this.revenue -= room.getRoomFee();
                        System.out.println(room.getRoomType() + "의 가격 " + room.getRoomFee() + "원이 환불되었습니다.");
                        room.setReservationStatus();
                        break;
                    }
                }
                reservationList.remove(res);
                System.out.println("취소 완료되었습니다.");
                break;

            }
        }
    }
    public Hotel() {
        roomList = new ArrayList<>();
        revenue = 0.0;
    }

    public void initializeRooms() {
        Room singleRoom = new Room("싱글룸", 100.0, 16, true);
        Room doubleRoom = new Room("더블룸", 150.0, 24, true);
        Room twinRoom = new Room("트윈룸", 200.0, 16, true);
        Room suiteRoom = new Room("스위트룸", 250.0, 34, true);

        roomList.add(singleRoom);
        roomList.add(doubleRoom);
        roomList.add(twinRoom);
        roomList.add(suiteRoom);
    }

    public void displayRooms() {
        System.out.println("객실 목록");
        System.out.println();
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            System.out.println("객실 번호: " + (i + 1));
            room.displayRoomInfo(); // 객실 정보 출력
        }
    }

}
