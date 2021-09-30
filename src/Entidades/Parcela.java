package Entidades;

import Utilidades.Lista;
import java.util.ArrayList;

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
        this.listaPuntos = listaPuntos;
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
    
    
    
    
}
