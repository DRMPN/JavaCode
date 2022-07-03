package com.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface RouterService {

    @WebMethod
    public String routeNotification(String Name);

    @WebMethod
    public void routeTrackResults();

    @WebMethod
    public void handleCommand();
    
}
