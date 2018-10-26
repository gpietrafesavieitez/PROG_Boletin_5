package boletin_5_1;

public class Conta{
    private String nomeConta,numeroConta;
    private double saldoConta;
    
    //Constructor por defecto
    public Conta(){
    }
    
    //Constructor con parametros
    public Conta(String nomeConta, String numeroConta, double saldoConta){
        this.nomeConta = nomeConta;
        this.numeroConta = numeroConta;
        this.saldoConta = saldoConta;
    }
    
    //Setters
    public void setSaldo(double saldoConta){
        this.saldoConta = saldoConta;
    }
    
    public void setNumero(String numeroConta){
        this.numeroConta = numeroConta;
    }
    
    public void setNome(String nomeConta){
        this.nomeConta = nomeConta;
    }
    
    //Getters
    public double getSaldo(){
        return this.saldoConta;  
    }
    
    public String getNumero(){
        return this.numeroConta;
    }
    
    public String getNome(){
        return this.nomeConta;
    }
    
    //Métodos
    public boolean ingresar(double cantidade){
        if(cantidade < 0) {
            return false;
        }else{
            saldoConta += cantidade;
            return true;
        }
    }
    
    public boolean retirar(double cantidade){
        if(saldoConta - cantidade < 0){
            return false;
        }else {
            if(cantidade < 0){
                return false;
            }else {
                saldoConta -= cantidade;
                return true;
            }
        }
    }
    
    public void visualizar(){
        System.out.println("\n- Número de cuenta:\t" + numeroConta + ".\n- Nombre del cliente:\t" + nomeConta + ".\n- Saldo disponible:\t" + saldoConta + " euros.");
    }
    
    public void transferencia(String cuentaDestino, double importe){
        this.saldoConta -= importe;
        cuentaDestino += importe; //????????
    }
    
}
