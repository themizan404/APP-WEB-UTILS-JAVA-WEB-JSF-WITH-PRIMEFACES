package proyecto.view.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import proyecto.view.modelo.Usuario;

@Stateless
public class ServicioUsuario {
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void create(Usuario usuario) {
		usuario.setId(usuarios.size() + 1);
		usuarios.add(usuario);
	}
	
	public void update(Usuario usuario) {
		usuario.setNombre(usuario.getNombre());
		usuario.setApellido(usuario.getApellido());
		usuario.setEdad(usuario.getEdad());
		usuario.setPais(usuario.getPais());
		usuario.setDni(usuario.getDni());
	}
	
	public List<Usuario> list() {
		return usuarios;
	}
	
	public List<String> countries() {
		List<String> countries = new ArrayList<String>();
		countries.add("Argentina");
		countries.add("Alemania");
		countries.add("Perú");
		countries.add("Bolivia");
		countries.add("Venezuela");
		return countries;
	}
	
	public void delete(Usuario usuario) {
		System.out.println("Holamundo");
		usuarios.remove(usuario);
	}
	
	public Usuario obtenerObjetoPorId(String userId) {
		return usuarios.get(Integer.parseInt(userId) - 1);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
	
	
}
