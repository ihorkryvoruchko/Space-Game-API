package com.example.api.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String password;
}