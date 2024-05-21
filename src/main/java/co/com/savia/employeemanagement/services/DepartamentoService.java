package co.com.savia.employeemanagement.services;

import co.com.savia.employeemanagement.entities.Departamento;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;
@Local
public interface DepartamentoService {
    List<Departamento> findAll();
    Optional<Departamento> findById(Long id);
    void save(Departamento departamento);
    void delete(Long id);
}
