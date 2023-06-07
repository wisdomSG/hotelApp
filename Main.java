package hotelApp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //private static Customer customer;
    static Hotel hotel;
    public static void main(String[] args) {
        hotel = new Hotel();
        hotel.initializeRooms(); // Room 정보 가져오기

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
                    hotel.displayRooms(); // 객실 정보를 출력
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

    private static void printAllReservation(){
        // 모든 예약된 정보 출력하기!
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

    private  static void checkReservation() {
        // 해당 손님의 정보 1건만 출력하기
        Scanner checkScanner = new Scanner(System.in);
        try {
            System.out.println("예약번호를 입력해 주세요");
            System.out.print("예약번호: ");
            String input = checkScanner.nextLine();
            // parseInt(input) 으로 -예약 리스트-에서 조회하기
            // 있으면 예약 조회를 시작하겠습니다 출력후 thread 3초후 예약 정보 출력
            // 없으면 해당의 예약정보가 없습니다.
            // 예약번호를 다시 한 번 확인 하세요!
        }
        catch (NumberFormatException e){
            System.out.println("잘못된 형식으로 적으셨습니다");
        }
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
                checkReservation();
                // 예약 확인 기능 구현
                break;
            case 3:
                System.out.print("예약자 이름을 입력해주세요 : ");
                String usetName = sc.nextLine();
                System.out.println("예약자 전화번호를 입력해주세요 : ");
                String phone = sc.nextLine();
                hotel.cancelRes(usetName,phone);
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                CustomerReservationSystem();
                break;

        }

    }
}
