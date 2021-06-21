# Spring No qualifying bean 오류 찾기
### 원인
* 클래스를 컴파일하여 객체로 준비하지 못하였다.
* bean 으로 설정된 부분에 문제가 있다.
* @Component(Controller, Service, Repositiory... ) 설정문제

### 해결방법
* -context.xml 파일에 사용하고자 하는 클래스를 bean 으로 설정했는가 확인
	각 클래스마다 bean설정 방법에 따라 정확히 문법이 구현되었는가
* web.xml에서 해당 -context.xml 파일을 잘 읽고 있는가 
	appServlet/*-context.xml 설정으로 해결가능
* Servlet-context.xml 의 component-scan base-package 항목의 packgae 설정이 잘 되었는지 확인
* 각 Component 클래스의 Component Annotation 이 잘 설정되었나 확인
* 한개의 interface를 상속받은 클래스가 다수 있을때 사용하고자 하는 클래스를 잘 지정했는가