package com.bezina.my_spring_app.util;

import com.bezina.my_spring_app.dto.JobDTO;
import com.bezina.my_spring_app.entity.Job;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {
    public static JobDTO toDTO(Job job){
        JobDTO dto = new JobDTO();
        BeanUtils.copyProperties(job, dto);
        return dto;
    }
    public static Job toJob(JobDTO dto){
        Job job = new Job();
        BeanUtils.copyProperties( dto,job);
        return job;
    }
}
