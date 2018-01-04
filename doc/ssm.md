1、配置spring
	1>添加jar包，配置pom.xml
		<!-- 配置一个全局变量，存储spring框架的版本号 -->
		<properties>
			<spring.version>5.0.2.RELEASE</spring.version>
		</properties>
		<!-- 添加jar包 -->
		<dependencies>
			<dependency>
				<groupId>junit</groupId>
				<artifactId>junit</artifactId>
				<version>4.12</version>
				<scope>test</scope>
			</dependency>
			<dependency>
				<groupId>javax.servlet</groupId>
				<artifactId>javax.servlet-api</artifactId>
				<version>3.1.0</version>
			</dependency>
			<dependency>
				<groupId>commons-logging</groupId>
				<artifactId>commons-logging</artifactId>
				<version>1.2</version>
			</dependency>
			<dependency>
				<groupId>com.alibaba</groupId>
				<artifactId>druid</artifactId>
				<version>1.1.6</version>
			</dependency>
			<dependency>
				<groupId>mysql</groupId>
				<artifactId>mysql-connector-java</artifactId>
				<version>5.1.38</version>
			</dependency>
			<!-- spring框架jar -->
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-context</artifactId>
				<version>${spring.version}</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-core</artifactId>
				<version>${spring.version}</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-web</artifactId>
				<version>${spring.version}</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-context-support</artifactId>
				<version>${spring.version}</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-webmvc</artifactId>
				<version>${spring.version}</version>
			</dependency>
		</dependencies>
	2>配置web.xml
		<!-- 监听器 -->
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		<!-- 装配applicationContext配置信息  -->
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:config/spring/applicationContext.xml</param-value>
		</context-param>
	3>配置springIOC容器bean的扫描及数据源的基本配置
		(1)applicationContext.xml
			<?xml version="1.0" encoding="UTF-8"?>
			<beans xmlns="http://www.springframework.org/schema/beans"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			xmlns:context="http://www.springframework.org/schema/context"
			xsi:schemaLocation="http://www.springframework.org/schema/beans
	               http://www.springframework.org/schema/beans/spring-beans.xsd
	               http://www.springframework.org/schema/context
	               http://www.springframework.org/schema/context/spring-context.xsd ">
			    <!-- 自动装配 -->         
				<context:component-scan 					base-package="com.xtit.ssm.*.dao"></context:component-scan>       
				<context:component-scan 					base-package="com.xtit.ssm.*.service"></context:component-scan>             
			    <!-- 加载数据库配置 -->   
			    <import resource="applicationContest-db.xml"/>      
			</beans>
		(2)applicationContext-db.xml
			<?xml version="1.0" encoding="UTF-8"?>
			<beans xmlns="http://www.springframework.org/schema/beans"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			xmlns:context="http://www.springframework.org/schema/context"
			xmlns:tx="http://www.springframework.org/schema/tx"
			xmlns:aop="http://www.springframework.org/schema/aop"
			xsi:schemaLocation="http://www.springframework.org/schema/beans
	               http://www.springframework.org/schema/beans/spring-beans.xsd
	               http://www.springframework.org/schema/context
	               http://www.springframework.org/schema/context/spring-context.xsd
	               http://www.springframework.org/schema/tx
	               http://www.springframework.org/schema/tx/spring-tx.xsd 
	               http://www.springframework.org/schema/aop
	               http://www.springframework.org/schema/aop/spring-aop.xsd">
				<!-- 数据库连接池 -->
				<context:property-placeholder location="classpath:config/DB.properties"/> 
				<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
					<property name="driverClassName" value="${mysql_driverName}"></property>
					<property name="url" value="${mysql_url}"></property>
					<property name="username" value="${mysql_user}"></property>
					<property name="password" value="${mysql_passwd}"></property>
				</bean> 
			</beans>
2、配置springMVC
	1>在web.xml配置前端控制器
		<!-- 配置前端控制器 -->
		<servlet>
			<servlet-name>DispatcherServlet</servlet-name>
			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
			<init-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>classpath:config/spring/applicationContext-mvc.xml</param-value>
			</init-param>
		</servlet>
		<servlet-mapping>
			<servlet-name>DispatcherServlet</servlet-name>
			<!-- 前端页面→/;后端系统→*.action -->
			<url-pattern>/</url-pattern>
		</servlet-mapping>
	2>配置springmvc配置文件applicationContext-mvc.xml
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:mvc="http://www.springframework.org/schema/mvc"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
	           http://www.springframework.org/schema/beans/spring-beans.xsd
	           http://www.springframework.org/schema/mvc
	           http://www.springframework.org/schema/mvc/spring-mvc.xsd
	           http://www.springframework.org/schema/context
	           http://www.springframework.org/schema/context/spring-context.xsd ">       
			<!-- 配置自动扫描，将所有的Controller扫描到IOC容器 -->               
			<context:component-scan base-package="com.xtit.ssm.*.action"></context:component-scan>
			<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		    	<property name="prefix" value="/views/"></property>
		    	<property name="suffix" value=".jsp"></property>
		    </bean> 
		    <!-- 处理静态资源请求，非静态转移至DispatcherServlet -->
			<mvc:default-servlet-handler />
			<!-- 提供Controller请求转发，json自动转化等功能 -->
			<mvc:annotation-driven></mvc:annotation-driven>
		</beans>
3、配置Mybatis
	1>添加jar包，配置pom.xml
		<!-- jar包 -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.4.1</version>
		</dependency>
		<!-- spring-mybatie整合包 -->
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis-spring</artifactId>
		    <version>1.3.0</version>
		</dependency>
	2>配置SqlMapConfig.xml
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE configuration
		  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
		  "http://mybatis.org/dtd/mybatis-3-config.dtd">
		<configuration>
			<!-- 二级缓存配置 -->
			<settings>
				<setting name="cacheEnabled" value="true"/>
			</settings>
			<!-- 
				注册mapper 
				<mappers>
					<package name="com.xtit.ssm.test.entity"/>
				</mappers>
			-->
		</configuration>
	3>在applicationContext-mvc.xml文件中，配置SqlMapConfig.xml
		<!-- 配置session工厂bean文件 -->
		<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
			<property name="dataSource" ref="dataSource"></property>
			<property name="configLocation" 				value="classpath:config/mybatis/SqlMapConfig.xml"></property>
		</bean>
		<!-- 将对应的接口的类型改造为MapperFactoryBean -->
		<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
			<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
			<property name="basePackage" value="com.xtit.ssm.*.dao"></property>
		</bean>
4、ioc相关配置
	1>配置applicationContext-ioc.xml文件
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
               http://www.springframework.org/schema/beans/spring-beans.xsd
               http://www.springframework.org/schema/context
               http://www.springframework.org/schema/context/spring-context.xsd ">     
			<bean id="stuService" class="com.xtit.ssm.test.service.student.StuService">
				<property name="stuDao" ref="stuDao"></property>
			</bean> 
		</beans>
	2>在applicationContext.xml文件中载入applicationContext-ioc.xml文件
		<import resource="classpath:config/spring/applicationContext-ioc.xml"/>
	3>删除手动装配的javabean文件中相关的注解