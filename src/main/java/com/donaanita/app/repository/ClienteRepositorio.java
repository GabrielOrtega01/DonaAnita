package com.donaanita.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donaanita.app.variables.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
