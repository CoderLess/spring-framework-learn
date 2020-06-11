# spring-framework-learn
## 1. IOC-XML
### 　1.1 ```<beans>``` 
#### 　　1.1.1 标签等价于 @Configuration + @Bean
### 　1.2 ```<bean>``` 标签
#### 　　1.2.1 ```<property>``` 标签 作用: 给类中的属性赋值.name对应对象中的属性,ref对应另外一个bean的定义  
#### 　　1.2.2 bean的定义相关参数 
　　　　1)ID:如果不指定id和name属性spring会自动生成一个beanName   
　　　　2)Class:如果需要指定静态内部类来初始化bean,则需要使用$符号配合,例如:com.example.SomeThing$OtherThing
　　　　3)Name:可以用来指定bean的别名,可以指定多个通过```,``` ```;```或```空格```分割都可以  
　　　　4)Scope  
　　　　5)Constructor arguments  
　　　　6)Properties  
　　　　7)Autowiring mode  
　　　　8)Lazy initialization mode  
　　　　9)Initialization method  
　　　　10)Destruction method   
　　　　11)Factory Method: 1.配合class属性使用,工厂方法必须是一个静态方法 2.配合factory-bean使用时可以则无需为静态方法      
　　　　12)Factory Bean: 指定要调用的对象对应的容器中的名字
#### 　　1.2.3 bean定义的几种方式
　　　　1)XML配置  
　　　　2)Annotaion  
　　　　3)DefaultListableBeanFactory的registerSingleton(..) 和 registerBeanDefinition(..)注册  
### 　1.3 ```<import>``` 标签 作用: 导入其他xml中的bean
### 　1.4 ```<alias >``` 标签 作用: 在bean声明的外部给bean取个别名,作用等同于bean标签内部的name.
### 　1.5 ```依赖注入``` 这是一个参数自动注入的过程
#### 　　1.5.1 构造器注入(会有循环依赖的问题)
　　　　1)构造参数分析:如果指定类型,spring会在容器内查找指定的类型,并按照参数的顺序进行初始化响应的bean,constructor-arg标签中用ref指定需要引用的bean的id   
　　　　2)构造参数类型匹配:通过参数的类型进行匹配,constructor-arg标签中用type指定参数类型      
　　　　3)构造参数索引:通过参数的索引进行匹配,constructor-arg标签中用index指定参数位置进行匹配
　　　　4)构造参数名字:通过指定参数的名字匹配,constructor-arg标签中用name指定参数名字进行匹配(需要保证编译debug标签通过或者使用@ConstructorProperties来声明)
#### 　　1.5.2 setter注入(不会有循环依赖的问题)
### 　1.6 直接声明值
#### 　　1.6.1 property标签中声明
```xml
<bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
    <!-- results in a setDriverClassName(String) call -->
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/mydb"/>
    <property name="username" value="root"/>
    <property name="password" value="masterkaoli"/>
</bean>
```
#### 　　1.6.2 p命名空间
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource"
        destroy-method="close"
        p:driverClassName="com.mysql.jdbc.Driver"
        p:url="jdbc:mysql://localhost:3306/mydb"
        p:username="root"
        p:password="masterkaoli"/>

</beans>
```
#### 　　1.6.3 配置一个properties实例
```xml
<bean id="mappings"
    class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">

    <!-- typed as a java.util.Properties -->
    <property name="properties">
        <value>
            jdbc.driver.className=com.mysql.jdbc.Driver
            jdbc.url=jdbc:mysql://localhost:3306/mydb
        </value>
    </property>
</bean>
```
### 　1.7 ```<idref >```标签: 会提前检查bean对应的id是否存在
### 　1.8 嵌套Bean(嵌套bean不需要定义id和name)
```xml
<bean id="outer" class="...">
    <!-- instead of using a reference to a target bean, simply define the target bean inline -->
    <property name="target">
        <bean class="com.example.Person"> <!-- this is the inner bean -->
            <property name="name" value="Fiona Apple"/>
            <property name="age" value="25"/>
        </bean>
    </property>
</bean>
```
### 　1.9 容器
```xml
<bean id="moreComplexObject" class="example.ComplexObject">
    <!-- results in a setAdminEmails(java.util.Properties) call -->
    <property name="adminEmails">
        <props>
            <prop key="administrator">administrator@example.org</prop>
            <prop key="support">support@example.org</prop>
            <prop key="development">development@example.org</prop>
        </props>
    </property>
    <!-- results in a setSomeList(java.util.List) call -->
    <property name="someList">
        <list>
            <value>a list element followed by a reference</value>
            <ref bean="myDataSource" />
        </list>
    </property>
    <!-- results in a setSomeMap(java.util.Map) call -->
    <property name="someMap">
        <map>
            <entry key="an entry" value="just some string"/>
            <entry key ="a ref" value-ref="myDataSource"/>
        </map>
    </property>
    <!-- results in a setSomeSet(java.util.Set) call -->
    <property name="someSet">
        <set>
            <value>just some string</value>
            <ref bean="myDataSource" />
        </set>
    </property>
</bean>
```
### 　2.0 容器合并(主要配置merge="true")
```xml
<beans>
    <bean id="parent" abstract="true" class="example.ComplexObject">
        <property name="adminEmails">
            <props>
                <prop key="administrator">administrator@example.com</prop>
                <prop key="support">support@example.com</prop>
            </props>
        </property>
    </bean>
    <bean id="child" parent="parent">
        <property name="adminEmails">
            <!-- the merge is specified on the child collection definition -->
            <props merge="true">
                <prop key="sales">sales@example.com</prop>
                <prop key="support">support@example.co.uk</prop>
            </props>
        </property>
    </bean>
<beans>
```

