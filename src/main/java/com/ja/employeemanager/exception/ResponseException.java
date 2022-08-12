package com.ja.employeemanager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResponseException {

    private String message;

    private LocalDateTime localDateTime;

    private String description;

}
