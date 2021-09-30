package Entidades;

import java.sql.Date;

public class Tarea {
    private int idTrabajo;
    private int idParcela;
    private int idDron;
    private String tipoTarea;
    private String fecha; // Pedir fecha al sistema y estamparla como texto
    private boolean Realizado;

    public Tarea() {
    }

    public Tarea(int idTrabajo, int idParcela, int idDron, String tipoTarea, String fecha, boolean Realizado) {
        this.idTrabajo = idTrabajo;
        this.idParcela = idParcela;
        this.idDron = idDron;
        this.tipoTarea = tipoTarea;
        this.fecha = fecha;
        this.Realizado = Realizado;
    }

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public int getIdDron() {
        return idDron;
    }

    public void setIdDron(int idDron) {
        this.idDron = idDron;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isRealizado() {
        return Realizado;
    }

    public void setRealizado(boolean Realizado) {
        this.Realizado = Realizado;
    }

    @Override
    public String toString() {
        return "El trabajo con id: " + idTrabajo + "está asignado a la parcela: " + idParcela + " con el dron: " + idDron + 
                "Se trata de una: " + tipoTarea;
    }
}
