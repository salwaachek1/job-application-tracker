package com.salwa.jobtracker.dto;

import com.salwa.jobtracker.model.JobApplication;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record JobApplicationRequest(

        @NotBlank(message = "Company name is required")
        String company,

        @NotBlank(message = "Position is required")
        String position,

        @Size(max = 1000, message = "Description cannot exceed 1000 characters")
        String description,

        @PastOrPresent(message = "Applied date cannot be in the future")
        LocalDate appliedDate,

        @NotNull(message = "Status is required")
        JobApplication.Status status
) {}

