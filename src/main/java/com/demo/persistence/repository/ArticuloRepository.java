package com.demo.persistence.repository;

import com.demo.persistence.dao.Articulo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticuloRepository extends CrudRepository<Articulo, Long> {
    Optional<Articulo> findByNombreArticulo(String nombreArticulo);
}
