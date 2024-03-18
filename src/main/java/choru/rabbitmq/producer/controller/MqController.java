package choru.rabbitmq.producer.controller;

import choru.rabbitmq.producer.dto.MqReq;
import choru.rabbitmq.producer.service.MqService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MqController {

    private final MqService service;

    @PostMapping("/message")
    public String publish(@RequestBody MqReq req) throws JsonProcessingException {
        service.sendMessage(req);
        return "완료입니다.";
    }
}
