package Main;

import Entidades.*;
import static Entidades.Agricultor.registrar;
import Utilidades.*;
import static Utilidades.Menus.*;
import static java.lang.Thread.sleep;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String seguir = "";
        Lista<Agricultor> agricultores = new Lista();
        Agricultor a1 = new Agricultor(1, "21141255T", "Guillermo", "Illera", "abc123.");
        Agricultor a2 = new Agricultor(2, "97415987Z", "Nina", "Goyanes", "abc123.");
        Agricultor a3 = new Agricultor(3, "12348927N", "Pepe", "Alba", "abc123.");
        
        agricultores.añadir(a1);
        agricultores.añadir(a2);
        agricultores.añadir(a3);
        
        Lista<Dron> drones = new Lista();
        Dron d1 = new Dron(1, "DJI Inspire 2 Premium Combo");
        Dron d2 = new Dron(2, "DJI Inspire 3 Premium Combo");
        Dron d3 = new Dron(3, "DJI Inspire 1 Premium Combo");
        drones.añadir(d1);
        drones.añadir(d2);
        drones.añadir(d3);

        Scanner in;
        int opcion = -1;

        do {
            menuLogin();
            System.out.print("Introduzca la opción deseada: ");
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
                       Agricultor agricultorLogueado = Agricultor.seleccionarAgricultor(DNI, agricultores);
                       in = new Scanner (System.in);
                       seguir = in.nextLine();
                       do {
                           menuAgricultor();
                           in = new Scanner (System.in);
                           opcion = in.nextInt();
                           switch (opcion) {
                               case 1:
                                   Dron n = Dron.crearDron();
                                   agricultorLogueado.setIdDron(n.getIdDron());
                                   drones.añadir(n);
                                   break;
                               case 2:
                                   break;
                               case 3:
                                   break;
                               case 4:
                                   break;
                               case 5:
                                   break;
                               case 6:
                                   break;
                               case 7:
                                   break;
                               default:
                                   break;
                           }
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
