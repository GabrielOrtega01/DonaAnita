package com.donaanita.app.variables;

import jakarta.persistence.*;

@Entity
@Table(name = "comida")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreComida;
    private String bebida;
    private int cantidadComida;
    private int cantidadBebida;
    private int precioComida;
    private int precioBebida;

    @OneToOne(mappedBy = "comida")  // Relación OneToOne con Pedido
    private Pedido pedido;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreComida() {
		return nombreComida;
	}
	public void setNombreComida(String nombreComida) {
		this.nombreComida = nombreComida;
	}
	public String getBebida() {
		return bebida;
	}
	public void setBebida(String bebida) {
		this.bebida = bebida;
	}
	public int getCantidadComida() {
		return cantidadComida;
	}
	public void setCantidadComida(int cantidadComida) {
		this.cantidadComida = cantidadComida;
	}
	public int getCantidadBebida() {
		return cantidadBebida;
	}
	public void setCantidadBebida(int cantidadBebida) {
		this.cantidadBebida = cantidadBebida;
	}
	public int getPrecioComida() {
		return precioComida;
	}
	public void setPrecioComida(int precioComida) {
		this.precioComida = precioComida;
	}
	public int getPrecioBebida() {
		return precioBebida;
	}
	public void setPrecioBebida(int precioBebida) {
		this.precioBebida = precioBebida;
	}
	
}
