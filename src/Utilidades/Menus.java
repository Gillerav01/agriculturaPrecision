package Utilidades;

public class Menus {
    public static void menuLogin(){
        System.out.println("|---------------------------------------------------------|" + "\n"
                             + "|--------------------------Login--------------------------|" + "\n" 
                             + "|---------------------------------------------------------|" + "\n"
                             + "| 1. Iniciar sesion                                       |" + "\n"
                             + "| 2. Registrar Agricultor                                 |" + "\n" 
                             + "| 0. Salir del menú.                                      |" + "\n"
                             + "|---------------------------------------------------------|");
    }
    
    public static void confirmacionLogin(){
                        System.out.println("|---------------------------------------------------------|" + "\n"
                                         + "|------------ Has iniciado sesion correctamente ----------|" + "\n" 
                                         + "|---------------------------------------------------------|" + "\n" 
                                         + "|       Introduzca cualquier tecla para continuar...      |" + "\n" 
                                         + "|---------------------------------------------------------|" + "\n");
    };
    
    public static void menuAgricultor(){
        System.out.println("|---------------------------------------------------------|" + "\n"
                         + "|--------------------- Menú principal --------------------|" + "\n" 
                         + "|---------------------------------------------------------|" + "\n"
                         + "| 1. Registrar dron                                       |" + "\n"
                         + "| 2. Ver mi dron                                          |" + "\n"
                         + "| 3. Registrar parcelas                                   |" + "\n"
                         + "| 4. Eliminar parcela                                     |" + "\n"
                         + "| 5. Ver mis parcelas                                     |" + "\n"
                         + "| 6. Registrar trabajo                                    |" + "\n"
                         + "| 7. Ver los trabajos realizados                          |" + "\n"
                         + "|---------------------------------------------------------|");
    }
    
    
    
}
