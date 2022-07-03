package com.soap.service;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RouterNotificator {

    @WebMethod
    public void sendNotification(List<String> untractedUsers);

}
