package com.donaanita.app.controladorweb;

import com.donaanita.app.repository.ClienteRepositorio;
import com.donaanita.app.variables.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorWebCliente {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@GetMapping("/verCliente.html")  
	public String listarClientes(Model model) {
		List<Cliente> listaClientes = clienteRepositorio.findAll();
		model.addAttribute("listaClientes", listaClientes);
		
		return "verCliente";
	}

	
	@GetMapping("/formCliente.html")
	public String mostrarFormularioCliente(Model model) {
		model.addAttribute("cliente", new Cliente()); 
		return "formCliente"; 
	}

	@PostMapping("/guardarCliente")
	public String guardarCliente(Cliente cliente) {
		clienteRepositorio.save(cliente);  
		return "redirect:/verCliente.html"; 
	}

	
	@GetMapping("/cliente/editar/{id}")
	public String modificarCliente(@PathVariable("id") Integer id, Model model) {
		Cliente cliente = clienteRepositorio.findById(id).get(); 
		model.addAttribute("cliente", cliente); 
        List<Cliente> listaCliente = clienteRepositorio.findAll();
        model.addAttribute("listaTienda", listaCliente);
        
		return "formCliente.html"; 
	}
	
	@GetMapping("/cliente/eliminar/{id}")
	public String eliminarCliente(@PathVariable("id") Integer id) {
		clienteRepositorio.deleteById(id);  
		return "redirect:/verCliente.html"; 
	}
}

