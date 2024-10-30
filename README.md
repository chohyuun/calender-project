# 일정 관리 앱 만들기
스파르타 코딩 클럽 내일배움캠프 개인 과제 일정 관리 앱 만들기입니다.

## API 명세서
필수 기능 구현 시의 API

| 기능       | method | endpoint                | request                                                                                                                                                                                    | response                                                                                                                                                          |
|----------|--------|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 추가    | POST   | /calender               | {<br/>"schedule_id" : "int", <br/>"user_name" : "string", <br/>"user_password" : "string", <br/>"create_date" : "string",<br/>"modified_date" : "string", <br/>"contents" : "string"<br/>} | 200<br/>{<br/>"message" : "일정 등록 성공"<br/>}                                                                                                                        |
| 전체 일정 조회 | GET    | /calender               |                                                                                                                                                                                            | 200<br/>{<br/>"schedule_id" : "int", <br/>"user_name" : "string", <br/>"create_date" : "string",<br/>"modified_date" : "string", <br/>"contents" : "string"<br/>} |
| 일정 조회    | GET    | /calender/{schedule_id} | {<br/>"user_name" : "string"<br/>}                                                                                                                                                         | 200<br/>{<br/>"schedule_id" : "int", <br/>"user_name" : "string", <br/>"create_date" : "string",<br/>"modified_date" : "string", <br/>"contents" : "string"<br/>} |
| 일정 수정    | PUT    | /calender/{schedule_id} | {<br/>"user_name" : "string", <br/>"modified_date" : "string", <br/>"user_password" : "string", <br/>"contents" : "string"<br/>}                                                           | 200<br/>{<br/>"message" : "일정 수정 성공"<br/>}                                                                                                                        |
| 일정 삭제    | DELETE | /calender/{schedule_id} | {<br/>"password" : "string"<br/>}                                                                                                                                                          | 200<br/>{<br/>"message" : "일정 삭제 성공"<br/>}                                                                                                                        |

## ERD
https://www.erdcloud.com/d/2Zsc7kXY9F4hv6zv7
