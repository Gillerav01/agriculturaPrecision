package Entidades;

import Utilidades.Cola;
import Utilidades.Iterador;
import Utilidades.Lista;
import Utilidades.Nodo;
import Utilidades.Pila;
import java.sql.Date;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Tarea {

    private int idTrabajo;
    private int idParcela;
    private int idDron;
    private char tipoTarea;
    private String fecha; // Pedir fecha al sistema y estamparla como texto
    private boolean Realizado;

    public Tarea() {
    }

    public Tarea(int idTrabajo, int idParcela, int idDron, char tipoTarea, String fecha, boolean Realizado) {
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

    public char getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(char tipoTarea) {
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
        return "El trabajo con id: " + idTrabajo + " está asignado a la parcela: " + idParcela + " con el dron: " + idDron
                + "Se trata de una: " + tipoTarea + " ¿Realizada? " + Realizado;
    }

    public static Tarea registrarTarea(int idTrabajo, int idDron, int idAgricultor) {
        Tarea nueva = new Tarea();
        Scanner in;
        int idParcela = 0;
        char tipoTarea = ' ';
        boolean Realizado = false;
        Calendar fecha = new GregorianCalendar();
        String fechaString = fecha.get(Calendar.DAY_OF_MONTH) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR);

        System.out.print("Introduzca el ID de la parcela a trabajar: ");
        in = new Scanner(System.in);
        idParcela = in.nextInt();
        nueva.setIdTrabajo(idTrabajo);
        nueva.setIdDron(idDron);
        nueva.setIdParcela(idParcela);

        System.out.print("Introduzca el tipo del trabajo (Abonado / Fumigacion): ");
        in = new Scanner(System.in);
        tipoTarea = in.nextLine().toLowerCase().charAt(0);
        if (tipoTarea == 'a' || tipoTarea == 'f') {
            nueva.setTipoTarea(tipoTarea);
        }
        nueva.setFecha(fechaString);
        nueva.setRealizado(Realizado);

        return nueva;
    }

    public static Tarea buscarTarea(int idTarea, Cola<Tarea> l) {
        Tarea ret = null;

        Nodo aux = l.getPrimero();

        while (aux != null) {
            Tarea t = (Tarea) aux.getInfo();
            if (t.idTrabajo == idTarea) {
                ret = t;
                return ret;
            }
            aux = aux.getSig();
        }

        return ret;
    }

    public static Lista leerRealizadas(Lista<Tarea> l) {
        Lista ret = new Lista();
        Iterador<Tarea> it = new Iterador(l);
        while (it.hasNext()) {
            if (it.dameValor().isRealizado()) {
                ret.añadir(it.dameValor());
            }
            it.setActual(it.next());
        }
        return ret;
    }
    
    public static Lista ejecutarTareas (Cola<Tarea> c, int idParcela, Lista<Parcela> l) throws InterruptedException {
        Nodo<Tarea> aux2 = c.getPrimero();
        Nodo<Parcela> aux = l.getPrim();
        Lista ret = new Lista();
        while (aux != null) {
            if (aux.getInfo().getIdParcela() == idParcela){
                Lista<Punto> puntos = aux.getInfo().getListaPuntos();
                Nodo aux3 = puntos.getPrim();
                while (aux2 != null){
                    while (aux3 != null) {
                        System.out.println("El punto actual es: " + aux3.getInfo());
                        aux3 = aux3.getSig();
                    }
                    aux2.getInfo().setRealizado(true);
                    ret.añadir(c.desencolar());
                    aux2 = aux2.getSig();
                }
            }
            aux = aux.getSig();
        }
        return ret;
    }
}

// Thread.sleep(tiempoMilisegundos);