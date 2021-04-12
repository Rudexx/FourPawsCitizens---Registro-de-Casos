package co.edu.unbosque.controller;

public class Caso {

    private String Motivo;
    private String Especie;
    private String Tamano;
    private String Localidad;
    private String Direccion;
    private String NombrePersona;
    private String Telefono;
    private String Email;
    private String Comentarios;
    
    /**
	 * 
	 * Constructor de la clase, construye el caso.
	 * @param motivo: Tipo de caso a reportar
	 * 
	 */

    public Caso(String motivo){
        Motivo = motivo;
        Especie = "";
        Tamano= "";
        Localidad= "";
        Direccion="";
        NombrePersona="";
        Telefono= "";
        Email = "";
        Comentarios= "";
    }
    
    


	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return Motivo;
	}




	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}




	/**
	 * @return the especie
	 */
	public String getEspecie() {
		return Especie;
	}




	/**
	 * @param especie the especie to set
	 */
	public void setEspecie(String especie) {
		Especie = especie;
	}




	/**
	 * @return the tamano
	 */
	public String getTamano() {
		return Tamano;
	}




	/**
	 * @param tamano the tamano to set
	 */
	public void setTamano(String tamano) {
		Tamano = tamano;
	}




	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return Localidad;
	}




	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}




	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return Direccion;
	}




	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}




	/**
	 * @return the nombrePersona
	 */
	public String getNombrePersona() {
		return NombrePersona;
	}




	/**
	 * @param nombrePersona the nombrePersona to set
	 */
	public void setNombrePersona(String nombrePersona) {
		NombrePersona = nombrePersona;
	}




	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return Telefono;
	}




	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}




	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return Comentarios;
	}




	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}

	/**
	 * 
	 * Metodo toString de la clase. Devuelve String con los datos del caso
	 * @return un string con los datos del caso
	 * 
	 */


	@Override
	public String toString() {
		return "Caso:\nMotivo: " + Motivo + "\nEspecie: " + Especie + "\nTamano: " + Tamano + "\nLocalidad: " + Localidad
				+ "\nDireccion: " + Direccion + "\nNombrePersona: " + NombrePersona + "\nTelefono: " + Telefono
				+ "\nEmail: " + Email + "\nComentarios: " + Comentarios;
	}
    
}
