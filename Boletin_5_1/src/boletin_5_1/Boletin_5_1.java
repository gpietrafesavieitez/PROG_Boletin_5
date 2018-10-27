package boletin_5_1;
import java.util.Scanner;

public class Boletin_5_1{
    
    private static Scanner leer = new Scanner(System.in);
    private static Conta cuentaOrigen = new Conta("Gabriel","1234",100);
    private static Conta cuentaDestino = new Conta("Belfegor","666",666);
    
    private static int menuBanco(){
        int opcion = 0;

        System.out.println("\n  __  __                         _         _           _ \n" +
" |  \\/  |___ _ _ _  _   _ __ _ _(_)_ _  __(_)_ __ __ _| |\n" +
" | |\\/| / -_| ' | || | | '_ | '_| | ' \\/ _| | '_ / _` | |\n" +
" |_|  |_\\___|_||_\\_,_| | .__|_| |_|_||_\\__|_| .__\\__,_|_|\n" +
"                       |_|                  |_|          \n"
                + "\n[1] Ver datos de su cuenta bancaria.\n"
                + "[2] Ingresar dinero.\n"
                + "[3] Retirar dinero.\n"
                + "[4] Realizar una transferencia.\n"
                + "[0] Salir.");
        try{
            opcion = Integer.parseInt(leer.nextLine());
        }catch(NumberFormatException e){
            opcion = -1;
        }
    return opcion;
    }

    public static void main(String[] args){
        System.out.println("[*] Bienvenido a su cuenta bancaria. \n[*] Porfavor, seleccione una opción de las que aparecen a continuación:");
        int opcion;
        do{
            opcion = menuBanco();
            switch(opcion){
                case 1:
                    System.out.print("\n[*] Detalles de su cuenta bancaria: ");
                    cuentaOrigen.visualizar(); break;
                case 2:
                    System.out.print("\n[-] Introduzca la cantidad que desea ingresar: ");
                    try{
                        if(cuentaOrigen.ingresar(Integer.parseInt(leer.nextLine())) == true){
                            System.out.println("\n[*] Operación realizada correctamente.");
                        }else{
                            System.out.println("\n[*] Operación fallida. Porfavor, inténtelo de nuevo.");
                        }
                    }catch(NumberFormatException e){
                        System.out.println("\n[*] Formato incorrecto.");
                    }
                    break;
                case 3:
                    System.out.print("\n[-] Introduzca la cantidad que desea retirar: ");
                    try{
                        if(cuentaOrigen.retirar(Integer.parseInt(leer.nextLine())) == true){
                            System.out.println("\n[*] Operación realizada correctamente.");
                        }else{
                            System.out.println("\n[*] Operación fallida. Porfavor, inténtelo de nuevo.");
                        }
                    }catch(NumberFormatException e){
                        System.out.println("\n[*] Formato incorrecto.");
                    }
                    break;
                case 4:
                    System.out.print("\n[-] Introduzca la cantidad que desea transferir: ");
                    try{
                        double importe = Double.parseDouble(leer.nextLine());
                        System.out.print("\n[-] Introduzca el número de cuenta de destino: ");
                        String leerNumCuentaDestino = leer.nextLine();
                        String numCuentaDestino = cuentaDestino.getNumero();
                        if(cuentaOrigen.transferencia(numCuentaDestino, importe) == true){
                            if(leerNumCuentaDestino.equals(numCuentaDestino)){
                                cuentaDestino.ingresar(importe);
                                System.out.println("\n[*] Operación realizada correctamente.");
                                cuentaDestino.visualizar(); //Debug
                            }else{
                                System.out.println("[*] No existe ninguna cuenta con ese número de cuenta. Operación cancelada.");
                            }
                        }else{
                            System.out.println("\n[*] Operación fallida. Porfavor, inténtelo de nuevo.");
                        }
                    }catch(NumberFormatException e){
                        System.out.println("\n[*] Formato incorrecto.");
                    }
                    break;
                case 0: System.out.println("\n[*] ¡Hasta luego!"); break;
                default: System.out.println("\n[*] Formato incorrecto."); break;
            }
        }while(opcion != 0);   
    }
   
}
