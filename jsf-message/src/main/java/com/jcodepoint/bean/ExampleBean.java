package com.jcodepoint.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;

@Named("exampleBean")
@RequestScoped
public class ExampleBean {

	private String nombre;
	
 	@NotEmpty(message = "Debe ingresar un apellido.")
	private String apellido;
	
	private Integer edad;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void formSubmit() {
		if (this.edad < 18) {
			FacesContext.getCurrentInstance().addMessage("customerForm:it-edad", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ser mayor de 18 años.", "Debe ser mayor de 18 años."));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud procesada correctamente!", "Solicitud procesada correctamente!"));
		}
	}

}
