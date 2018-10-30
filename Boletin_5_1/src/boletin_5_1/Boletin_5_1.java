package boletin_5_1;
import java.util.Scanner;

/**
 * Interfaz del sistema de gestión de cuentas bancarias.
 * @author Gabriel P.
 * @version 1.0.0.
 * @since 2018.
 * @see <a href="https://www.danielcastelao.org">Moodle Daniel Castelao.</a>
 */
public class Boletin_5_1{
    private static Scanner leer = new Scanner(System.in);
    private static Conta cuentaOrigen = new Conta("Gabriel","1234",100);
    private static Conta cuentaDestino = new Conta("Belfegor","666",666);
    
    /**
     * Menú de selección de operaciones.
     * @return Devuelve la opción elegida para operar en el método main().
     */
    private static int menuBanco(){
        int opcion;
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
        try{ // Intenta convertir el input en int si no puede lanza excepcion y pone la var opcion a -1 
            opcion = Integer.parseInt(leer.nextLine());
        }catch(NumberFormatException e){
            opcion = -1;
        }
    return opcion;
    }

    /**
     * Ejecuta la operación correspondiente en función de la opción elegida en el método menuBanco(). 
     * @param args 
     */
    public static void main(String[] args){
        System.out.println("[*] Bienvenido a su cuenta bancaria. \n[*] Porfavor, seleccione una opción de las que aparecen a continuación:");
        int opcion;
        do{
            opcion = menuBanco(); // var opcion contiene el valor int devuelto por menuBanco()
            switch(opcion){
                case 0: System.out.println("\n[*] ¡Hasta luego!"); break; // Exit
                case 1: // Muestra datos de la cuenta
                    System.out.print("\n[*] Detalles de su cuenta bancaria: ");
                    cuentaOrigen.visualizar(); break;
                case 2: // Sistema de ingresos
                    System.out.print("\n[-] Introduzca la cantidad que desea ingresar: ");
                    try{
                        if(cuentaOrigen.ingresar(Integer.parseInt(leer.nextLine())) == true){ // Si el valor devuelto por el metodo ingresar es true osea si la cantidad no es negativa
                            System.out.println("\n[*] Operación realizada correctamente.");
                        }else{
                            System.out.println("\n[*] Operación fallida. Porfavor, inténtelo de nuevo.");
                        }
                    }catch(NumberFormatException e){ // Excepcion para cuando el input no es un valor entero
                        System.out.println("\n[*] Formato incorrecto.");
                    }
                    break;
                case 3: // Sistema de reintegros
                    System.out.print("\n[-] Introduzca la cantidad que desea retirar: ");
                    try{
                        if(cuentaOrigen.retirar(Integer.parseInt(leer.nextLine())) == true){ // Si el valor devuelto por el metodo ingresar es true osea si la cantidad no es negativa y si hay saldo
                            System.out.println("\n[*] Operación realizada correctamente.");
                        }else{
                            System.out.println("\n[*] Operación fallida. Porfavor, inténtelo de nuevo.");
                        }
                    }catch(NumberFormatException e){ // Excepcion para cuando el input no es un valor entero
                        System.out.println("\n[*] Formato incorrecto.");
                    }
                    break;
                case 4: // Sistema de transferencias
                    System.out.print("\n[-] Introduzca la cantidad que desea transferir: ");
                    try{
                        if(cuentaOrigen.transferencia(cuentaDestino, Double.parseDouble(leer.nextLine())) == true){ // Si el valor devuelto por el metodo transferencia es true osea si hay saldo
                                System.out.println("\n[*] Operación realizada correctamente.");
                                System.out.println(cuentaDestino.getSaldo()); // D E B U G
                        }else{
                            System.out.println("\n[*] Operación fallida. Porfavor, inténtelo de nuevo.");
                        }
                    }catch(NumberFormatException e){ // Excepcion para cuando el input no es un valor entero
                        System.out.println("\n[*] Formato incorrecto.");
                    }
                    break;
                default: System.out.println("\n[*] Formato incorrecto."); break; // Excepcion para cuando el input no es un valor entero
            }
        }while(opcion != 0);
    }
   
}