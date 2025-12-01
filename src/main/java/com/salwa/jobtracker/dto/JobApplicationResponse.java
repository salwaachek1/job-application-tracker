package com.salwa.jobtracker.dto;

import com.salwa.jobtracker.model.JobApplication;

import java.time.LocalDate;

public record JobApplicationResponse(
        Long id,
        String company,
        String position,
        String description,
        LocalDate appliedDate,
        JobApplication.Status status
) {}
