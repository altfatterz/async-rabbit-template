AsyncRabbitTemplate with Spring Boot

Sample project used in

1. Build the project

```
$ git clone https://github.com/altfatterz/async-rabbit-template
$ cd rabbit-dead-letter-queue
$ mvn clean install
```

2. Start up RabbitMQ

```
$ rabbitmq-server
```

3. Start up the consumer

```
$ java -jar consumer/target/consumer-0.0.1-SNAPSHOT.jar
```

4. Start up the producer

```
$ java -jar producer/target/producer-0.0.1-SNAPSHOT.jar
```

5. Inspect the producer logs

```
...
2016-09-26 18:31:06.541  INFO 48342 --- [pool-4-thread-1] com.example.Producer                     : Thread: 'pool-4-thread-1' calc fibonacci for number '42'
2016-09-26 18:31:07.549  INFO 48342 --- [pool-4-thread-1] com.example.Producer                     : Thread: 'pool-4-thread-1' calc fibonacci for number '24'
2016-09-26 18:31:07.914  INFO 48342 --- [cTaskExecutor-1] com.example.Producer                     : Thread: 'SimpleAsyncTaskExecutor-1' result: 'FiboCalcResponse{number=42, fibo=267914296}'
2016-09-26 18:31:07.915  INFO 48342 --- [cTaskExecutor-1] com.example.Producer                     : Thread: 'SimpleAsyncTaskExecutor-1' result: 'FiboCalcResponse{number=24, fibo=46368}'
2016-09-26 18:31:08.554  INFO 48342 --- [pool-4-thread-1] com.example.Producer                     : Thread: 'pool-4-thread-1' calc fibonacci for number '23'
2016-09-26 18:31:08.556  INFO 48342 --- [cTaskExecutor-1] com.example.Producer                     : Thread: 'SimpleAsyncTaskExecutor-1' result: 'FiboCalcResponse{number=23, fibo=28657}'
...
```

