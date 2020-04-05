package proyecto.view.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import proyecto.view.modelo.Usuario;
import proyecto.view.servicio.ServicioUsuario;

@Named
@ViewScoped
public class ActualizarUsuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ServicioUsuario servicioUsuario;
	
	private List<String> countries;
	private String pais_seleccionado;
	
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		countries = servicioUsuario.countries();
		FacesContext fc = FacesContext.getCurrentInstance();
		String userId= fc.getExternalContext().getRequestParameterMap().get("userId");
		usuario = servicioUsuario.obtenerObjetoPorId(userId);
	}
	
	public void update() throws IOException {
		usuario.setPais(pais_seleccionado);
		servicioUsuario.update(usuario);
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		context.redirect("index.xhtml");
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public String getPais_seleccionado() {
		return pais_seleccionado;
	}

	public void setPais_seleccionado(String pais_seleccionado) {
		this.pais_seleccionado = pais_seleccionado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
