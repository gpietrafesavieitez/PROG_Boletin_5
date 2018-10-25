package boletin_5_1;

public class Boletin_5_1 {

    public static void main(String[] args) {
        Conta miCuenta = new Conta("Gabirel","0000",9);
        miCuenta.visualizar();
        
        miCuenta.setSaldo(999);
        miCuenta.setNumero("1234");
        miCuenta.setNome("Gabriel");
        System.out.println(miCuenta.getNumero() + miCuenta.getNome() + miCuenta.getSaldo() + "\n");
        
        miCuenta.ingresar(1);
        miCuenta.visualizar();
        
        miCuenta.reintegrar(999);
        miCuenta.visualizar();
        
        miCuenta.reintegrar(2);
        miCuenta.visualizar();


    }
    
}
