package co.com.savia.employeemanagement.services.impl;

import co.com.savia.employeemanagement.entities.Departamento;
import co.com.savia.employeemanagement.repositories.CrudRepository;
import co.com.savia.employeemanagement.services.DepartamentoService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Stateless
public class DepartamentoServiceImpl implements DepartamentoService {

    @Inject
    private CrudRepository<Departamento> repository;
    @Override
    public List<Departamento> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Departamento> findById(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public void save(Departamento departamento) {
        if (departamento.getId() == null) {
            departamento.setFechaHoraCrea(LocalDateTime.now());
            departamento.setFechaHoraModifica(LocalDateTime.now());
        } else {
            departamento.setFechaHoraModifica(LocalDateTime.now());
            Departamento existingDepartamento = repository.findById(departamento.getId());
            if (existingDepartamento != null) {
                departamento.setFechaHoraCrea(existingDepartamento.getFechaHoraCrea());
            }
        }
        repository.save(departamento);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
