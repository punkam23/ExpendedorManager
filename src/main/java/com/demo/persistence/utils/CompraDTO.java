package com.demo.persistence.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompraDTO {
    private MetodoPago metodoPago;
    private Integer expendedorId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechaCompra;
    private ArrayList<Integer> total = new ArrayList<>();
    private List<ItemDTO> itemSold = new ArrayList<>();

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public ArrayList<Integer> getTotal() {
        return total;
    }

    public void setTotal(ArrayList<Integer> total) {
        this.total = total;
    }

    public List<ItemDTO> getItemSold() {
        return itemSold;
    }

    public void setItemSold(List<ItemDTO> itemSold) {
        this.itemSold = itemSold;
    }

    public Integer getExpendedorId() {
        return expendedorId;
    }

    public void setExpendedorId(Integer expendedorId) {
        this.expendedorId = expendedorId;
    }
}
