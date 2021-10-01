package Entidades;

import java.util.Scanner;

public class Dron {
    private int idDron;
    private String modeloDron;

    public Dron() {
        
    }

    public Dron(int idDron, String modeloDron) {
        this.idDron = idDron;
        this.modeloDron = modeloDron;
    }
    
    public int getIdDron() {
        return idDron;
    }

    public void setIdDron(int idDron) {
        this.idDron = idDron;
    }

    public String getModeloDron() {
        return modeloDron;
    }

    public void setModeloDron(String modeloDron) {
        this.modeloDron = modeloDron;
    }

    @Override
    public String toString() {
        return "Este dron tiene la ID: " + idDron + ". El modelo del dron es: " + modeloDron;
    }
    
    public static Dron crearDron(){
        Scanner in;
        Dron nuevo = new Dron();
        int id = 0;
        String modelo = "";
        System.out.println("Introduzca el ID del dron: ");
        in = new Scanner (System.in);
        id = in.nextInt();
        nuevo.setIdDron(id);
        System.out.println("Introduzca la marca del dron: ");
        in = new Scanner (System.in);
        modelo = in.nextLine();
        nuevo.setModeloDron(modelo);
        return nuevo;
    }    
    
}
