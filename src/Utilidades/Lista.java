package Utilidades;

public class Lista <T>{
    private Nodo<T> prim;

    public Lista() {
        this.prim = null;
    }

    public Nodo<T> getPrim() {
        return prim;
    }

    public void setPrim(Nodo<T> prim) {
        this.prim = prim;
    }
    
    // TODOO Leer, repetido
    
    public boolean esVacia() {
        return this.prim == null;
    }
    
    public void añadir (T x){
        Nodo<T> nuevo = new Nodo (x, null);
        if (this.esVacia()) {
            prim = nuevo;
        } else {
            nuevo.setSig(prim);
            prim = nuevo;
        }
    }
    
    public boolean existe (T x){
        
        Nodo<T> aux = prim;
        
        while (aux.getSig() != null){
            if (aux.getInfo() == x) {
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }
    
    public int repetido(T x) {
        int repeticiones = -1;
        Nodo<T> aux = prim;
        while (aux.getSig() != null) {
            if (x == aux.getInfo()) {
                repeticiones = repeticiones + 1;
            }
            aux = aux.getSig();
        }
        return repeticiones;
    }
    
    public void leer () {
        Nodo<T> aux = prim;
        System.out.println( "\n" + " --------------------" + "\n");
        while (aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getSig();
        }
        System.out.println( "\n" + " --------------------" + "\n");
    }
    
    public boolean borrar (T x) {
        Nodo<T> aux = prim;
        Nodo<T> ant = null;
        boolean encontrado = false;
            while (aux != null) {
                if (aux.getInfo() == x){
                    if (ant == null){
                        this.prim = aux.getSig();
                    } else {
                    ant.setSig(aux.getSig());
                    }
                    encontrado = true;
                } else ant = aux;
                aux = aux.getSig();
        }
        return encontrado;  
    }
    
    public int length () {
        int ret = 0;
        Nodo aux = this.getPrim();
        
        while (aux != null) {
            ret++;
            aux = aux.getSig();
        }
        return ret;
    }
    
        public void concatenar(Lista lf) {
        Nodo<T> aux = lf.prim;
        while (aux != null) {
            this.añadir(aux.getInfo());
            aux = aux.getSig();
        }
    }
    
 }
