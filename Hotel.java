package hotelProject;
import java.util.ArrayList;

class Hotel {
    private ArrayList<Room> rooms;
    double revenue;

    public Hotel() {
        rooms = new ArrayList<>();
        revenue = 0.0;
    }

    public void initializeRooms() {
        Room singleRoom = new Room("싱글룸", 100.0, 16, true);
        Room doubleRoom = new Room("더블룸", 150.0, 24, true);
        Room twinRoom = new Room("트윈룸", 200.0, 16, true);
        Room suiteRoom = new Room("스위트룸", 250.0, 34, true);

        rooms.add(singleRoom);
        rooms.add(doubleRoom);
        rooms.add(twinRoom);
        rooms.add(suiteRoom);
    }

    public void displayRooms() {
        System.out.println("객실 목록");
        System.out.println("");
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            System.out.println("객실 번호: " + (i + 1));
            room.displayRoomInfo(); // 객실 정보 출력
        }
    }

    public void getRevenue() {}
    private void getRoomListCheck() {}

}
