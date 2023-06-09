# 프로젝트 소개
블베스(블루베리스무디)호텔 예약 시스템입니다

## 호텔 예약 프로그램 만들기!
### 팀프로젝트명: 블베스 호텔
### 팀명: 블루베리스무디(A반 4조)
A반 4조 조원 5분 모두 경상도출신이라서 블루베리스무디로 지었습니다!!

## 필수 요구사항 
+ 호텔은 여러 객실과 자산을 보유하고있음
+ 객실은 객실 당 하루에 한 사람만 예약이 가능함
+ 객실은 크기,숙박비를 가진다
+ 예약은  객실, 고객의 이름, 고객의 전화번호, 예약 날짜를 가지고 있다
    - 전화 번호 제한(XXX-XXXX-XXXX) 정규 표현식   (선택)
    - 예약 날짜 **** 날짜는 ISO 8601 형식으로
       조합된 UTC 날짜 및 시간 예) 2016-10-27T17:13:40+00:00 
+  고객은 이름, 전화번호, 소지금을 가진다
    - 고객 소지금보다 비싼 방은 예약 불가
+ 호텔은 모든 예약 목록을 조회 할 수 있다. 
+ 고객은 자신의 예약 목록을 조회 할 수 있다.
    - 예약 번호로 예약 내역을 조회한다.
+  고객은 자신의 예약을 취소 할 수 있다.
+ 고객이 호텔 예약 시에 예약 번호(id)를 반환 (uuid 활용)
    - 고객이 호텔 예약에 성공하면 예약 번호(id)를 받는다.
    - 고객이 예약 목록을 조회 시 예약 번호도 같이 조회 된다.
    - 고객이 예약 취소 시 예약 번호를 통해 자신의 특정 예약을 취소한다.

# Class Diagram
![](https://velog.velcdn.com/images/uiseongsang/post/7e444a74-fe84-442f-8c95-bf36ba1c2431/image.png)

> 관계선은 무시하시면 됩니다.

# Interaction Diagram
![](https://velog.velcdn.com/images/uiseongsang/post/1a19ff63-9810-473e-8d56-3fd6c5aed665/image.png)


# Test
![](https://velog.velcdn.com/images/uiseongsang/post/73802bea-7fb3-4d5f-88bd-bccaa7cb9ac3/image.png)
