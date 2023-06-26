package com.example.bankAccountLoader.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TechResponse {
    private String result;
    private String errorDescription;
}
