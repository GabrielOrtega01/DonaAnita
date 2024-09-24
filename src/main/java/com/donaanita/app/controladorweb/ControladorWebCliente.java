package com.donaanita.app.controladorweb;

import com.donaanita.app.repository.ClienteRepositorio;
import com.donaanita.app.variables.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String eliminarCliente(@PathVariable("id") Integer id, Model model) {
	    try {
	        clienteRepositorio.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        // Capturamos la excepción y añadimos un mensaje de error al modelo
	        model.addAttribute("error", "No se puede eliminar el cliente porque tiene pedidos asociados.");
	        List<Cliente> listaClientes = clienteRepositorio.findAll();
	        model.addAttribute("listaClientes", listaClientes);
	        return "verCliente"; // Volvemos a la lista de clientes, pero con el error
	    }
	    return "redirect:/verCliente.html"; // Si la eliminación fue exitosa
	}
    @GetMapping("/contacto.html")
    public String mostrarContacto() {
        return "contacto";  // Asegúrate de que este nombre coincide con tu archivo contacto.html en templates
    }
    @PostMapping("/contacto.html")
    public String procesarFormularioContacto(@RequestParam String nombre,
                                             @RequestParam String email,
                                             @RequestParam String mensaje,
                                             Model model) {
        // Aquí puedes procesar el formulario, por ejemplo, guardar el mensaje en la base de datos
        // o enviarlo por correo electrónico.

        // Agrega un mensaje de éxito
        model.addAttribute("exito", "¡Tu mensaje ha sido enviado satisfactoriamente!");

        // Redirige de nuevo a la página de contacto
        return "contacto";
    }
}

