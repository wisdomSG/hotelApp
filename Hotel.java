package src.hotelApp;

import java.util.ArrayList;

public class Hotel {
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

                }
            }
            System.out.println("해당 이름 혹은 번호는 존재하지 않습니다. 다시 한번 확인해주세요.");
        }
    }

    public void getRevenue() {}
    private void getRoomListCheck() {}

}
