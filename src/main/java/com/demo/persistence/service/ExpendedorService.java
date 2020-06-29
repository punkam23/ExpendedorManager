package com.demo.persistence.service;


import org.springframework.stereotype.Component;

@Component
public interface ExpendedorService <T> {
    public String commitTransaction(T DTO);
}
