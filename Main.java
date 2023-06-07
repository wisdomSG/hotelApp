package hotelProject;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Customer customer;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayIntroduce();
            String choiceNum = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceNum); // 입력된 문자열을 정수롤 변환
            } catch (NumberFormatException e) { // 변환할 수 없을 경우 예외처리
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요");
                continue;
            }
            switch (choice) {
                case 0:
                    displayManager();
                    ChoiceManager();
                    break;
                case 1:
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
                break;
            case 2:
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시입력하세요");
                displayManager();
        }
    }
    private  static void displayIntroduce() {
        System.out.println("블베스 호텔에 오신 것을 환영합니다 :) ");
        System.out.println("1. 객실 조회");
        System.out.println("2. 고객 ");
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

    private static void  CustomerReservationSystem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("번호를 선택해주세요 >> ");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                CustomerReservationSystem();
                break;

        }

    }
}
