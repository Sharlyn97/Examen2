/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Moon
 */
public class Usuario {
    
    private String cedula;
    private String nombre;
    private int edad;
    private String prioridad;
    private int numeroCita;
    private String fechaCita;
    Usuario siguiente;

    public Usuario(String cedula, String nombre, int edad, String prioridad, int numeroCita, String fechaCita, Usuario siguiente) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.prioridad = prioridad;
        this.numeroCita = numeroCita;
        this.fechaCita=fechaCita;
        this.siguiente = siguiente;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
     * @return the prioridad
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the numeroCita
     */
    public int getNumeroCita() {
        return numeroCita;
    }

    /**
     * @param numeroCita the numeroCita to set
     */
    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    
    public String getFicha() {
        return fechaCita;
    }

    /**
     * @param fechaCita the numeroCita to set
     */
    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
    /**
     * @return the usuario
     */
    public Usuario getSiguiente() {
        return siguiente;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setSiguiente(Usuario siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
