package co.com.savia.employeemanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DocumentoTipo documentoTipo;

    private String documentoNumero;

    private String nombres;

    private String apellidos;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaHoraCrea;

    private LocalDateTime fechaHoraModifica;

    private String ciudad;
    private String direccion;
    private String correoElectronico;
    private String telefono;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

}
