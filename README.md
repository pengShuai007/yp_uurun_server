# yp_uurun_server

微信小程序后台，springboot练习项目

## hello

使用springboot + mybatis 实现简单的增删改查，用于学习微信小程序调用；

* spring boot 基本配置
* mybatis基本配置
* 数据库增删改查操作

  ## springboot + mybatis多数据源配置

  20190129
* 配置mysql、oracle两个数据源
* 实现不同包下dao层查询不同数据库

  ## synchronized同步锁

  ### 对象锁
* 同步代码块形式
* 普通方法➕synchronized形式

对象锁在同一runnable实例多线程调用下保证同步执行，如果是多个runnable实例在多线程调用下会有问题；
例如：类A实现了runnable方法，在类A中使用了对象锁;

 A a = new A(); Thread t1 = new Thread(a); Thread t2 = new Thread(a);线程t1、t2可以同步执行;

 A a1 = new A();  A a2 = new A(); Thread t1 = new Thread(a1); Thread t2 = new Thread(a2);线程t1、t2是不会同步执行的;

### 类锁

* 同步代码块（锁住*.class）
* 静态方法➕synchronized形式

类锁在多个runnable实例多线程调用下保证同步执行，解决了对象锁中描述的问题。

## springboot操作redis

### spring自带redisTemplate操作redis

**相关类：**
RedisConfig、FastJson2JsonRedisSerializer、RedisTemplate、RedisUtil、RedisTestController

### Jedis操作redis

**相关类：**
RedisConfigJedis、RedisByJedisUtil、RedisTestController

### redisTemplate 与 Jedis区别

Jedis是Redis官方推荐的面向Java的操作Redis的客户端；
redisTemplate是SpringDataRedis对JedisApi的高度封装；
redisTemplate比Jedis多了自动管理连接池的特性，官方推荐使用redisTemplate方式；

## redis是单线程还是多线程的，线程安全吗

redis是单线程的

redis是线程安全的

RedisTestController类syncAddRedisValue方法采用线程池方式用100个线程对redis中一个key进行加1操作；
执行完成后，指定key的value增加了100，数据正常。

redis是如何保证线程安全的，首先redis是内存数据库，在内存中进行运算，速度快，其次采用线程封闭的概念，在单线程内完成所有任务。（这块暂时理解不到位）

## redis实现分布式锁

* 设置锁的时候需要设置超时时间，是为了防止客户端崩溃，或者网络出现问题以后锁一直持有，导致死锁；

* 使用setNX命令，保证查询和写入是原子的，value存入requestId；

* 锁释放时需要校验key的value值，保证锁被锁的持有者释放；

* 锁的释放须使用lua脚本，保证操作的原子性，锁释放包含了get、判断、del三个步骤，必须保证三者的一致性。

## mybatis实现一对多多对一查询
一对多查询：collection

多对一查询：association 

具体实现查看HelloDao.xml
## mybatis一对多查询时对象没有无参构造函数怎么处理

## mybatis根据实体生成mapper文件属性

## mybatis中# 与 $ 的区别
二者都用于动态生成SQL语句

其中#表示占位符，在反射生成SQL语句时替换为？,在SQL执行时将对应的?转为对应的参数；

$表示连接符，在反射生成SQL语句时就会替换成对应的参数值；表名为可变参数时使用$符，如果在查询条件中使用$符，则可能存在SQL注入风险；

其中#将参数以字符串拼接，可有效防止SQL注入；$则是直接拼接。
## 如何看懂注解实现方式（例如@Value）

# 面试篇

## 大华面试

详见：大华面试问题汇总.md

## thoughtworks面试前期题目

具体内容在包：com.pengshuai.school.interview.thoughtWorks下面

## springBoot + mybatis + sqlite

代码在sqlite相关包下，sqlite测试数据文件在data目录下
请求URL：
http://localhost:8088/uu/sqliteDemo/getList