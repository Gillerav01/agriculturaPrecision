package Utilidades;

public class Nodo <T> {
    private T info;
    private Nodo <T> sig;

    public Nodo() {
        this.info = null;
        this.sig = null;
    }

    public Nodo(T info, Nodo<T> siguiente) {
        this.info = info;
        this.sig = siguiente;
    }
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getSig() {
        return sig;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }
    
    
    
}
