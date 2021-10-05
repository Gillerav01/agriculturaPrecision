package Main;

import Entidades.*;
import static Entidades.Agricultor.registrar;
import Utilidades.*;
import static Utilidades.Menus.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        String seguir = "";
        Lista<Agricultor> agricultores = new Lista();
        Agricultor a1 = new Agricultor(1, "21141255T", "Guillermo", "Illera", "abc123.");
        Agricultor a2 = new Agricultor(2, "97415987Z", "Nina", "Goyanes", "abc123.");
        Agricultor a3 = new Agricultor(3, "12348927N", "Pepe", "Alba", "abc123.");
        Agricultor a4 = new Agricultor(4, "a", "Test", "Teando", "a");

        agricultores.añadir(a1);
        agricultores.añadir(a2);
        agricultores.añadir(a3);
        agricultores.añadir(a4);

        Lista<Dron> drones = new Lista();
        Dron d1 = new Dron(1, "DJI Inspire 2 Premium Combo");
        Dron d2 = new Dron(2, "DJI Inspire 3 Premium Combo");
        Dron d3 = new Dron(3, "DJI Inspire 1 Premium Combo");
        drones.añadir(d1);
        drones.añadir(d2);
        drones.añadir(d3);
        a1.setIdDron(d1.getIdDron());

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
        Parcela parcela2 = new Parcela(2, 500, 4, lp1);
        parcelas.añadir(p);
        parcelas.añadir(parcela2);

        Scanner in;
        int opcion = -1;

        do {
            menuLogin();
            System.out.print("Introduzca la opción deseada: ");
            in = new Scanner(System.in);
            opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    String DNI = "",
                    Contrasena = "";
                    System.out.print("Introduzca el DNI: ");
                    in = new Scanner(System.in);
                    DNI = in.nextLine();
                    System.out.print("Introduzca la contraseña: ");
                    in = new Scanner(System.in);
                    Contrasena = in.nextLine();
                    if (Agricultor.iniciarSesion(DNI, Contrasena, agricultores)) {
                        confirmacionLogin();
                        Agricultor agricultorLogueado = Agricultor.seleccionarAgricultor(DNI, agricultores);
                        in = new Scanner(System.in);
                        seguir = in.nextLine();
                        Cola<Tarea> tareas = new Cola();
                        Lista<Tarea> tareasTerminadas = new Lista();
                        do {
                            menuAgricultor();
                            in = new Scanner(System.in);
                            System.out.print("Introduzca la opcion deseada: ");
                            opcion = in.nextInt();
                            switch (opcion) {
                                case 1:
                                    Dron n = Dron.crearDron();
                                    agricultorLogueado.setIdDron(n.getIdDron());
                                    drones.añadir(n);
                                    break;
                                case 2:
                                    System.out.println(Agricultor.buscarDron(agricultorLogueado.getIdDron(), drones));
                                    in = new Scanner(System.in);
                                    System.out.println("Pulse enter para continuar");
                                    seguir = in.nextLine();
                                    break;
                                case 3:
                                    int numero = 0;
                                    in = new Scanner(System.in);
                                    System.out.print("¿Cuantas parcelas quieres añadir? ");
                                    numero = in.nextInt();
                                    for (int i = 1; i < (numero + 1); i++) {
                                        System.out.println("Añadiendo parcela numero " + i);
                                        Parcela nueva = Parcela.crearParcela(agricultorLogueado.getIdAgricultor());
                                        parcelas.añadir(nueva);
                                    }
                                    break;
                                case 4:
                                    int idBorrar = 0;
                                    System.out.println(" |--------------------------------------------------|");
                                    System.out.println(" |                   Tus parcelas                   |");
                                    System.out.println(" |--------------------------------------------------|");
                                    Lista parcelasLogueado = Parcela.buscarParcelas(agricultorLogueado.getIdAgricultor(), parcelas);
                                    parcelasLogueado.leer();
                                    in = new Scanner(System.in);
                                    System.out.print("Introduzca la ID de la parcela a borrar: ");
                                    idBorrar = in.nextInt();
                                    parcelas.borrar(Parcela.buscarParcela(agricultorLogueado.getIdAgricultor(), idBorrar, parcelas));
                                    System.out.println("Parcela eliminada correctamente.");
                                    break;
                                case 5:
                                    Parcela.buscarParcelas(agricultorLogueado.getIdAgricultor(), parcelas).leer();
                                    break;
                                case 6:
                                    in = new Scanner(System.in);
                                    System.out.print("¿Cuantos trabajos quieres añadir? ");
                                    numero = in.nextInt();
                                    for (int i = 1; i < (numero + 1); i++) {
                                        System.out.println("Añadiendo trabajo numero " + i);
                                        tareas.encolar(Tarea.registrarTarea((tareas.length() + 1), agricultorLogueado.getIdDron(), agricultorLogueado.getIdAgricultor()));
                                    }
                                    System.out.println("Trabajo(s) añadido(s) con exito. Pulse enter para continuar.");
                                    seguir = in.nextLine();
                                    break;
                                case 7:
                                    tareas.leer();
                                    break;
                                case 8:
                                    in = new Scanner (System.in);
                                    int idTrabajar = 0;
                                    System.out.println("Introduzca la id de la parcela a trabajar: ");
                                    idTrabajar = in.nextInt();
                                    tareasTerminadas.concatenar(Tarea.ejecutarTareas(tareas, idTrabajar, parcelas));
                                    break;
                                case 9:
                                    tareasTerminadas.leer();
                                    break;
                                case 10:
                                    System.out.println(" |--------------------------------------------------|");
                                    System.out.println(" |                   Tus tareas                     |");
                                    System.out.println(" |--------------------------------------------------|");
                                    tareas.leer();
                                    System.out.println(" |--------------------------------------------------|");
                                    System.out.println("Introduzca el ID de la tarea a borrar: ");
                                    int idTareaBorrar = 0;
                                    in = new Scanner (System.in);
                                    idTareaBorrar = in.nextInt();
                                    tareas.borrar(Tarea.buscarTarea(idTareaBorrar, tareas));
                                    System.out.println("Tarea borrada con exito. Pulse enter para continuar.");
                                    seguir = in.nextLine();
                                    break;
                                default:
                                    break;
                            }
                        } while (opcion != 0);
                    }
                    break;
                case 2:
                    Agricultor nuevo = registrar();
                    agricultores.añadir(nuevo);
                    System.out.println("Agricultor " + nuevo.getNombre() + " registrado con exito. Pulse cualquier tecla para continuar.");
                    in = new Scanner(System.in);
                    seguir = in.nextLine();
                    break;
                default:
                    break;
            }

        } while (opcion != 0);
    }

}
