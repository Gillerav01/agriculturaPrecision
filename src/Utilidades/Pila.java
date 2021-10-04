package Utilidades;

public class Pila<T> {
    private Nodo<T> cima;
    
    public Pila (){
        cima = null;
    }

    public Pila(Nodo<T> cima) {
        this.cima = cima;
    }

    public Nodo<T> getCima() {
        return cima;
    }

    public void setCima(Nodo cima) {
        this.cima = cima;
    }
    
    public T top(){
        return cima.getInfo();
    } 
    
    public T pop(){
        T ret = null;
        if (!esVacia()) {
            ret = this.getCima().getInfo();
            cima = cima.getSig();
        }
        return ret;
    }
    
    public void push (T x) {
        Nodo<T> nuevo = new Nodo(x, null);
        if (esVacia()) {
            this.setCima(nuevo);
        } else {
            nuevo.setSig(cima);
            this.setCima(nuevo);
        }
    }
    
    public boolean esVacia(){
        return cima == null;
    }
    
    public Pila mezclar (Pila a, Pila b) {
        Pila nueva = new Pila();
        
        if (!a.esVacia() || !b.esVacia()) {
            while (a.getCima() != null || b.getCima() != null) {
                nueva.push(a.pop());
                nueva.push(b.pop());                
            }
        }
        return nueva;
    }
    
        public void leer () {
        Nodo<T> aux = cima;
        System.out.println( "\n" + " --------------------" + "\n");
        while (aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getSig();
        }
        System.out.println( "\n" + " --------------------" + "\n");
    }
        
        public int length () {
        int ret = 0;
        Nodo aux = this.getCima();
        
        while (aux != null) {
            ret++;
            aux = aux.getSig();
        }
        return ret;
    }
        
        public boolean borrar (T x) {
            Nodo<T> aux = cima;
            Nodo<T> ant = null;
            boolean encontrado = false;
                while (aux != null) {
                    if (aux.getInfo() == x){
                        if (ant == null){
                            this.cima = aux.getSig();
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
