# 일정 관리 앱 만들기

스파르타 코딩 클럽 내일배움캠프 개인 과제 일정 관리 앱 만들기입니다.

## 사용 기술

JAVA : JDK 17
Spring Boot : 3.3.5
IDE : IntelliJ

## 개발 목표
- 일정을 등록 할 수 있다.
- 일정을 조회 할 수 있다.(전체 조회, 단건 조회)
- 일정을 수정 할 수 있다.(제목, 이름, 내용만 수정 가능)
  - 수정할 경우 수정한 일자가 변경 된다.
- 일정을 삭제 할 수 있다.

## API 명세서

필수 기능 구현 시의 API

| 기능       | method | endpoint        | request                                                                                                                                                                                                       | response                                                                                                                                                                                                                                      |
|----------|--------|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 추가    | POST   | /schedules      | {<br/>"id" : "int", <br/>"name" : "string(30)", <br/>"password" : "string(50)", <br/>"create_date" : "date",<br/>"modified_date" : "date", <br/>"contents" : "string(300)",<br/>"title" : "string(100)"<br/>} | 200<br/>{<br/>"message" : "일정 등록 성공"<br/>}                                                                                                                                                                                                    |
| 전체 일정 조회 | GET    | /schedules      |                                                                                                                                                                                                               | 200<br/>{<br/>"id" : "int", <br/>"name" : "string(30)", <br/>"create_date" : "date",<br/>"modified_date" : "date", <br/>"contents" : "string(300)",<br/>"title" : "string(100)"<br/>}                                                         |
| 일정 조회    | GET    | /schedules/{id} |                                                                                                                                                                                                               | 200<br/>{<br/>"id" : "int", <br/>"name" : "string(30)", <br/>"create_date" : "date",<br/>"modified_date" : "date", <br/>"contents" : "string(300)",<br/>"title" : "string(100)"<br/>}                                                         |
| 일정 수정    | PUT    | /schedules/{id} | {<br/>"modified_date" : "date", <br/>"password" : "string", <br/>"contents" : "string(300)",<br/>"title" : "string(100)"<br/>}                                                                                | 200<br/>{<br/>"id" : "int", <br/>"name" : "string(30)", <br/>"create_date" : "date",<br/>"modified_date" : "date", <br/>"contents" : "string(300)",<br/>"title" : "string(100)"<br/>}<br/><br/>403<br/>{<br/>"message" : "비밀번호가 틀렸습니다."<br/>} |
| 일정 삭제    | DELETE | /schedules/{id} | {<br/>"password" : "string(50)"<br/>}                                                                                                                                                                         | 200<br/>{<br/>"message" : "일정 삭제 성공"<br/>}<br/><br/>403<br/>{<br/>"message" : "비밀번호가 틀렸습니다."<br/>}                                                                                                                                            |

### 공통 Error 메시지

- 전체 공통
    - 500 Server Error { "message" : "서버에 접근 할 수 없습니다." }


- 전체 일정 조회, 일정 조회, 일정 수정
    - 전체 캘린더에서 생성된 일정이 없을 경우
        - 404 Not Fount { "message" : "일정이 없습니다." }


- 일정 조회, 일정 수정, 일정 삭제
    - 선택한 schedule_id 가 없을 경우
        - 400 Bad Request { "message" : "없는 일정 입니다." }

## ERD
<img width="353" alt="스크린샷 2024-11-08 오전 7 48 31" src="https://github.com/user-attachments/assets/54872cb4-3d33-4672-8104-4c4517ef28eb">

## 추가 할 사항
- 유저 테이블 추가 후 외래키를 이용한 연결
- 페이지 네이션 등록
- 예외처리 추가
- null 제크 및 패턴 검증 수행