# TIAVGN (RABBIT JAVA LEARNING)

Learning about RabbitMQ (Server/CLI/Management) and using java library.

## RabbitMQ Documentation

Reading documentation about [RabbitMQ](https://www.rabbitmq.com/docs).

## RabbitMQ Server

To avoid installing Erlang language on local system.

Using [Docker](https://www.docker.com/) image to start the server on local system.

[Image](https://hub.docker.com/layers/library/rabbitmq/4-alpine/images/sha256-7cfaf12a05023c3c6c992f137e8d752d860a64ce40b4991e9973a437492c06df?context=explore) of RabbitMQ Server.

```shell
docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:4-alpine
```

Accessing inside docker shell to use [rabbitmqctl](https://www.rabbitmq.com/docs/man/rabbitmqctl.8).

Playing with rabbitmqctl to interact with the server.

## Java Client

The library/dependency can be found on [Maven Repository](https://mvnrepository.com/artifact/com.rabbitmq/amqp-client/5.22.0).

Using Gradle(Kotlin DSL).

### Open Port of Rabbit Image

To enabling the interaction with the rabbitmq server on the container, we need to open the port.

```shell
docker run -d --hostname my-rabbit --name some-rabbit -p 5672:5672 rabbitmq:4-alpine
```