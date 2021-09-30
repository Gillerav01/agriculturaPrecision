package Utilidades;

public class Iterador<T> {
    
    private ListaFinal lista;
    private Nodo<T> actual;

    public Iterador() {
    }

    public Iterador(ListaFinal lista) {
        this.lista = lista;
        this.actual = lista.getPrim();
    }

    public ListaFinal getLista() {
        return lista;
    }

    public void setLista(ListaFinal lista) {
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
