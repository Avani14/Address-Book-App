package com.bridgelabz.addressbookapp.advice;

import com.bridgelabz.addressbookapp.exception.AddressNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

public class AddressBookAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> invalidEntries(MethodArgumentNotValidException methodArgumentNotValidException){
    Map<String,String> map = new HashMap<>();
    methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(fieldError -> map.put(fieldError.getField(), fieldError.getDefaultMessage()));
    return map;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AddressNotFound.class)
    public Map<String,String> addressNotFound(AddressNotFound addressNotFound){
        Map<String,String> map = new HashMap<>();
        map.put("error","Contact not found");
        return map;
    }
}
