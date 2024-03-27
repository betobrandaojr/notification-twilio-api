package com.april.aprilnotification.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class WhatsAppNotificationService {

    private final TwilioConfigService twilioConfigService;

    public WhatsAppNotificationService(TwilioConfigService twilioConfigService) {
        this.twilioConfigService = twilioConfigService;
        Twilio.init(this.twilioConfigService.getAccountSid(), this.twilioConfigService.getAuthToken());
    }

    public void sendMessage(String mensage, String destinatario) {
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + twilioConfigService.getPhoneNumberDestiny()),
                new PhoneNumber("whatsapp:" + twilioConfigService.getPhoneNumberOrigin()),
                mensage).create();
    }
}
