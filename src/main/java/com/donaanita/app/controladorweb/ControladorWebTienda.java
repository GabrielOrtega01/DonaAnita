package com.donaanita.app.controladorweb;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.donaanita.app.repository.TiendaRepositorio;
import com.donaanita.app.variables.Tienda;


@Controller
public class ControladorWebTienda {
    
    @Autowired
    private TiendaRepositorio tiendaRepositorio;
    
    @GetMapping("/verTienda.html")  
    public String listarTienda(Model model) {
        List<Tienda> listaTienda = tiendaRepositorio.findAll();
        model.addAttribute("listaTienda", listaTienda);
        
        return "verTienda";
    }
    
    @GetMapping("/formTienda.html")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tienda", new Tienda());
        
        List<Tienda> listaTienda = tiendaRepositorio.findAll();
        model.addAttribute("listaTienda", listaTienda);
        
        return "formTienda";
    }
    
    @PostMapping("/guardarTienda")
    public String guardarTienda(Tienda tienda) {
        tiendaRepositorio.save(tienda);
        return "redirect:/verTienda.html";
    }
    
    @GetMapping("/tienda/editar/{id}")
    public String modificarTienda(@PathVariable("id") Integer id, Model model) {
        Tienda tienda = tiendaRepositorio.findById(id).get();
        model.addAttribute("tienda", tienda);
        
        List<Tienda> listaTienda = tiendaRepositorio.findAll();
        model.addAttribute("listaTienda", listaTienda);
        
        return "formTienda.html";
    }
    
    @GetMapping("/tienda/eliminar/{id}")
    public String eliminarTienda(@PathVariable("id") Integer id, Model model) {
        tiendaRepositorio.deleteById(id);
        return "redirect:/verTienda.html";
    }
}

