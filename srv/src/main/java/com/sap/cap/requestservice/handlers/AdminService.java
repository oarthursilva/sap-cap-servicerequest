package com.sap.cap.requestservice.handlers;

import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Deprecated
//@Component
//@ServiceName("AdminService")
public class AdminService implements EventHandler {

    private final Map<Object, Map<String, Object>> services = new HashMap<>();

    //    @On(event = CqnService.EVENT_CREATE, entity = "AdminService.Service")
    public void handleCreate(CdsCreateEventContext context) {
        context.getCqn().entries().forEach(service -> {
            services.put(service.get("UUID"), service);
        });
    }

    //    @On(event = CqnService.EVENT_READ, entity = "AdminService.Service")
    public void handleRead(CdsReadEventContext context) {
        context.setResult(services.values());
    }
}
