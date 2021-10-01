package Main;

import Entidades.*;
import static Entidades.Agricultor.registrar;
import Utilidades.*;
import static Utilidades.Menus.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String seguir = "";
        Lista<Agricultor> agricultores = new Lista();
        Agricultor a1 = new Agricultor("21141255T", "Guillermo", "Illera", "abc123.");
        Agricultor a2 = new Agricultor("97415987Z", "Nina", "Goyanes", "abc123.");
        Agricultor a3 = new Agricultor("12348927N", "Pepe", "Alba", "abc123.");
        
        agricultores.añadir(a1);
        agricultores.añadir(a2);
        agricultores.añadir(a3);

        Scanner in;
        int opcion = -1;

        do {
            menuLogin();
            System.out.print(" Introduzca la opción deseada: ");
            in = new Scanner (System.in);
            opcion = in.nextInt();
            
            switch (opcion) {
                case 1:
                    String DNI = "", Contrasena = "";
                    System.out.print("Introduzca el DNI: ");
                    in = new Scanner (System.in);
                    DNI = in.nextLine();
                    System.out.print("Introduzca la contraseña: ");
                    in = new Scanner (System.in);
                    Contrasena = in.nextLine();
                    if (Agricultor.iniciarSesion(DNI, Contrasena, agricultores)) {
                       confirmacionLogin();
                       in = new Scanner (System.in);
                       seguir = in.nextLine();
                       do {
                           
                       } while(opcion != 0);
                    }
                    break;
                case 2:
                    Agricultor nuevo = registrar();
                    agricultores.añadir(nuevo);
                    System.out.println("Agricultor " + nuevo.getNombre() + " registrado con exito. Pulse cualquier tecla para continuar.");
                    in = new Scanner (System.in);
                    seguir = in.nextLine();
                    break;
                default:
                    break;
            }
            
        } while(opcion != 0);
    }
    
}
