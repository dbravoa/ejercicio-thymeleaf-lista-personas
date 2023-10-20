package pe.edu.continental.MiPrimerTrabajoConFormulariosEnThymeleaf.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.continental.MiPrimerTrabajoConFormulariosEnThymeleaf.models.Persona;

@Controller
// Ruta
@RequestMapping("/personas")
public class AppController {

    // Subruta
    @GetMapping("/inicio")
    public String index(Model model) {
        model.addAttribute("miNombre", "Pepito");
        return "personas/inicio";
    }

    // Subruta
    @GetMapping("/lista")
    public String listaPersonas(Model model) {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona(1, "Juanito", "Reynoso"));
        listaPersonas.add(new Persona(2, "Ricardito", "Gareca Vuelve Que Sin Ti La  Vida Se Me Va"));
        model.addAttribute("listaPersonas", listaPersonas);
        return "personas/lista";
    }

    // Subruta dinámica
    @GetMapping("/persona/{id}")
    public String detallePersona(
            @PathVariable Integer id,
            Model model) {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona(1, "Juanito", "Reynoso"));
        listaPersonas.add(new Persona(2, "Ricardito", "Gareca Vuelve Que Sin Ti La Vida Se Me Va"));
        Persona persona = listaPersonas.get(id - 1);
        model.addAttribute("id", persona.getId());
        model.addAttribute("nombre", persona.getNombre());
        model.addAttribute("apellido", persona.getApellido());
        return "personas/detalle";
    }

    @PostMapping("/guardar")
    public String registrarPersona(
            Model model,
            @RequestParam("id") Integer id,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido) {
        // Funcionamiento para registrar a una persona
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona(id, nombre, apellido));
        for (Persona persona : listaPersonas) {
            System.out.println(persona.toString());
        }
        // Luego de registrar volverá a la lista
        return "personas/lista";
    }

    @GetMapping("/registrar")
    public String formularioRegistro(Model model) {
        return "personas/formulario";
    }

}
