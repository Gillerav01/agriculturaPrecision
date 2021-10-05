package Utilidades;

public class Cola<T> {
    private Nodo<T> primero;
    private Nodo<T> fin;

    public Cola() {
        this.primero = null;
        this.fin = null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }
    
    public boolean encolar(T x){
        Nodo<T> nuevo = new Nodo(x, null);
        boolean encolado = false;
        if (this.esVacia()) {
            primero = nuevo;
            fin = nuevo;
            encolado = true;
        } else {
            fin.setSig(nuevo);
            fin = nuevo;
            encolado = true;
        }
        return encolado;
    }
    
    public T desencolar(){
        T x = null;
        if (!esVacia()) {
            x = primero.getInfo();
            primero = primero.getSig();
        }
        return x;
    }
    

    
    public T leerPrimero(){
        T x = null;
        if (!esVacia()){
            x = primero.getInfo();
        }
        return x;
    }
    
    public boolean esVacia() {
        return this.primero == null;
    }

    public Pila fusionarCola (Cola a, Cola b) {
        Pila ret = new Pila();
        
         if (!a.esVacia() || !b.esVacia()) {
                  ret.setCima(a.primero);
                  a.primero = a.primero.getSig();
                  
                  // Primero L1 1  L2 2  L1 3 4 5 6 L2 7 8 9 10
                  
         }
        
        return ret;
    }
    
    public void leer () {
        Nodo<T> aux = primero;
        System.out.println( "\n" + " --------------------" + "\n");
        while (aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getSig();
        }
        System.out.println( "\n" + " --------------------" + "\n");
    }
        public int length () {
        int ret = 0;
        Nodo aux = this.primero;
        
        while (aux != null) {
            ret++;
            aux = aux.getSig();
        }
        return ret;
    }
        
    public boolean borrar (T x) {
        Nodo<T> aux = primero;
        Nodo<T> ant = null;
        boolean encontrado = false;
            while (aux != null) {
                if (aux.getInfo() == x){
                    if (ant == null){
                        this.primero = aux.getSig();
                    } else {
                    ant.setSig(aux.getSig());
                    }
                    encontrado = true;
                } else ant = aux;
                aux = aux.getSig();
        }
        return encontrado;  
    }
    
}
