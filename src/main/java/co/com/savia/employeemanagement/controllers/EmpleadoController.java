package co.com.savia.employeemanagement.controllers;

import co.com.savia.employeemanagement.config.CustomFacesContext;
import co.com.savia.employeemanagement.entities.DocumentoTipo;
import co.com.savia.employeemanagement.entities.Empleado;
import co.com.savia.employeemanagement.services.EmpleadoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

@Model
public class EmpleadoController {
    private Empleado empleado;
    private long id;
    @Setter
    @Getter
    private Long selectedDepartamentoId;

    @Inject
    private EmpleadoService empleadoService;

    @Inject
    @CustomFacesContext
    private FacesContext facesContext;

    @Inject
    private ResourceBundle bundle;

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Empleado> findAll() {
        return empleadoService.findAll();
    }

    @Produces
    @Model
    public Empleado empleado() {
        this.empleado = new Empleado();
        empleadoService.findById(id).ifPresent(p -> {
            this.empleado = p;
        });

        return empleado;
    }
    public String edit(Long id){
        this.id = id;
        return "form.xhtml";
    }
    public String save() {
        empleadoService.save(empleado);
        if (empleado.getId() != null && empleado.getId() > 0) {
            facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("empleado.mensaje.editar"),
                    empleado.getNombres())));
        } else {
            facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("empleado.mensaje.crear"),
                    empleado.getNombres())));
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String delete(Empleado empleado){
        empleadoService.delete(empleado.getId());
        facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("empleado.mensaje.eliminar"),
                empleado.getNombres())));
        return "index.xhtml?faces-redirect=true";
    }

    public List<DocumentoTipo> getDocumentoTipos() {
        return Arrays.asList(DocumentoTipo.values());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
