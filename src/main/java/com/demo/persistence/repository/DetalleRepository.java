package com.demo.persistence.repository;

import com.demo.persistence.dao.Detalle;
import org.springframework.data.repository.CrudRepository;

public interface DetalleRepository extends CrudRepository<Detalle, Long> {
}
