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

## redis实现分布式锁

## 如何看懂注解实现方式（例如@Values）