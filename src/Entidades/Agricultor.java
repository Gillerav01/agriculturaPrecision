package Entidades;

import Utilidades.Cola;
import Utilidades.Iterador;
import Utilidades.Lista;
import Utilidades.ListaFinal;
import Utilidades.Nodo;
import java.util.Scanner;

public class Agricultor {
    
    private int idAgricultor;
    private String dni;
    private String nombre;
    private String apellido;
    private String contrasena;
    private Cola colaTareas;
    private Lista tareasRealizadas;
    private int idDron;

    public Agricultor() {
    }

    public Agricultor(int idAgricultor, String dni, String nombre, String apellido, String contrasena) {
        this.idAgricultor = idAgricultor;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.colaTareas = new Cola();
        this.tareasRealizadas = new Lista();
    }

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(int idAgricultor) {
        this.idAgricultor = idAgricultor;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Cola getColaTareas() {
        return colaTareas;
    }

    public void setColaTareas(Cola colaTareas) {
        this.colaTareas = colaTareas;
    }

    public Lista getTareasRealizadas() {
        return tareasRealizadas;
    }

    public void setTareasRealizadas(Lista tareasRealizadas) {
        this.tareasRealizadas = tareasRealizadas;
    }

    public int getIdDron() {
        return idDron;
    }

    public void setIdDron(int idDron) {
        this.idDron = idDron;
    }

    @Override
    public String toString() {
        return "El agricultor " + nombre +" "+ apellido + " con DNI " + dni + "posee el siguiente Dron: " + idDron;
    }
    
    public static Agricultor registrar(){
    
        Agricultor n = new Agricultor();
        
        Scanner in;
        int id = 0;
        String dni = "", nombre = "", apellido = "",  contrasena = "";
        System.out.println("|-------------------------------------");
        System.out.println("|------ Bienvenido al registro ------|");
        System.out.println("|-------------------------------------");
        System.out.print(" Introduzca el ID: ");
        in = new Scanner(System.in);
        id = in.nextInt();
        System.out.print(" Introduzca su DNI: ");
        in = new Scanner(System.in);
        dni = in.nextLine();
        System.out.print(" Introduzca su nombre: ");
        in = new Scanner(System.in);
        nombre = in.nextLine();
        System.out.print(" Introduzca su apellido: ");
        in = new Scanner(System.in);
        apellido = in.nextLine();
        System.out.print(" Introduzca su contraseña: ");
        in = new Scanner(System.in);
        contrasena = in.nextLine();
        n.setIdAgricultor(id);
        n.setNombre(nombre);
        n.setApellido(apellido);
        n.setDni(dni);
        n.setContrasena(contrasena);
        
        return n;
    }
    
    public static boolean iniciarSesion(String DNI, String Contrasena, Lista<Agricultor> lista){
        boolean dniEncontrado = false, contrasenaEncontrada = false;
        Nodo aux = lista.getPrim();
        while(aux != null) {
            Agricultor a = (Agricultor) aux.getInfo();   
            if (a.getDni().equals(DNI)) {
                dniEncontrado = true;
                if (a.getContrasena().equals(Contrasena)) {
                    contrasenaEncontrada = true;
                    return true;
                }
            }
            aux = aux.getSig();
        }
        
        if (!dniEncontrado) {
            System.out.println("Esa combinacion de usuario y contraseña es incorrecta.");
        } else if (dniEncontrado && !contrasenaEncontrada) {
            System.out.println("La contraseña no es correcta.");
        }
        return false;
    };
    
        public static Agricultor seleccionarAgricultor(String DNI, Lista<Agricultor> l) {
        Agricultor ret = null;
        Nodo aux = l.getPrim();
        
        while(aux != null) {
            Agricultor a = (Agricultor) aux.getInfo(); 
            if (a.getDni().equals(DNI)) {
                    ret = a;
                    return ret;
                }
            aux = aux.getSig();
            }
        return null;
    }
        
        public static Dron buscarDron (int idDron, Lista<Dron> l) {
            Dron ret = null;
            Nodo aux = l.getPrim();
        
            while(aux != null) {
                Dron d = (Dron) aux.getInfo(); 
                if (d.getIdDron() == idDron) {
                        ret = d;
                        return ret;
                    }
                aux = aux.getSig();
                }
            return null;
        }
}