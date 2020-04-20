# Spring Cloud 负载均衡
Netflix Ribbon 一套实现相对简单(薄弱) 客户端负载均衡框架

## 负载均衡算法
* 轮询
* 随机
* 最小活跃(LRU)

## 复杂负载均衡算法(多因子Factors)
* 权重因子
* 负载情况(CPU,Load)
* 响应时间(Response Time

## Ribbon负载均衡算法

### 核心接口 

com.netflix.loadbalancer.IRule
