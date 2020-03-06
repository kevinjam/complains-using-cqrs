package com.kevinjanvier.democomplaints.query;

import com.kevinjanvier.democomplaints.entity.ComplaintQueryObject;
import com.kevinjanvier.democomplaints.events.ComplainFileEvent;
import com.kevinjanvier.democomplaints.repository.ComplaintQueryObjectRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplainQueryObjectUpdater {
    @Autowired
    private ComplaintQueryObjectRepository repository;

    @EventHandler
    public void on(ComplainFileEvent event){
        System.out.println("Event Complain "+event);
        repository.save(
                new ComplaintQueryObject(
                        event.getId(), event.getCompany(),event.getDescription()));
    }
}
