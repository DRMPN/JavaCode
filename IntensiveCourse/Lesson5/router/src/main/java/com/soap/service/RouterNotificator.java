package com.soap.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.io.File;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RouterNotificator {

    @WebMethod
    String sendNotification(String untrackedUsers);

    @WebMethod
    String sendReport(File file);

}
