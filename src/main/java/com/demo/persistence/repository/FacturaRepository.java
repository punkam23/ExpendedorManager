package com.demo.persistence.repository;

import com.demo.persistence.dao.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
}
