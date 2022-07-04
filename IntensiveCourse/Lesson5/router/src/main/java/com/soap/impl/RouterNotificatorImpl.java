package com.soap.impl;

import com.soap.service.RouterNotificator;
import jakarta.jws.WebService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@WebService(endpointInterface = "com.soap.impl.RouterNotificatorImpl")
public class RouterNotificatorImpl implements RouterNotificator{

    @Override
    public String sendNotification(String untrackedUsers) {
        // TODO: untrackedUsers send to telegram
        System.out.println(untrackedUsers);
        return "Hello";
    }

    @Override
    public String sendReport(File file) {
        System.out.println(file.getName());
        return "Hello";
    }

}
