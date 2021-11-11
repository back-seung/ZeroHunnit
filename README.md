# ZeroHunnit

🙋‍♂️ 참가인원 : 백승한 윤백선

⏳ 소요기간 : 2021.11.11 13:00 ~ 현재 제작 중

🛠 사용 Tool

* JavaSE-1.8
* Eclipse jee 2021-06
* Git (서로 첫 협업)
* Oracle 11.2.0.1.0

⚙ 주요 기능

* 추가 예정

## ERD

![image-20211111213833988](https://user-images.githubusercontent.com/84169773/141306844-8d2dcdbf-7564-49f7-b2c0-531a0d66de16.png)

> ERD 관계도 입니다.
>
> 다수의 Customer(고객)는 Training(운동종목)을 여러개 가질 수 있고, Training 또한 여러 Customer의 운동기록을 가질 수 있는 M:N의 관계를 가집니다.
>
> 테이블 간의 관계는 Do Train(운동기록)을 통해 Info 테이블에 담기게 됩니다. 아래는 테이블의 상세 명세입니다.

## 테이블 명세

![image-20211111214648279](https://user-images.githubusercontent.com/84169773/141306903-d3d1acf4-9b17-4ad3-a91e-07a803e302fd.png)



- Customer TABLE

  CREATE TABLE customer(
  	id varchar2(10),
  	name varchar2(10) PRIMARY KEY,
  	height number, weight number
  );

- Training TABLE

  CREATE TABLE training(
  	t_name varchar2(10) PRIMARY KEY
  );

  - 운동 목록 추가 

  INSERT INTO training VALUES('가슴삼두');

  INSERT INTO training VALUES('등이두');

  INSERT INTO training VALUES('하체어깨');

  **엇 잠깐, 왜 직접 insert 했을까요 ❓**
  
  ![Sorry](https://user-images.githubusercontent.com/84169773/141306925-bc7511d4-56f6-4c4c-a1df-fcfc6e16c541.jpg)


  > 사실 따로 구현할 수는 있는데 3개밖에 안되기도 하고,,,,ㅎ 죄송합니다

- 회원 기록 TABLE

  CREATE TABLE info(
  	c_name varchar2(10),
  	t_name varchar2(10),
  	tdate date default sysdate,
  	liftweight number,
  	FOREIGN KEY(c_name) REFERENCES customer(name) ON DELETE CASCADE,
  	FOREIGN KEY(t_name) REFERENCES training(t_name) ON DELETE SET NULL
  );

> Name을 Primary Key로 받는 Customer 테이블과 t_name을 Primary Key로 받는 Training 테이블의 다대다 관계는 Info에서 c_name, t_name이라는 Foreign Key로 만나 Info 테이블에서 운동기록을 저장하게 됩니다.

