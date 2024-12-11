package org.zerock.kafkaproducer.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.kafkaproducer.service.KafkaProducerService;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/producer")
public class SendMessageController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("send")
    public String[] sendMessage( @RequestParam("msg") String msg) {


        log.info("------------------------------");

        log.info(msg);

        log.info("------------------------------");

        kafkaProducerService.sendMessage("sample_topic", msg);

        return new String[] {msg, "sent"};

    }


}
