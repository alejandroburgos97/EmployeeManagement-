package co.com.savia.employeemanagement.converters;

import co.com.savia.employeemanagement.entities.Departamento;
import co.com.savia.employeemanagement.services.DepartamentoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Optional;

@RequestScoped
@Named("departamentoConverter")
public class DepartamentoConverter implements Converter<Departamento> {

    @Inject
    private DepartamentoService departamentoService;

    @Override
    public Departamento getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Optional<Departamento> departamentoOptional = departamentoService.findById(Long.valueOf(value));
        return departamentoOptional.orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Departamento departamento) {
        if (departamento == null) {
            return "";
        }
        return String.valueOf(departamento.getId());
    }
}