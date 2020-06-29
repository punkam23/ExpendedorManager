package com.demo.persistence.service;

import com.demo.persistence.dao.Articulo;
import com.demo.persistence.dao.Detalle;
import com.demo.persistence.dao.Expendedor;
import com.demo.persistence.dao.Factura;
import com.demo.persistence.repository.ArticuloRepository;
import com.demo.persistence.repository.DetalleRepository;
import com.demo.persistence.repository.ExpendedorRepository;
import com.demo.persistence.repository.FacturaRepository;
import com.demo.persistence.utils.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class FacturaServiceImpl implements ExpendedorService {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ExpendedorRepository expendedorRepository;

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    DetalleRepository detalleRepository;

    @Override
    public String commitTransaction(Object DTO) {
        CompraDTO compraDTO = (CompraDTO) DTO;
        Detalle detalle = new Detalle();
        Factura factura = new Factura();
        Set<Detalle> detalles = new HashSet<>();
        Optional<Articulo> articulo = articuloRepository.findByNombreArticulo(compraDTO.getItemSold().get(0).getNombre());
        Optional<Expendedor> expendedor = expendedorRepository.findById(new Long(compraDTO.getExpendedorId()));
        factura.setFecha(compraDTO.getFechaCompra());
        factura.setExpendedormap(expendedor.get());
        detalle.setCantidad(compraDTO.getItemSold().stream()
                .map(itemDTO -> itemDTO.getCantidad())
                .reduce(0, Integer::sum));
        detalle.setArticulomap(articulo.get());
        detalle.setFacturamap(factura);
        detalles.add(detalle);
        factura.setDetalles(detalles);
        facturaRepository.save(factura);
        detalleRepository.save(detalle);
        return "Saved";
    }
}
