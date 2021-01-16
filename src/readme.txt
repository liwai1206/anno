注解是JDK1.5的新特性，java SE1.5三个内置注解
    @override   表示当前方法的定义将覆盖父类中的方法
    @Deprecated     表示抗疫、反对、过时的。
    @SuppressWarnings   压制警告

四中元注解
@Target 表示该注解用在什么地方，可选值ElementType有：
    Constructor : 构造方法
    field : 属性、字段
    local_variavle : 局部变量
    method :方法
    package : 包
    parameter : 形参
    type : 类、接口

@Retention : 表示在什么级别保存该注解信息，可选值RetentionPolicy有
    source : 源码级，说明该注解会被编译器丢弃
    class ： 字节码级，说明该注解会被JVM丢弃
    runtime：将JVM运行期间保留，因此可以通过反射机制来读取这个注解信息

@Documented ： 将此注解包含到javadoc中

@Inherited ： 遗传，允许子类继承父类中的注解