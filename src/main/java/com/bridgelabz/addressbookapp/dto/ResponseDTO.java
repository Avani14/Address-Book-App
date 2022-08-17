package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private Object obj;

    public ResponseDTO(String message, Object obj) {
        this.message = message;
        this.obj = obj;
    }

    public ResponseDTO(String message) {
        this.message = message;
    }
}
