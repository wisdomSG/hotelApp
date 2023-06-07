package hotelProject;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Room> rooms;

    public static void main(String[] args) {
        rooms = new ArrayList<>();
        initializeRooms(); // Room 정보 가져오기

        Scanner sc = new Scanner(System.in);

        while (true) {
            displayIntroduce();
            String choiceNum = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceNum); // 입력된 문자열을 정수로 변환
            } catch (NumberFormatException e) { // 변환할 수 없을 경우 예외 처리
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요");
                continue;
            }
            switch (choice) {
                case 0:
                    displayManager();
                    ChoiceManager();
                    break;
                case 1:
                    displayRooms(); // 객실 정보를 출력
                    break;
                case 2:
                    setCustomerInfo();
                    displaySubIntro();
                    CustomerReservationSystem();
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요");
                    break;
            }
        }
    }

    private static void displayManager() {
        System.out.println("1. 예약 목록 조회");
        System.out.println("2. 돌아가기");
    }

    private static void ChoiceManager() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1:
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

    private static void displayIntroduce() {
        System.out.println("블베스 호텔에 오신 것을 환영합니다 :) ");
        System.out.println("1. 객실 조회");
        System.out.println("2. 고객");
    }

    private static void displaySubIntro() {
        System.out.println("1. 객실 예약");
        System.out.println("2. 예약 확인");
        System.out.println("3. 예약 취소");
    }

    private static void setCustomerInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("고객님의 이름을 입력하세요 >>");
        String customerName = sc.nextLine();
        System.out.print("고객님의 전화번호를 입력하세요 >> ");
        String customerPhoneNum = sc.nextLine();
        System.out.print("고객님의 소지금을 입력하세요 >> ");
        String customerMoney = sc.nextLine();
    }

    private static void CustomerReservationSystem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("번호를 선택해주세요 >> ");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                // 객실 예약 기능 구현
                break;
            case 2:
                // 예약 확인 기능 구현
                break;
            case 3:
                // 예약 취소 기능 구현
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                CustomerReservationSystem();
                break;
        }
    }

    private static void initializeRooms() {
        Room singleRoom = new Room("싱글룸", 100.0, 16, true);
        Room doubleRoom = new Room("더블룸", 150.0, 24, true);
        Room twinRoom = new Room("트윈룸", 200.0, 16, true);
        Room suiteRoom = new Room("스위트룸", 250.0, 34, true);

        rooms.add(singleRoom);
        rooms.add(doubleRoom);
        rooms.add(twinRoom);
        rooms.add(suiteRoom);
    }

    private static void displayRooms() {
        System.out.println("객실 목록");
        System.out.println("");
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            System.out.println("객실 번호: " + (i + 1));
            System.out.println("객실 타입: " + room.getRoomType());
            System.out.println("객실 요금: " + room.getRoomFee() + " $");
            System.out.println("객실 크기: " + room.getRoomSize() + " 평");
            System.out.println((room.getReservationStatus() ? "예약 가능" : "예약 불가능"));
            System.out.println();
        }
    }
}