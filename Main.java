package hotelApp;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
    Hotel hotel;
    Customer customer;

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        hotel = new Hotel();
        hotel.initializeRooms(); // Room 정보 가져오기

        Scanner sc = new Scanner(System.in);
        String choiceNum = "";
        while (!Objects.equals(choiceNum, "100")) {
            displayIntroduce();
            choiceNum = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceNum); // 입력된 문자열을 정수로 변환
            } catch (NumberFormatException e) { // 변환할 수 없을 경우 예외 처리
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요");
                continue;
            }
            switch (choice) {
                case 0 -> {
                    displayManager();
                    ChoiceManager();
                }
                case 1 -> hotel.displayRooms(); // 객실 조회
                case 2 -> checkCustomerInfo();  // 객실 예약
                case 3 -> enterCustomerInfo();  //고객 정보 등록
                case 100 ->{
                    System.out.println("시스템이 종료되었습니다 -슬슬기-");
                }
                default -> System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요");
            }
        }
    }

    private static void displayManager() {
        System.out.println("1. 예약 목록 조회");
        System.out.println("2. 돌아가기");
    }

    private void ChoiceManager() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1:
                printAllReservation();
                // 예약 목록 조회 기능 구현
                break;
            case 2:
                // 돌아가기 기능 구현
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력하세요");
                displayManager();
        }
    }

    private void printAllReservation(){
        // 모든 예약된 정보 출력하기!
        if(hotel.reservationList.isEmpty()) {
            System.out.println("예약된 정보가 없습니다");
            return;
        }
        else {
            for(Reservation printRervation : hotel.reservationList ) {
                System.out.println(printRervation);
            }
        }
    }

    private void displayIntroduce() {
        System.out.println("블베스 호텔에 오신 것을 환영합니다 :) ");
        System.out.println("1. 객실 조회");
        System.out.println("2. 예약");
        System.out.println("3. 회원 등록");

        if (customer != null) {
            System.out.println("고객의 소지금: $" + customer.getMoney());
        }
    }

    private static void displaySubIntro() {
        System.out.println("1. 객실 예약");
        System.out.println("2. 예약 확인");
        System.out.println("3. 예약 취소");
    }

    private void enterCustomerInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = sc.nextLine();
        System.out.print("소지금을 입력하세요: $");
        double money = sc.nextDouble();
        customer = new Customer(name, phoneNumber, money);
        System.out.println("고객 정보가 입력되었습니다.");
    }

    private void checkCustomerInfo() {
        if (customer == null) {
            System.out.println("고객 정보가 없습니다. 등록 후 이용부탁드립니다.");
        } else {
            displaySubIntro();
            CustomerReservationSystem();
        }
    }

    private void checkReservation() {
        // 해당 손님의 정보 1건만 출력하기
        Scanner checkScanner = new Scanner(System.in);
        boolean flag = true;
        try {
            System.out.println("예약번호를 입력해 주세요");
            System.out.print("예약번호: ");
            String reservationInput = checkScanner.nextLine();
            for(Reservation printRervation : hotel.reservationList ) {
                if(printRervation.getReservationNumber().equals(reservationInput)) {
                    System.out.println(printRervation);
                    flag = false;
                    break;
                }
                else {

                }
            }
            if(flag) System.out.println("예약번호가 일치하지 않습니다");
        }
        catch (NumberFormatException e){
            System.out.println("잘못된 형식으로 적으셨습니다");
            checkReservation();
        }
    }

    private void CustomerReservationSystem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("번호를 선택해주세요 >> ");
        int input = sc.nextInt();
        switch (input) {
            case 1 -> roomReservation();  // 객실 예약 기능 구현
            case 2 -> checkReservation(); // 예약 확인 기능 구현
            case 3 -> {
                System.out.print("예약번호를 입력해주세요 : ");
                String reservationNum = sc.next();
                hotel.cancelRes(reservationNum);
            }
            default -> {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                CustomerReservationSystem();
            }
        }

    }
    public void roomReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("객실 예약을 진행하겠습니다.");
        System.out.print("객실의 타입을 입력해주세요: ");
        String roomType = sc.nextLine();

        // 호텔의 객실 목록을 가져옴
        ArrayList<Room> roomList = hotel.roomList;

        // 입력된 객실 타입에 해당하는 객실을 찾음
        Room selectedRoom = null;
        for (Room room : roomList) {
            if (room.getRoomType().equals(roomType)) {
                selectedRoom = room;
                break;
            }
        }

        // 해당 객실이 예약 가능한지 확인하고 예약 처리
        if (selectedRoom != null && selectedRoom.reservationStatus) {
            System.out.println(roomType + "을(를) 예약합니다.");
            LocalDateTime reservationDate = LocalDateTime.parse(String.valueOf(LocalDateTime.now()));
            // 예약 중복 체크
            boolean isDuplicateReservation = false;
            for (Reservation reservation : hotel.reservationList) {
                if (reservation.getRoomType().equals(roomType) && reservation.getReservationDate().equals(reservationDate)) {
                    isDuplicateReservation = true;
                    break;
                }
            }

            if (isDuplicateReservation) {
                System.out.println("해당 날짜에 이미 예약이 존재하여 예약할 수 없습니다.");
            } else {
                // 예약한 객실의 가격과 고객의 소지금 비교
                double roomFee = selectedRoom.getRoomFee();
                double customerMoney = customer.getMoney();

                if (customerMoney < roomFee) {
                    System.out.println("고객의 소지금이 부족하여 예약할 수 없습니다.");
                    System.out.println("고객의 소지금: " + customerMoney +"$");
                    System.out.println("객실의 가격: " + roomFee+"$");
                } else {
                    // 예약번호 생성
                    UUID reservationId = UUID.randomUUID();
                    String reservationNumber = reservationId.toString();
                    // 예약 객체 생성
                    Reservation reservation = new Reservation(customer.getName(), customer.getPhoneNumber(), roomType, reservationDate,reservationNumber);

                    // 예약 정보를 예약 목록에 추가
                    hotel.reservationList.add(reservation);

                    // 매출 업데이트
                    hotel.revenue += roomFee;

                    // 예약 상태 변경
                    selectedRoom.setReservationStatus();

                    // 고객의 남은 소지금 계산
                    double remainingMoney = customerMoney - roomFee;
                    customer.setMoney(remainingMoney);

                    System.out.println("객실이 예약되었습니다.");
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
                    System.out.println("예약 일자 :" +reservationDate.format(dateTimeFormatter)+ " 입니다.");
                    System.out.println("예약 번호는 : " +reservationNumber+ " 입니다.");
                    System.out.println("고객의 남은 소지금: $" + remainingMoney);
                }
            }
        } else {
            System.out.println("해당 객실은 예약할 수 없습니다.");
        }
    }
}
