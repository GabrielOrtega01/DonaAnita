package com.donaanita.app.variables;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String envioLocal;
    private String direccion;

    @OneToOne
    @JoinColumn(name = "comida_id", nullable = false)  // Llave foránea a Comida, no puede ser nulo
    private Comida comida;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)  // Llave foránea a Empleado, no puede ser nulo
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)  // Llave foránea a Cliente, no puede ser nulo
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "pedido_tienda",  // Tabla intermedia creada automáticamente
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "tienda_id")
    )
    private List<Tienda> tienda;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnvioLocal() {
        return envioLocal;
    }

    public void setEnvioLocal(String envioLocal) {
        this.envioLocal = envioLocal;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Tienda> getTienda() {
        return tienda;
    }

    public void setTienda(List<Tienda> tienda) {
        this.tienda = tienda;
    }
}
