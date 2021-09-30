package Utilidades;

public class ListaFinal <T> {

    private Nodo<T> prim;
    private Nodo<T> fin;

    public ListaFinal() {
        this.prim = null;
        this.fin = null;
    }

    public Nodo<T> getPrim() {
        return prim;
    }

    public void setPrim(Nodo<T> prim) {
        this.prim = prim;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public boolean esVacia() {
        return this.prim == null && this.fin == null;
    }

    public void add(T x) {
        Nodo<T> nuevo = new Nodo(x, null);

        if (this.esVacia()) {
            prim = nuevo;
            fin = nuevo;
        } else {
            nuevo.setSig(prim);
            prim = nuevo;
        }
    }

    public void addFin(T x) {
        Nodo<T> nuevo = new Nodo(x, null);
        if (this.esVacia()) {
            prim = nuevo;
            fin = nuevo;
        } else {
            fin.setSig(nuevo);
            fin = nuevo;
        }
    }

    public void leer() {
        Nodo<T> aux = prim;
        System.out.println("\n" + "--------------------------");
        while (aux != null) {
            System.out.println(aux.getInfo() + " ");
            aux = aux.getSig();
        }
    }

    public boolean borrar(T x) {
        boolean encontrado = false;
        Nodo<T> aux = prim;
        Nodo<T> ant = null;

        while (aux != null) {
            if (aux.getInfo() == x) {
                if (ant == null) {
                    this.prim = aux.getSig();
                } else {
                    ant.setSig(aux.getSig());
                }
                encontrado = true;
            } else {
                ant = aux;
            }
            aux = aux.getSig();
        }

        return encontrado;
    }

    public void borrarPrimero() {
        if (!this.esVacia()) {
            this.prim = prim.getSig();
        }
    }

    public T leerPrimero() {
        T x = null;
        if (!esVacia()) {
            x = prim.getInfo();
        }
        return x;
    }
    
    public void concatenar(ListaFinal lf) {
        Nodo<T> aux = lf.prim;
        while (aux != null) {
            this.addFin(aux.getInfo());
            aux = aux.getSig();
        }
    }
    
    public int length () {
        int ret = 0;
        Nodo aux = this.prim;
        
        while (aux != null) {
            ret++;
            aux = aux.getSig();
        }
        return ret;
    }
    
    public void reverse () {
        ListaFinal l = this;
        Nodo<T> aux = l.getPrim();
        this.prim = null;
        this.fin = null;
        while (aux != null) {
           this.add(aux.getInfo());
           aux = aux.getSig();
        }
    }
}