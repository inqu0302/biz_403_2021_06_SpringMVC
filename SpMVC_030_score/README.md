# Spring MyBatis Project

### Depenency 설정
* mybatis : 최신버전
* mybaits-spring : 최신버전
* commons-dbcp2 : 최신버전(commons-dbcp 와는 다름)

### commons-dbcp2
* apache 재단에서 만든 DB Connection 도구
* DB 연결을 pool을 사용하여 많은 동시 접속을 효율적으로 처리
* 기본적으로 DB 연결 Connection을 미리(10개)만들어 두고 연결요청이 오면 그 중 1개를 연결하는 통로를 제공한다.

### mybatis
* mybaits는 DB 연동과 관련된 상당히 많은 부분의 코드를 직접 작성하지 않고 수행할 수 있도록 도와주는 DB 연결 Lib
* 현재 진행중인 DB연동이 이루어지는 Spring Project에서는 거의 mybatis를 활용한 DB연결이 이루어진다.

# Spring DB 연동 프로젝트 작성
1. 기본 SpringMVC 프로젝트 생성
2. pom.xml에 Spring 관련 기본 Dependency 설정
3. mybatis 관련 Dependency 설정
4. 프로젝트가 정상적으로 구동하는지 확인하기
5. mybatis-context.xml을 작성하기
6. DBMS에 table생성하기 (test용 데이터 insert)
7. model class(VO, DTO)생성하기
8. DAO 생성 - > Service 생성 - > Controller 생성
9. client에서 Request하여 Controller에 요청후 데이터가 정상적으로 select되는지 log를 통해 확인