package com.kevinjanvier.democomplaints.controller;

import com.kevinjanvier.democomplaints.commands.FileComplaintCommand;
import com.kevinjanvier.democomplaints.entity.ComplaintQueryObject;
import com.kevinjanvier.democomplaints.repository.ComplaintQueryObjectRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

@RestController
public class ComplainController {


    private final ComplaintQueryObjectRepository repository;

    private final CommandGateway commandGateway;

    public ComplainController(ComplaintQueryObjectRepository repository,
                              CommandGateway commandGateway) {
        this.repository = repository;
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public List<ComplaintQueryObject> findAll(){
        System.out.println("Find all ");
return repository.findAll();
    }

    @PostMapping
    public CompletableFuture<String> fileComplaint(@RequestBody Map<String, String> request){
String id= UUID.randomUUID().toString();
        System.out.println("File Complaint ID ::: " + id);
     return commandGateway.send(new FileComplaintCommand(id,
                request.get("company"), request.get("description")));
    }


    @GetMapping("/{id}")
    public Optional<ComplaintQueryObject> find(@PathVariable String id){
        Logger.getLogger("FInd One " + repository.findById(id));
        return repository.findById(id);
    }
}
