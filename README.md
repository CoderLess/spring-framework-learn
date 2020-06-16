# spring-framework-learn
## 1. IOC-XML
### 　1.1 ```<beans>``` 
#### 　　1.1.1 标签等价于 @Configuration + @Bean
#### 　　1.1.2 default-lazy-init:设置所有的bean进行懒加载
#### 　　1.1.3 default-autowire-candidates: 用多个(逗号分割)正则表达式匹配参与自动注入的bean的格式
#### 　　1.1.4 default-init-method: 指定默认的初始化方法
#### 　　1.1.5 default-destroy-method: 指定默认的释放方法
### 　1.2 ```<bean>``` 标签
#### 　　1.2.1 ```<property>``` 标签 作用: 给类中的属性赋值.name对应对象中的属性,ref对应另外一个bean的定义  
#### 　　1.2.2 bean的定义相关参数 
　　　　1)ID:如果不指定id和name属性spring会自动生成一个beanName   
　　　　2)Class:如果需要指定静态内部类来初始化bean,则需要使用$符号配合,例如:com.example.SomeThing$OtherThing  
　　　　3)Name:可以用来指定bean的别名,可以指定多个通过```,``` ```;```或```空格```分割都可以  
　　　　4)Scope: 1. singleton(默认) 2. prototype 3.request 4.session 5.application 6.websocket
　　　　5)Constructor arguments  
　　　　6)Properties  
　　　　7)Autowiring mode: 有四种模式 1. 默认,需要指定ref参考ref来注入 2. byName通过bean的name来匹配注入 3. byType通过类型来匹配注入,如果匹配到多个报错,没有匹配到不进行设置  4. constructor跟byType类似  
　　　　8)Lazy initialization mode:  会在第一次调用的时候进行初始化(容器启动时初始化会立即检测配置和环境是否有问题).可以将default-lazy-init="true"配置在beans标签上,
默认所有的实例进行懒加载  
　　　　9)Initialization method: 生命周期函数:初始化  
　　　　10)Destruction method: 生命周期函数:释放资源   
　　　　11)Factory Method: 1.配合class属性使用,工厂方法必须是一个静态方法 2.配合factory-bean使用时可以则无需为静态方法      
　　　　12)Factory Bean: 指定要调用的对象对应的容器中的名字  
　　　　13)Depends On: 如果一个bean间接的依赖其他的bean则需要将被依赖的bean放到depends-on属性中先初始化(例如:jdbc的驱动注册)  
　　　　14)Autowire Candidate:从自动注入的bean中排除指定的bean,将autowire-candidate设置为false(只是针对byType注入而言)
　　　　15)Primary: 如果按照类型进行匹配,匹配到多个优先使用这个
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
### 　1.10 容器合并(主要配置merge="true")
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
### 　1.11 lookup-method 标签:在bean标签内部,指定方法名和对应的bean,这样每次调用这个方法的时候相当于自动注入了这个bean
### 　1.12 replaced-method 标签:在bean标签内部,用另外一个方法替换现有的方法
### 　1.13 生命周期
#### 　　1.13.1 实现InitializingBean 和 DisposableBean 接口
#### 　　1.13.2 使用@PostConstruct 和 @PreDestroy
#### 　　1.13.3 在bean标签上指定init-method 和 destroy-method
###　　1.14 实现BeanPostProcessor接口,可以遍历所有的bean,在bean初始化前后添加自定义逻辑
###　　1.15 PropertySourcesPlaceholderConfigurer
```xml
<bean class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">
    <property name="locations" value="classpath:com/something/jdbc.properties"/>
    <property name="properties">
        <value>custom.strategy.class=com.something.DefaultStrategy</value>
    </property>
</bean>

<bean id="dataSource" destroy-method="close"
        class="org.apache.commons.dbcp.BasicDataSource">
    <property name="driverClassName" value="${jdbc.driverClassName}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>
```
## 2. IOC-ANNOTATION
### 　2.1 如果同时使用xml和Annotation配置bean,xml配置会覆盖annotation配置
### 　2.2 @Autowired : 
#### 　　2.2.1 JSR330标准中的@Inject与@Autowired效果一样
#### 　　2.2.2 给@Autowired的属性required值设置为false
#### 　　2.2.3 @Autowired可以注入数组或list,如果需要指定顺序则需要继承org.springframework.core.Ordered接口/@Order/@Priority
### 　2.3 @Primary : 如果自动注入按照类型匹配到多个优先使用有该注解的bean
### 　2.4 @Qualifier : 通过指明的Qualifier中的值来进行匹配
### 　2.5 @Resource : JSR-250的注释,根据name来进行自动注入
### 　2.6 @Value : 用来注入外部属性   可以配合spel表达式解析属性
### 　2.7 @Component @Repository @Service @Controller : 这几个注解的作用是一样的只是让表达的语义更加明确
### 　2.8 @ComponentScan :使用过滤器自定义扫描 includeFilters:哪些组件需要包含进来  excludeFilters:哪些组件需要排除

