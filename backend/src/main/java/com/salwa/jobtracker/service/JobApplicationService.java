package com.salwa.jobtracker.service;

import com.salwa.jobtracker.dto.JobApplicationRequest;
import com.salwa.jobtracker.dto.JobApplicationResponse;
import com.salwa.jobtracker.exception.NotFoundException;
import com.salwa.jobtracker.mapper.JobApplicationMapper;
import com.salwa.jobtracker.model.JobApplication;
import com.salwa.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;
    private final JobApplicationMapper mapper;

    public JobApplicationService(JobApplicationRepository repository, JobApplicationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<JobApplicationResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public JobApplicationResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Job application not found"));
    }

    public JobApplicationResponse create(JobApplicationRequest request) {
        JobApplication entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    public JobApplicationResponse update(Long id, JobApplicationRequest request) {
        JobApplication entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Job application not found"));

        mapper.updateEntity(entity, request);
        return mapper.toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Job application not found");
        }
        repository.deleteById(id);
    }
}