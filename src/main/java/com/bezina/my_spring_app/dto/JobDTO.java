package com.bezina.my_spring_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class JobDTO {
    private String id;
    private String description;
    private String company;
    private Long salary;
    private Set<String> skills;
    private boolean isRemote;
}
