package com.soap.impl;

import java.util.List;

import jakarta.jws.WebService;

import com.soap.service.RouterNotificator;

@WebService(endpointInterface = "com.soap.RouterService")
public class RouterNotificatorImpl implements RouterNotificator {

    @Override
    public void sendNotification(List<String> untractedUsers) {
        // TODO: untractedUsers send to telegram
    }

}
