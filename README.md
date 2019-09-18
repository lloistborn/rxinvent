# rxinvent
spring reactor implementation for inventory management. (*in progress documentation*)

## intro
rxinvent aims to implement the latest technology that integrated using 
- `Spring Boot` 
- `Reactor-MongoDB-Redis-Kafka` 
- `GraalVM` 
- `Docker` 
- `Kubernetes` (context-dekstop)
- `Prometheus` and 
- `Grafana`

It is mandatory for you to have `maven`, `docker` and `kubernetes` installed on your machine.

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

## testing

### docker ps
in separate terminal, make sure all the container running well by using command `docker ps`. we should see `Prometheus`, `Grafana` `springio/inventory-management` and `mongo` container are running.
```

```

### actuator
> in essence, Actuator brings production-ready features to our application.
Monitoring our app, gathering metrics, understanding traffic or the state of our database becomes trivial with this dependency.
The main benefit of this library is that we can get production grade tools without having to actually implement these features ourselves.

to run actuator, go to `localhost:8080/actuator`

### mongodb
by default, whenever we successfully run this project, there are some data inserted to mongo documents.

to check them, run our favorite client and add connection `localhost:27017`.

### prometheus together with grafana
> Prometheus, a Cloud Native Computing Foundation project, is a systems and service monitoring system. It collects metrics from configured targets at given intervals, evaluates rule expressions, displays the results, and can trigger alerts if some condition is observed to be true.

> Grafana is an open source visualization tool that can be used on top of a variety of different data stores.

go check prometheus on `locahost:9090` and grafana `localhost:3000`

