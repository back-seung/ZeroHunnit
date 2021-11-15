# ZeroHunnit

> ZeroHunnit은 사용자의 개인 운동(운동부위, 날짜, 총 무게)을 기록할 수 있고, 누적된 기록을 확인할 수 있으며, 사용자의 든 무게의 총합을 통해 Ranking으로 보여주어 사용자 간 운동에 대한 동기부여를 유발하는 프로그램입니다.

## 소개

🙋‍♂️ 참가인원 : 백승한 윤백선

⏳ 소요기간 : 2021.11.11 13:00 ~ 현재 제작 중

🛠 사용 Tool

* <img src="C:\Users\seung\Downloads\java_original_wordmark_logo_icon_146459 (1).png" alt="java_original_wordmark_logo_icon_146459 (1)" style="zoom:5%;" /> JavaSE-1.8
* <img src="C:\Users\seung\Downloads\eclipse_94656.png" alt="eclipse_94656" style="zoom:5%;" /> Eclipse jee 2021-06
* <img src="C:\Users\seung\Downloads\git_original_wordmark_logo_icon_146510.png" alt="git_original_wordmark_logo_icon_146510" style="zoom:5%;" /> Git
* <img src="C:\Users\seung\Downloads\oracle_original_logo_icon_146401.png" alt="oracle_original_logo_icon_146401" style="zoom:6%;" /> Oracle 11.2.0.1.0

💻 DevOps

* <img src="C:\Users\seung\Downloads\github_original_wordmark_logo_icon_146506.png" alt="github_original_wordmark_logo_icon_146506" style="zoom:5%;" /> GitHub



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

## Flow Chart 

![image-20211115114622853](C:\Users\seung\AppData\Roaming\Typora\typora-user-images\image-20211115114622853.png)

## 프로젝트 Todo's

https://github.com/seunghan-baek/ZeroHunnit/projects/2

![image-20211115120734501](C:\Users\seung\AppData\Roaming\Typora\typora-user-images\image-20211115120734501.png)

> github의 project 탭을 응용하여 각자의 TodoList를 서로에게 공유하며 협업하였습니다.
>
> To do에는 예정된 할 일 및 당일 해결과제 등을 정리하여 적어두었고 Todo를 진행시에는 In progress 탭으로, 작업이 마무리 되면 Pull & Request와 더불어 Done 탭에 옮기며 말해주는 것으로 각자의 작업이 어느 정도 마무리 되었는지 확인이 가능했습니다.
>
> 특히 In progress에서 서로 필요시에 Project를 봐달라는 요청에 따라 발생한 문제점을 즉각 확인하고 토의하여 오류를 개선하는것에서 Project 탭을 활용하는 것은 협업에 있어 매우 편리하였습니다.



## Pull & Request, Networks

<img src="C:\Users\seung\AppData\Roaming\Typora\typora-user-images\image-20211115122056890.png" alt="image-20211115122056890" style="zoom:67%;" /><img src="C:\Users\seung\AppData\Roaming\Typora\typora-user-images\image-20211115122110660.png" alt="image-20211115122110660" style="zoom:67%;" />

11일부터 각자 
