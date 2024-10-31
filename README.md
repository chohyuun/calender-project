# 일정 관리 앱 만들기

스파르타 코딩 클럽 내일배움캠프 개인 과제 일정 관리 앱 만들기입니다.

## API 명세서

필수 기능 구현 시의 API

| 기능       | method | endpoint                 | request                                                                                                                                                                                   | response                                                                                                                                                          |
|----------|--------|--------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 추가    | POST   | /schedules               | {<br/>"schedule_id" : "int", <br/>"name" : "string(30)", <br/>"password" : "string(50)", <br/>"create_date" : "date",<br/>"modified_date" : "date", <br/>"contents" : "string(300)"<br/>} | 200<br/>{<br/>"message" : "일정 등록 성공"<br/>}                                                                                                                        |
| 전체 일정 조회 | GET    | /schedules               |                                                                                                                                                                                           | 200<br/>{<br/>"schedule_id" : "int", <br/>"name" : "string(30)", <br/>"create_date" : "date",<br/>"modified_date" : "date", <br/>"contents" : "string(300)"<br/>} |
| 일정 조회    | GET    | /schedules/{schedule_id} | {<br/>"name" : "string(30)"<br/>}                                                                                                                                                         | 200<br/>{<br/>"schedule_id" : "int", <br/>"name" : "string(30)", <br/>"create_date" : "date",<br/>"modified_date" : "date", <br/>"contents" : "string(300)"<br/>} |
| 일정 수정    | PUT    | /schedules/{schedule_id} | {<br/>"modified_date" : "date", <br/>"password" : "string", <br/>"contents" : "string(300)"<br/>}                                                                                         | 200<br/>{<br/>"message" : "일정 수정 성공"<br/>}<br/><br/>403<br/>{<br/>"message" : "비밀번호가 틀렸습니다."<br/>}                                                                |
| 일정 삭제    | DELETE | /schedules/{schedule_id} | {<br/>"password" : "string(50)"<br/>}                                                                                                                                                     | 200<br/>{<br/>"message" : "일정 삭제 성공"<br/>}<br/><br/>403<br/>{<br/>"message" : "비밀번호가 틀렸습니다."<br/>}                                                                |

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

https://www.erdcloud.com/d/2Zsc7kXY9F4hv6zv7
