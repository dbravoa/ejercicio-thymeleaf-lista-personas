package pe.edu.continental.MiPrimerTrabajoConFormulariosEnThymeleaf.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
}
