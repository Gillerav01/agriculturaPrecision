package Entidades;

import Utilidades.Lista;
import Utilidades.Nodo;
import java.util.ArrayList;
import java.util.Scanner;

public class Parcela {
    private int idParcela;
    private int Area;
    private int idAgricultor;
    private Lista<Punto> listaPuntos;

    public Parcela() {
    }

    public Parcela(int idParcela, int Area, int idAgricultor, Lista<Punto> listaPuntos) {
        this.idParcela = idParcela;
        this.Area = Area;
        this.idAgricultor = idAgricultor;
        this.listaPuntos = null;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public int getArea() {
        return Area;
    }

    public void setArea(int Area) {
        this.Area = Area;
    }

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(int idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public Lista<Punto> getListaPuntos() {
        return listaPuntos;
    }

    public void setListaPuntos(Lista<Punto> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }

    @Override
    public String toString() {
        return "La parcela registrada con el ID: " + idParcela + ". Tiene un area de: " + Area + "\n"
              +"Está al nombre del agricultor con ID: " + idAgricultor;
    } 
    
    public static Parcela crearParcela (int idAgricultor) {
        Parcela ret = new Parcela();
        Scanner in;
        int id = 0, area = 0;
        Lista<Punto> lista = new Lista();
        ret.setIdAgricultor(idAgricultor);
        System.out.println("Introduzca el ID de la parcela: ");
        in = new Scanner(System.in);
        id = in.nextInt();
        ret.setIdParcela(id);
        System.out.println("Introduzca el Area de la parcela: ");
        in = new Scanner(System.in);
        area = in.nextInt();
        ret.setIdParcela(area);
        for (int i = 1; i < 7; i++){
            Punto p = new Punto();
            System.out.println("Introduzca la X del punto numero " + i + " de 6.");
            in = new Scanner (System.in);
            p.setX(in.nextInt());
            System.out.println("Introduzca la Y del punto numero " + i + " de 6.");
            in = new Scanner (System.in);
            p.setY(in.nextInt());
            System.out.println("Introduzca la Z del punto numero " + i + " de 6.");
            in = new Scanner (System.in);
            p.setZ(in.nextInt());
            lista.añadir(p);
        }
        ret.setListaPuntos(lista);
        return ret;
    }
    
    public static Parcela buscarParcela (int idAgricultor, Lista<Parcela> l) {
                Parcela ret = null;
                Nodo aux = l.getPrim();
        
            while(aux != null) {
                Parcela p = (Parcela) aux.getInfo(); 
                if (p.getIdAgricultor() == idAgricultor) {
                        ret = p;
                        return ret;
                    }
                aux = aux.getSig();
                }
            return null;
        }
    }
