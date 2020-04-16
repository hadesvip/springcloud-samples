#  Spring Cloud 服务调用与发现

## 核心概念





### webservice

#### xml约束

* DTD
* XSD（Schema） 强类型

### JSON

#### Open API Specification



## Spring Cloud Open Feign

Feign、Spring Cloud Open Feign、JAX-RS、Spring Web MVC 注解驱动特性

| REST 框架               | 使用场景           | 请求映射注解    | 请求参数      |
| ----------------------- | ------------------ | --------------- | ------------- |
| Feign                   | 客户端声明         | @RequestLine    | @Param        |
| Spring Cloud Open Feign | 客户端声明         | @RequestMapping | @RequestParam |
| JAX-RS                  | 客户端、服务端声明 | @Path           | @*Param       |
| Spring Web MVC          | 服务端声明         | @RequestMapping | @RequestParam |



Spring Cloud Open Feign 利用Feign高扩展性，使用标准 Spring Web MVC 来声明客户端Java接口

* Feign

  * 注解扩展性
  * HTTP 请求处理
  * REST请求元信息解析

* Spring Cloud Open Feign

  * 提供Spring Web MVC 注解处理

  * 提供 Feign 自动装配

    

Spring Cloud Open Feign 是通过Java 接口的方式来声明REST服务提供者的请求元信息，通过调用Java接口的方式来实现HTTP/REST 通讯。

### 实现细节猜想

* Java 接口(以及方法) 与Rest 提供者元信息如何映射
* **@FeignClient** 注解所指定的应用(服务)名称可能用到了服务发现，一个服务可以对应多个服务实例(HOST:PORT)
* **@EnableFeignClients** 注解是如何感知或加载标注的 **@FeignClient** 的配置类（Bean）
* Feign请求和响应的内容是如何序列化和反序列化对应的POJO的

### Feign
``https://github.com/openfeign/feign``

#### 注解支持

* 内建Feign注解
* JAX-RX 1/2注解
* JAXB
* OkHttp

#### 基本步骤

1.  增加依赖

   ```java
   org.springframework.cloud:spring-cloud-starter-openfeign
   ```

   

2.  激活Feign客户端

   ```java
   @SpringBootApplication
   @EnableFeignClients
   public class Application {
   
       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
   }
   ```

   

3.  定义Feign的接口

   ```java
   @FeignClient("stores") // "store" 应用(服务)的名称
   public interface StoreClient {
       @RequestMapping(method = RequestMethod.GET, value = "/stores")
       List<Store> getStores();
   
       @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
       Store update(@PathVariable("storeId") Long storeId, Store store);
   }
   ```






## 常见的 SpringBoot/Spring Cloud 中的坑

1.  **@value("server.port")**  服务端端口不一定靠谱，当server.port=0时

2.  **@LocalServerPort** 也不靠谱，因为在注入阶段"local..server.port" 不一定存在

3.  Spring Cloud + Netflix Ribbon 有一个30秒的延迟

   ![image-20200414205530611](.\images\image-20200414205530611.png)



spring cloud 服务调用

* 服务发现 DiscoveryClient (Erueka,zk,consul等)
* 负载均衡-Netfix Ribbon （唯一选择）
* Fegin(唯一选择)





## Spring Cloud OpenFeign 实现细节

### @EnableFeignClients

实现策略: Enable模块驱动

具体实现:  ``org.springframework.cloud.openfeign.FeignClientsRegistrar``

主要工作: 

* 注册默认配置

*  注册所有标注`` @FeignClient`` 默认类

   源码位置：``org.springframework.cloud.openfeign.FeignClientsRegistrar#registerFeignClients`` 

  ​	



