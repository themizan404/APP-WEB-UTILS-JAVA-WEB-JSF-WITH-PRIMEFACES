package proyecto.view.controlador;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import proyecto.view.modelo.Usuario;
import proyecto.view.servicio.ServicioUsuario;

@Named
@ViewScoped
public class EliminarUsuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String userId= fc.getExternalContext().getRequestParameterMap().get("userId");
		usuario = servicioUsuario.obtenerObjetoPorId(userId);
	}
	
	public void delete() throws IOException {
		servicioUsuario.delete(usuario);
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		context.redirect("index.xhtml");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
