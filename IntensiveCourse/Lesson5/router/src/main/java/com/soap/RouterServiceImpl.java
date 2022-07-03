package com.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.soap.RouterService")
public class RouterServiceImpl implements RouterService {

    @Override
    public void handleCommand() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String routeNotification(String name) {
        return name;
    }

    @Override
    public void routeTrackResults() {
        // TODO Auto-generated method stub
        
    }
    
}
