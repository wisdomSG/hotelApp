package hotelApp;
import java.util.ArrayList;

class Hotel {
    private ArrayList<Room> rooms;
    double revenue;
    ArrayList<Reservation> reservationList = new ArrayList<>();
    ArrayList<Room> roomList = new ArrayList<>();

    public void cancelRes(String name, String phone){
        for(Reservation res : reservationList){
            Customer customer = res.getCustomer();
            if(customer.getName().equals(name)){
                if(customer.getPhoneNumber().equals(phone))
                {

                    for (Room room: roomList){
                        if(res.getRoomType().equals(room.roomType)){
                            this.revenue -=room.roomFee;
                            System.out.println(room.roomType+"의 가격 "+room.roomFee+"원이 환불되었습니다.");
                            room.setReservationStatus();
                            break;
                        }
                    }
                    res.Cancel();
                    System.out.println("취소 완료되었습니다.");
                    break;

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
