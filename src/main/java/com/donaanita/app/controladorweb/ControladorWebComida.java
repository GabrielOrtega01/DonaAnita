package com.donaanita.app.controladorweb;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.donaanita.app.repository.ComidaRepositorio;
import com.donaanita.app.variables.Comida;



@Controller
public class ControladorWebComida {

    @Autowired
    private ComidaRepositorio comidaRepositorio;

    @GetMapping("/verComida.html")  
    public String listarComida(Model model) {
        List<Comida> listaComida = comidaRepositorio.findAll();
        model.addAttribute("listaComida", listaComida);
        
        return "verComida";
    }

    @GetMapping("/formComida.html")
    public String mostrarFormulario(Model model) {
        model.addAttribute("comida", new Comida());
        
        List<Comida> listaComida = comidaRepositorio.findAll();
        model.addAttribute("listaComida", listaComida);
        
        return "formComida";
    }

    @PostMapping("/guardarComida")
    public String guardarComida(Comida comida) {
        comidaRepositorio.save(comida);
        return "redirect:/verComida.html";
    }

    @GetMapping("/comida/editar/{id}")
    public String modificarComida(@PathVariable("id") Integer id, Model model) {
        Comida comida = comidaRepositorio.findById(id).get();
        model.addAttribute("comida", comida);
        
        List<Comida> listaComida = comidaRepositorio.findAll();
        model.addAttribute("listaComida", listaComida);
        
        return "formComida.html";
    }

    @GetMapping("/comida/eliminar/{id}")
    public String eliminarComida(@PathVariable("id") Integer id, Model model) {
        comidaRepositorio.deleteById(id);
        return "redirect:/verComida.html";
    }
}
