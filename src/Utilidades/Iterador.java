package Utilidades;

public class Iterador<T> {
    
    private Lista lista;
    private Nodo<T> actual;

    public Iterador() {
    }

    public Iterador(Lista lista) {
        this.lista = lista;
        this.actual = lista.getPrim();
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Nodo<T> getActual() {
        return actual;
    }

    public void setActual(Nodo<T> actual) {
        this.actual = actual;
    }

            
    public boolean hasNext (){
        return actual != null;
    }
    
    public Nodo next (){
        return actual.getSig();
    }
    
    public T dameValor(){
        return actual.getInfo();
    }
    
    public void inicializar(){
        this.actual = lista.getPrim();
    }

    
}
