package choru.rabbitmq.producer.service;

import choru.rabbitmq.producer.dto.MqReq;
import choru.rabbitmq.producer.messageDto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MqService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(MqReq req) throws JsonProcessingException {
        MessageDto messageDto = new MessageDto(req.message());
        ObjectMapper mapper = new ObjectMapper();
        String objectToJson = mapper.writeValueAsString(messageDto);
        rabbitTemplate.convertAndSend("hello.exchange", "hello.key", messageDto);
    }
}
