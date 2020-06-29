package com.demo.persistence.dao;

import com.demo.persistence.utils.CompraDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {
    @Id
    @Column(name = "id_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_expendedor", nullable = false)
    private Expendedor expendedormap;

    @OneToMany(mappedBy = "facturamap", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Detalle> detalles;

    public Factura() {
    }

    public Factura(Long idFactura, Date fecha, Integer cantidad, Expendedor expendedormap) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.expendedormap = expendedormap;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<Detalle> detalles) {
        this.detalles = detalles;
    }

    public Expendedor getExpendedormap() {
        return expendedormap;
    }

    public void setExpendedormap(Expendedor expendedormap) {
        this.expendedormap = expendedormap;
    }
}
