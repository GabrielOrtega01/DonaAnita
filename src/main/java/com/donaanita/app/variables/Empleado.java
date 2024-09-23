package com.donaanita.app.variables;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String cedula;
    private String turno;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "tienda_id")  // Relación ManyToOne con Tienda
    private Tienda tienda;  // Cambiado de String a Tienda

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Tienda getTienda() {  // Método getter corregido
		return tienda;
	}

	public void setTienda(Tienda tienda) {  // Método setter corregido
		this.tienda = tienda;
	}
}
