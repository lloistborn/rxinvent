# rxinvent
spring reactor implementation for inventory management

## intro
rxinvent aims to implement the latest technology that integrated using 
`Spring Boot` `Reactor-MongoDB-Redis-Kafka` `GraalVM` `Docker` `Kubernetes` `Prometheus` and `Grafana`.

## usage
1. `git clone github.com/lloistborn/rxinvent.git`
2. run `mvn clean package dockerfile:build` to build the docker images from this repo on top of `GraalVM`
3. run `docker-compose up` to run them all
if everyhting was alright then you should see `Netty`running on port `8080`
```
spring-boot    | 2018-11-10 13:15:34.113  INFO 1 --- [           main] o.s.i.endpoint.EventDrivenConsumer       : started _org.springframework.integration.errorLogger
spring-boot    | 2018-11-10 13:15:34.113  INFO 1 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483547
spring-boot    | 2018-11-10 13:15:34.317  INFO 1 --- [-server-epoll-5] r.ipc.netty.tcp.BlockingNettyContext     : Started HttpServer on /0.0.0.0:8080
spring-boot    | 2018-11-10 13:15:34.319  INFO 1 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port(s): 8080
```

