package co.com.savia.employeemanagement.repositories.impl;

import co.com.savia.employeemanagement.entities.Departamento;
import co.com.savia.employeemanagement.repositories.CrudRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class DepartamentoRepositoryImpl implements CrudRepository<Departamento> {

    @Inject
    private EntityManager em;

    @Override
    public List<Departamento> findAll() {
        return em.createQuery("from Departamento", Departamento.class).getResultList();
    }

    @Override
    public Departamento findById(Long id) {
        return em.find(Departamento.class, id);
    }

    @Override
    public void save(Departamento departamento) {
        if (departamento.getId() != null && departamento.getId() > 0) {
            em.merge(departamento);
        } else {
            em.persist(departamento);
        }
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }
}
