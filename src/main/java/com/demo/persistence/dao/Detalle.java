package com.demo.persistence.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle")
public class Detalle implements Serializable {
    @Id
    @Column(name = "id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_articulo", nullable = false)
    private Articulo articulomap;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura facturamap;

    public Detalle() {
    }

    public Detalle(Long idDetalle, int cantidad, Articulo articulomap, Factura facturamap) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.articulomap = articulomap;
        this.facturamap = facturamap;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulomap() {
        return articulomap;
    }

    public void setArticulomap(Articulo articulomap) {
        this.articulomap = articulomap;
    }

    public Factura getFacturamap() {
        return facturamap;
    }

    public void setFacturamap(Factura facturamap) {
        this.facturamap = facturamap;
    }
}
