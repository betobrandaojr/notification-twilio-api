package com.april.aprilnotification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final WhatsAppNotificationService whatsAppNotificationService;

    @Autowired
    public KafkaConsumerService(WhatsAppNotificationService whatsAppNotificationService) {
        this.whatsAppNotificationService = whatsAppNotificationService;
    }

    @KafkaListener(topics = "whatsappNotifications", groupId = "grupo1")
    public void consume(String message) {
        String[] parts = message.split(";");
        if (parts.length == 2) {
            String mensagem = parts[0];
            String destinatario = parts[1];
            whatsAppNotificationService.sendMessage(mensagem, destinatario);
        } else {
            System.err.println("Mensagem recebida em formato incorreto: " + message);
        }
    }
}
