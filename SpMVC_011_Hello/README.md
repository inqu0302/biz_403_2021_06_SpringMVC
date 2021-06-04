# WAS(Web Application Service, Web Application Server)에서 HTTP Status 코드

## 정상적인 Request와 Response가 이루어졌을 때 
* 200 : 가장 완벽한 상태
* 300 : Redirection이 되거나, 이전 응답과 동일한 결과일때

## Request가 잘못되었을 때
* 404 : URI를 잘못 요청했을때, Tomcat Server의 method에서 Rendering할 JSP파일을 찾지 못했을때(메시지가 포함)
* 405 : Request한 URI의 mapping을 찾을 수 있으나, RequestMethod 가 해당하는 항목이 없을때
* 400 : 서버에 데이터를 전송시 데이터 type이 잘못되었을 경우
		예) Java method의 매개변수가 숫자형일때 전송하는 데이터에 공백, 문자열, null값이 포함되어 있는 경우

## 서버 내부 오류
* 500 : 내부에서 코드가 실행되는 동안 Exception이 발생하는 경우 오류메시지를 검토하여 찾아야 한다.
		개발자가 만든 코드 메시지 찾기, exception종류 이해하기


