package com.bezina.my_spring_app.service;

import com.bezina.my_spring_app.dto.JobDTO;
import com.bezina.my_spring_app.entity.Job;
import com.bezina.my_spring_app.repository.JobRepository;
import com.bezina.my_spring_app.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Flux<JobDTO> allJobs(){
        return this.jobRepository.findAll()
                .map(EntityDtoUtil::toDTO)
                ;
    }
    public Flux<JobDTO> jobsBySkills(Set<String> skills){
        return this.jobRepository.findBySkillsIn(skills)
                .map(EntityDtoUtil::toDTO)
                ;
    }
    public Mono<JobDTO> save(Mono<JobDTO> mono){
        return mono
                .map(EntityDtoUtil::toJob)
                .flatMap(this.jobRepository::save)
                .map(EntityDtoUtil::toDTO)
                ;
    }
}
