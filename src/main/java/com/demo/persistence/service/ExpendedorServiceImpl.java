package com.demo.persistence.service;

import com.demo.persistence.dao.Expendedor;
import com.demo.persistence.repository.ExpendedorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpendedorServiceImpl {
    @Autowired
    ExpendedorRepository expendedorRepository;


    public String fetchExpendedores() throws JsonProcessingException {
        Iterable<Expendedor> expendedors = expendedorRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(expendedors);
    }
}
