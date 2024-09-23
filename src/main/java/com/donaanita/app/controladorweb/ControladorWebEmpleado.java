package com.donaanita.app.controladorweb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.donaanita.app.repository.EmpleadoRepositorio;
import com.donaanita.app.repository.TiendaRepositorio; // Agregado para manejar tiendas
import com.donaanita.app.variables.Empleado;
import com.donaanita.app.variables.Tienda;

@Controller
public class ControladorWebEmpleado {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Autowired
    private TiendaRepositorio tiendaRepositorio; // Repositorio para tiendas

    @GetMapping("/verEmpleado.html")
    public String listarEmpleado(Model model) {
        List<Empleado> listaEmpleado = empleadoRepositorio.findAll();
        model.addAttribute("listaEmpleado", listaEmpleado);
        return "verEmpleado";
    }


    @GetMapping("/formEmpleado.html")
    public String mostrarFormularioEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        
        // Pasar la lista de tiendas al modelo
        List<Tienda> listaTiendas = tiendaRepositorio.findAll();
        model.addAttribute("listaTiendas", listaTiendas);
        
        return "formEmpleado";
    }


    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(Empleado empleado, Model model) {
        try {
            empleadoRepositorio.save(empleado);
            return "redirect:/verEmpleado.html";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el empleado: " + e.getMessage());
            return "formEmpleado"; // Vuelve al formulario en caso de error
        }
    }

    

    @GetMapping("/empleado/editar/{id}")
    public String modificarEmpleado(@PathVariable("id") Integer id, Model model) {
        Empleado empleado = empleadoRepositorio.findById(id).get();
        model.addAttribute("empleado", empleado);

        // Obtener la lista de tiendas para el formulario
        List<Tienda> listaTiendas = tiendaRepositorio.findAll();
        model.addAttribute("listaTiendas", listaTiendas);

        return "formEmpleado.html";
    }

    @GetMapping("/empleado/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable("id") Integer id) {
        empleadoRepositorio.deleteById(id);
        return "redirect:/verEmpleado.html";
    }
}
