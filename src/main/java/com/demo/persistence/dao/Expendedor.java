package com.demo.persistence.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "expendedor")
public class Expendedor implements Serializable {
    @Id
    @Column(name = "id_expendedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExpendedor;
    @Column(name = "nombre_expendedor")
    private String nombreExpendedor;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "modelo")
    private String modelo;

    @OneToMany(mappedBy = "expendedormap", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Factura> facturas;

    public Expendedor() {
    }

    public Expendedor(Long idExpendedor, String nombreExpendedor, String ubicacion, String modelo) {
        this.idExpendedor = idExpendedor;
        this.nombreExpendedor = nombreExpendedor;
        this.ubicacion = ubicacion;
        this.modelo = modelo;
    }

    public Long getIdExpendedor() {
        return idExpendedor;
    }

    public void setIdExpendedor(Long idExpendedor) {
        this.idExpendedor = idExpendedor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreExpendedor() {
        return nombreExpendedor;
    }

    public void setNombreExpendedor(String nombreExpendedor) {
        this.nombreExpendedor = nombreExpendedor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }
}
