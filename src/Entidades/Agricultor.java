package Entidades;

import Utilidades.Cola;
import Utilidades.Lista;
import Utilidades.ListaFinal;

public class Agricultor {
    
    private String dni;
    private String nombre;
    private String apellido;
    private String contrasena;
    private Cola colaTareas;
    private Lista tareasRealizadas;
    private int idDron;

    public Agricultor() {
    }

    public Agricultor(String dni, String nombre, String apellido, String contrasena, Cola colaTareas, Lista tareasRealizadas, int idDron) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.colaTareas = colaTareas;
        this.tareasRealizadas = tareasRealizadas;
        this.idDron = idDron;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Cola getColaTareas() {
        return colaTareas;
    }

    public void setColaTareas(Cola colaTareas) {
        this.colaTareas = colaTareas;
    }

    public Lista getTareasRealizadas() {
        return tareasRealizadas;
    }

    public void setTareasRealizadas(Lista tareasRealizadas) {
        this.tareasRealizadas = tareasRealizadas;
    }

    public int getIdDron() {
        return idDron;
    }

    public void setIdDron(int idDron) {
        this.idDron = idDron;
    }

    @Override
    public String toString() {
        return "El agricultor " + nombre +" "+ apellido + " con DNI " + dni + "posee el siguiente Dron: " + idDron;
    }
}
