package com.unab.entidades;

public class ContactoPersonas {
    private int idContactos;
    private String nombre;
    private int edad;
    private String email;
    private String numeroDeTelefono;

    public ContactoPersonas() {
    }

    
    public ContactoPersonas(int idContactos) {
        this.idContactos = idContactos;
    }

    public ContactoPersonas(int idContactos, String nombre, int edad, String email, String numeroDeTelefono) {
        this.idContactos = idContactos;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public int getIdContactos() {
        return idContactos;
    }

    public void setIdContactos(int idContactos) {
        this.idContactos = idContactos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    @Override
    public String toString() {
        return "ContactoPersonas{" + "idContactos=" + idContactos + ", nombre=" + nombre + ", edad=" + edad + ", email=" + email + ", numeroDeTelefono=" + numeroDeTelefono + '}';
    }
    
    
    
    
}
