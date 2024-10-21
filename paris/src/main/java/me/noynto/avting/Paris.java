package me.noynto.avting;

import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class Paris {

    private static final Logger LOGGER = LoggerFactory.getLogger(Paris.class);
    private static final String QUEUE_NAME = "PARIS";

    public static void main(String[] args) {
        LOGGER.info("Delivery system is starting.");
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            LOGGER.info("Delivery system is started.");
            channel.basicConsume(QUEUE_NAME, false,
                    (consumerTag, message) -> {
                        LOGGER.info("Factor [{}], Letter [{}], From [{}], Message [{}]", consumerTag, message.getEnvelope().getDeliveryTag(), from(message.getProperties()), new String(message.getBody(), StandardCharsets.UTF_8));
                        channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                    },
                    consumerTag -> {
                    }
            );
        } catch (IOException | TimeoutException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    protected static String from(BasicProperties properties) {
        if (Objects.nonNull(properties.getHeaders()) && properties.getHeaders().containsKey("FROM")) {
            return properties.getHeaders().get("FROM").toString();
        } else {
            return "UNKNOWN";
        }
    }
}