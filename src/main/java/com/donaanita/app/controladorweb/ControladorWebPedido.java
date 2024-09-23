package com.donaanita.app.controladorweb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.donaanita.app.repository.ClienteRepositorio;
import com.donaanita.app.repository.ComidaRepositorio;
import com.donaanita.app.repository.EmpleadoRepositorio;
import com.donaanita.app.repository.PedidoRepositorio;
import com.donaanita.app.repository.TiendaRepositorio;
import com.donaanita.app.variables.Pedido;
import com.donaanita.app.variables.Comida;
import com.donaanita.app.variables.Empleado;
import com.donaanita.app.variables.Cliente;
import com.donaanita.app.variables.Tienda;

@Controller
public class ControladorWebPedido {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ComidaRepositorio comidaRepositorio;

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private TiendaRepositorio tiendaRepositorio;

    @GetMapping("/verPedido.html")  
    public String listarPedido(Model model) {
        List<Pedido> listaPedido = pedidoRepositorio.findAll();
        model.addAttribute("listaPedido", listaPedido);
        return "verPedido"; 
    }

    @GetMapping("/formPedido.html")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pedido", new Pedido());

        // Cargar datos de las listas para los selectores
        List<Comida> listaComida = comidaRepositorio.findAll();
        model.addAttribute("listaComida", listaComida);

        List<Empleado> listaEmpleado = empleadoRepositorio.findAll();
        model.addAttribute("listaEmpleado", listaEmpleado);

        List<Cliente> listaCliente = clienteRepositorio.findAll();
        model.addAttribute("listaCliente", listaCliente);

        List<Tienda> listaTienda = tiendaRepositorio.findAll();
        model.addAttribute("listaTienda", listaTienda);

        return "formPedido";
    }

    @PostMapping("/guardarPedido")
    public String guardarPedido(Pedido pedido) {
        // Guardar pedido en la base de datos
        pedidoRepositorio.save(pedido);
        return "redirect:/verPedido.html";
    }

    @GetMapping("/pedido/editar/{id}")
    public String modificarPedido(@PathVariable("id") Integer id, Model model) {
        // Buscar el pedido por ID y cargar datos en el formulario
        Pedido pedido = pedidoRepositorio.findById(id).orElse(null);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);

            List<Comida> listaComida = comidaRepositorio.findAll();
            model.addAttribute("listaComida", listaComida);

            List<Empleado> listaEmpleado = empleadoRepositorio.findAll();
            model.addAttribute("listaEmpleado", listaEmpleado);

            List<Cliente> listaCliente = clienteRepositorio.findAll();
            model.addAttribute("listaCliente", listaCliente);

            List<Tienda> listaTienda = tiendaRepositorio.findAll();
            model.addAttribute("listaTienda", listaTienda);

            return "formPedido";
        } else {
            return "redirect:/verPedido.html"; // Redirigir si no se encuentra el pedido
        }
    }

    @GetMapping("/pedido/eliminar/{id}")
    public String eliminarPedido(@PathVariable("id") Integer id) {
        // Eliminar el pedido por ID
        pedidoRepositorio.deleteById(id);
        return "redirect:/verPedido.html";
    }

    @GetMapping("/inicio")
    public String Inicio() {
        return "index.html";
    }
}
