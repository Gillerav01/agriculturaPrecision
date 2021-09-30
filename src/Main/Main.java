package Main;

import static Utilidades.Menus.menuLogin;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int opcion = -1;
        do {
            menuLogin();
            System.out.print(" Introduzca la opción deseada: ");
            opcion = in.nextInt();
        } while(opcion != 0);

        
    }
    
}
