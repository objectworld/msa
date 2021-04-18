# Spring Boot Lombok Example

Lombok Examples 

### Lombok Maven Package

```xml
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<optional>true</optional>
</dependency>
```

### JUnit5 Maven Package

```xml
<properties>
	<junit.jupiter.version>5.7.1</junit.jupiter.version>
	<junit.platform.version>1.7.1</junit.platform.version>
</properties>

<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-engine</artifactId>
	<version>${junit.jupiter.version}</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.junit.platform</groupId>
	<artifactId>junit-platform-runner</artifactId>
	<version>${junit.platform.version}</version>
	<scope>test</scope>
</dependency>
```

### Lombok Examples

1. Constructor : Customer.java
1. ToString : ToStringTest.java
1. EqualsAndHashCode : EqualsTest.java
1. Data : Customer.java
1. StreamDemo.java
1. Log
   - WithoutLombokClass.ava
   - WithoutLombokMain.java
   - WithLombokClass.ava
   - WithLombokMain.java


