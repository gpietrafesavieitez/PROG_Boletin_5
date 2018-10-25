package boletin_5_1;
import java.util.Scanner;

public class Boletin_5_1{

    private static int menuBanco(){
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        
            System.out.println("\n"
                    + "[1] Ver datos de su cuenta bancaria\n"
                    + "[2] Ingresar dinero\n"
                    + "[3] Retirar dinero\n"
                    + "[4] Realizar una transferencia\n"
                    + "[0] Salir");
            
            try{
                opcion = Integer.parseInt(leer.nextLine());
                
            }catch(NumberFormatException e){
                opcion = -1;
                
            }
        
        return opcion;
       
    }

    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        
        int opcion;
        
        Conta cuenta1 = new Conta("Gabriel","1234",100);
        Conta cuenta2 = new Conta("Belfegor","666",666);
        
        System.out.println("[*] Bienvenido a su cuenta bancaria. \n[*] Porfavor, seleccione una opción de las que aparecen a continuación:");
        
        do{
            
            switch(opcion = menuBanco()){
                case 1: cuenta1.visualizar(); break;
                case 2: 
                    System.out.print("\n[-] Introduce la cantidad que deseas ingresar: "); 
                    double c = leer.nextInt();
                    cuenta1.ingresar(c);
                    break;
                case 3: break;
                case 4: break;
                case 0: System.out.println("\n[*] ¡Hasta luego!"); break;
                default: System.out.println("\n[*] Error: Formato incorrecto"); break;
                
            }
            
        }while(opcion != 0);
            
    }
        

        
}
