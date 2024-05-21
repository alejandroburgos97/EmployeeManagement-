package co.com.savia.employeemanagement.config;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager {

    @PersistenceContext(name = "EmployeeManagementPU")
    private EntityManager em;

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return em;
    }
}
