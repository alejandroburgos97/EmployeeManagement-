package co.com.savia.employeemanagement.services;

import co.com.savia.employeemanagement.entities.Empleado;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface EmpleadoService {
    List<Empleado> findAll();
    Optional<Empleado> findById(Long id);
    void save(Empleado empleado);
    void delete(Long id);
}
