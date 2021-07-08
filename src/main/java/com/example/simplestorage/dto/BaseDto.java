package com.example.simplestorage.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseDto {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}