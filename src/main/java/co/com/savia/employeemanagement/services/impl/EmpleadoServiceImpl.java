package co.com.savia.employeemanagement.services.impl;

import co.com.savia.employeemanagement.entities.Empleado;
import co.com.savia.employeemanagement.repositories.CrudRepository;
import co.com.savia.employeemanagement.services.EmpleadoService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Stateless
public class EmpleadoServiceImpl implements EmpleadoService {

    @Inject
    private CrudRepository<Empleado> repository;
    @Override
    public List<Empleado> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Empleado> findById(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public void save(Empleado empleado) {
        if (empleado.getId() == null) {
            empleado.setFechaHoraCrea(LocalDateTime.now());
            empleado.setFechaHoraModifica(LocalDateTime.now());
        } else {
            empleado.setFechaHoraModifica(LocalDateTime.now());
            Empleado existingEmpleado = repository.findById(empleado.getId());
            if (existingEmpleado != null) {
                empleado.setFechaHoraCrea(existingEmpleado.getFechaHoraCrea());
            }
        }
        repository.save(empleado);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
