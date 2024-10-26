package com.bezina.my_spring_app.controller;

import com.bezina.my_spring_app.dto.JobDTO;
import com.bezina.my_spring_app.entity.Job;
import com.bezina.my_spring_app.service.JobService;
import com.mongodb.MongoSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@RestController
@RequestMapping("job")
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping("/all")
    public Flux<JobDTO> all(){
       return service.allJobs();
//            return service.allJobs()
//            .onErrorResume(MongoAuthenticationException.class, ex -> {
//            System.out.println("Authentication failed for user: " + ex.getMessage());
//            return Mono.error(new RuntimeException("Authentication failure: " + ex.getMessage()));
//        });

    }
    @GetMapping("/search")
    public Flux<JobDTO> search(@RequestParam Set<String> skills){
        return service.jobsBySkills(skills);
    }

    @PostMapping
    public Mono<JobDTO> save(@RequestBody Mono<JobDTO> jobDTOMono){
        return service.save(jobDTOMono);
    }
}
