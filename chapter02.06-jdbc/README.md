# Spring Boot Native JDBC Example 

Spring Boot Native JDBC 구현 예제

## 예제 실행 방법

JUnit이나 Swagger UI를 통하여 예제 내용을 실행해 볼 수 있다.
스프링 빈의 생성 과정을 확인하기 위하여 log4j2.xml에 스프링 빈 생성에 관련된 디버그 로그설정이 추가되어 있다.

```xml
<Logger additivity="false" level="DEBUG" name="org.springframework.beans.factory.support.DefaultListableBeanFactory">
	<AppenderRef ref="ConsoleAppender" />
	<AppenderRef ref="AsyncRollingAppender" />
</Logger>
```

### SpringBoot Application 실행

```shell
java -jar customer-0.0.1-SNAPSHOT.jar
```

### junit 실행

1. Select org.objectworld.book.customer.service.test.CustomerServiceTest in the src/test/java Folder
1. Run As - jUnit Test

### Swagger 접속

1. http://localhost:8080/swagger-ui.html