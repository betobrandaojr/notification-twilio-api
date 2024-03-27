package com.april.aprilnotification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.april.aprilnotification.service.KafkaProducerService;
import com.april.aprilnotification.service.WhatsAppNotificationService;

@RestController
public class MessageController {
    private WhatsAppNotificationService whatsAppNotificationService;
    private KafkaProducerService kafkaProducerService;

    public MessageController(WhatsAppNotificationService whatsAppNotificationService) {
        this.whatsAppNotificationService = whatsAppNotificationService;
    }

    /*
     * public MessageController(KafkaProducerService kafkaProducerService) {
     * this.kafkaProducerService = kafkaProducerService;
     * }
     */

    @GetMapping("/send-message")
    public String sendMessage(@RequestParam String message, @RequestParam String recipient) {
        whatsAppNotificationService.sendMessage(message, recipient);
        return "Mensagem enviada com sucesso!";
    }

    /*
     * @GetMapping("/send-message")
     * public String sendMessage(@RequestParam String message, @RequestParam String
     * recipient) {
     * String kafkaMessage = message + ";" + recipient;
     * kafkaProducerService.sendMessage(kafkaMessage);
     * return "Mensagem enviada para a fila Kafka com sucesso!";
     * }
     */

}
