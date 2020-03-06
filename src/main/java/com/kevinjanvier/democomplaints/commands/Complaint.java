package com.kevinjanvier.democomplaints.commands;

import com.kevinjanvier.democomplaints.events.ComplainFileEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Complaint {

    @AggregateIdentifier
    private String complainId;

    public Complaint() {
    }

    @CommandHandler
    public Complaint(FileComplaintCommand command){
        //do event sourcing
        System.out.println("CommandHandler " + command);
        System.out.println("CommandHandlerID " + complainId);
        AggregateLifecycle.apply(new
                ComplainFileEvent(command.getId(), command.getCompany(),
                command.getDescription()));

    }

    @EventSourcingHandler
    public void on(ComplainFileEvent event){
        //don't reject even handler
     complainId = event.getId();
    }
}
