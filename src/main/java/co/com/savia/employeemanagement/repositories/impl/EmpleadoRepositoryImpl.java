package co.com.savia.employeemanagement.repositories.impl;

import co.com.savia.employeemanagement.entities.Empleado;
import co.com.savia.employeemanagement.repositories.CrudRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class EmpleadoRepositoryImpl implements CrudRepository<Empleado> {

    @Inject
    private EntityManager em;

    @Override
    public List<Empleado> findAll() {
        return em.createQuery("from Empleado", Empleado.class).getResultList();
    }

    @Override
    public Empleado findById(Long id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public void save(Empleado empleado) {
        if (empleado.getId() != null && empleado.getId() > 0) {
            em.merge(empleado);
        } else {
            em.persist(empleado);
        }
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }
}
