package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int opcion = -1;
        do {
        
            
            System.out.println("----------------------------------------------------------" + "\n"
                             + "----------------------Menú principal----------------------" + "\n" 
                             + "----------------------------------------------------------"); 
            opcion = in.nextInt();
        } while(opcion != 0);

        
    }
    
}
