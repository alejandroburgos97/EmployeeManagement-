package co.com.savia.employeemanagement.controllers;

import co.com.savia.employeemanagement.config.CustomFacesContext;
import co.com.savia.employeemanagement.entities.Departamento;
import co.com.savia.employeemanagement.services.DepartamentoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.ResourceBundle;
@Model
public class DepartamentoController {
    private Departamento departamento;
    private long id;

    @Inject
    private DepartamentoService service;

    @Inject
    @CustomFacesContext
    private FacesContext facesContext;

    @Inject
    private ResourceBundle bundle;

    @Produces
    @RequestScoped
    @Named("listadoDepartamentos")
    public List<Departamento> findAll() {
        return service.findAll();
    }

    @Produces
    @Model
    public Departamento departamento() {
        this.departamento = new Departamento();
        service.findById(id).ifPresent(p -> {
            this.departamento = p;
        });

        return departamento;
    }
    public String edit(Long id){
        this.id = id;
        return "formdep.xhtml";
    }
    public String save() {
        System.out.println(departamento);

        if (departamento.getId() != null && departamento.getId() > 0) {
            facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("departamento.mensaje.editar"),
                    departamento.getDepartamentoNombre())));
        } else {
            facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("departamento.mensaje.crear"),
                    departamento.getDepartamentoNombre())));
        }
        service.save(departamento);
        return "departamentos.xhtml?faces-redirect=true";
    }

    public String delete(Departamento departamento){
        service.delete(departamento.getId());
        facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("departamento.mensaje.eliminar"),
                departamento.getDepartamentoNombre())));
        return "departamentos.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
