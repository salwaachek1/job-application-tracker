package com.salwa.jobtracker.mapper;

import com.salwa.jobtracker.dto.JobApplicationRequest;
import com.salwa.jobtracker.dto.JobApplicationResponse;
import com.salwa.jobtracker.model.JobApplication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JobApplicationMapper {

    JobApplication toEntity(JobApplicationRequest request);

    JobApplicationResponse toResponse(JobApplication entity);

    void updateEntity(@MappingTarget JobApplication entity, JobApplicationRequest request);
}