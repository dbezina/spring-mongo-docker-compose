package com.bezina.my_spring_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.Set;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class Job {
    @Id
    private String id;
    private String description;
    private String company;
    private Long salary;
    private Set<String> skills;
    private boolean isRemote;
}
