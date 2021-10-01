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
        
        Lista<Punto> lp1 = new Lista();
        Punto p1 = new Punto(32, 439, 32);
        Punto p2 = new Punto(12, 428, 125);
        Punto p3 = new Punto(76, 405, 7);
        Punto p4 = new Punto(543, 906, 23);
        Punto p5 = new Punto(102, 207, 76);
        Punto p6 = new Punto(45, 494, 10);
        
        lp1.añadir(p1);
        lp1.añadir(p2);
        lp1.añadir(p3);
        lp1.añadir(p4);
        lp1.añadir(p5);
        lp1.añadir(p6);
        
        Lista<Parcela> parcelas = new Lista();
        Parcela p = new Parcela(1, 500, 1, lp1);
        parcelas.añadir(p);
        
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
                                   Dron b = Agricultor.buscarDron(agricultorLogueado.getIdDron(), drones);
                                   System.out.println("El dron registrado para el Agricultor " + agricultorLogueado.getNombre() 
                                                    + " es el dron con la ID " + agricultorLogueado.getIdDron() + 
                                                      " y el modelo es: " + b.getModeloDron());
                                   break;
                               case 3:
                                   Parcela.crearParcela(agricultorLogueado.getIdAgricultor());
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
