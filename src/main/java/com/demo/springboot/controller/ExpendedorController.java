package com.demo.springboot.controller;

import com.demo.persistence.service.ExpendedorServiceImpl;
import com.demo.persistence.service.FacturaServiceImpl;
import com.demo.persistence.utils.CompraDTO;
import com.demo.persistence.dao.Articulo;
import com.demo.persistence.repository.ArticuloRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/expendedor")
public class ExpendedorController {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private FacturaServiceImpl facturaService;

    @Autowired
    private ExpendedorServiceImpl expendedorService;

    @GetMapping(path="/fetchExpendedores")
    public @ResponseBody String fetchExpendedores () {
        String expendedores = Strings.EMPTY;
        try {
            expendedores = expendedorService.fetchExpendedores();
        } catch (JsonProcessingException e) {
            expendedores = e.getMessage();
        }
        return expendedores;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String nombreArticulo,
                                            @RequestParam Integer precio) {

        Articulo articulo = new Articulo();
        articulo.setNombreArticulo(nombreArticulo);
        articulo.setPrecio(Long.valueOf(precio));
        articuloRepository.save(articulo);
        return "Saved";
    }

    @PostMapping(path="/agregarFactura")
    public @ResponseBody String generarFactura (@RequestBody CompraDTO compra) {
        String response = facturaService.commitTransaction(compra);
        return "saved";
    }


}
