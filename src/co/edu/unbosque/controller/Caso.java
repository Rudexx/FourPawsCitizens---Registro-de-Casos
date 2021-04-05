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

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String especie) {
        Especie = especie;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String tamano) {
        Tamano = tamano;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombrePersona() {
        return NombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        NombrePersona = nombrePersona;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String comentarios) {
        Comentarios = comentarios;
    }

	@Override
	public String toString() {
		return  "\nMotivo=" + Motivo + "\nEspecie=" + Especie + "\nTamano=" + Tamano + "\nLocalidad=" + Localidad
				+ "\nDireccion=" + Direccion + "\nNombrePersona=" + NombrePersona + "\nTelefono=" + Telefono
				+ "\nEmail=" + Email + "\nComentarios=" + Comentarios;
	}
    
}
