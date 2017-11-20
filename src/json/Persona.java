package json;

import java.util.ArrayList;

public class Persona {
	
	private String nombre;
	private String apellido;
	private int edad;
	private ArrayList<String> telefonos = new ArrayList<String>();
	
	
	
	/**
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param telefonos
	 */
	public Persona(String nombre, String apellido, int edad, ArrayList<String> telefonos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.telefonos = telefonos;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * @return the telefonos
	 */
	public ArrayList<String> getTelefonos() {
		return telefonos;
	}
	/**
	 * @param telefonos the telefonos to set
	 */
	public void setTelefonos(ArrayList<String> telefonos) {
		this.telefonos = telefonos;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Persona [nombre=%s, apellido=%s, edad=%s, telefonos=%s]", nombre, apellido, edad,
				telefonos);
	}
	
	

}
