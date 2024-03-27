package com.april.aprilnotification.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioConfigService {
    
    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.phone_number_origin}")
    private String phoneNumberOrigin;

    @Value("${twilio.phone_number_destiny}")
    private String phoneNumberDestiny;
    
    public TwilioConfigService() {

    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getPhoneNumberOrigin() {
        return phoneNumberOrigin;
    }

    public void setPhoneNumberOrigin(String phoneNumberOrigin) {
        this.phoneNumberOrigin = phoneNumberOrigin;
    }
  
    public String getPhoneNumberDestiny() {
        return phoneNumberDestiny;
    }

    public void setPhoneNumberDestiny(String phoneNumberDestiny) {
        this.phoneNumberDestiny = phoneNumberDestiny;
    }
    
}
