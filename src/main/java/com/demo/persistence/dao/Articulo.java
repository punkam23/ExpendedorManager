package com.demo.persistence.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {
    @Id
    @Column(name = "id_articulo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticulo;
    @Column(name = "precio")
    private Long precio;
    @Column(name = "nombre_articulo")
    private String nombreArticulo;

//    @ManyToMany
//    @JoinColumn(name = "id_factura")
//    Set<Factura> factura;

    @OneToMany(mappedBy = "articulomap", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Detalle> detalles;

    public Articulo(){}

    public Articulo(String nombreArticulo, Long precio) {
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }
}
