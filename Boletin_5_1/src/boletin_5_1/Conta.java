package boletin_5_1;

/**
 * Lógica del sistema de gestión de cuentas bancarias.
 * @author Gabriel P.
 * @version 1.0.0.
 * @since 2018.
 * @see <a href="https://www.danielcastelao.org">Moodle Daniel Castelao.</a>
 */
public class Conta{
    private String nomeConta,numeroConta;
    private double saldoConta;
    
    public Conta(){
    }
    
    public Conta(String nomeConta, String numeroConta, double saldoConta){
        this.nomeConta = nomeConta;
        this.numeroConta = numeroConta;
        this.saldoConta = saldoConta;
    }
    
    public void setSaldo(double saldoConta){
        this.saldoConta = saldoConta;
    }
    
    public void setNumero(String numeroConta){
        this.numeroConta = numeroConta;
    }
    
    public void setNome(String nomeConta){
        this.nomeConta = nomeConta;
    }
    
    public double getSaldo(){
        return this.saldoConta;  
    }
    
    public String getNumero(){
        return this.numeroConta;
    }
    
    public String getNome(){
        return this.nomeConta;
    }
    
    /**
     * Incrementa la cantidad de la cuenta en función del parámetro introducido siempre que éste sea positivo y distinto de 0.
     * @param cantidade Lo que se va a sumar a la cuenta.
     * @return Devuelve true o false en función de si la operación fue satisfactoria o no.
     */
    public boolean ingresar(double cantidade){
        if(cantidade > 0) {
            saldoConta += cantidade;
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Decrementa la cantidad de la cuenta en función del parámetro introducido siempre que éste sea positivo y haya saldo suficiente.
     * @param cantidade Lo que se va a restar a la cuenta.
     * @return Devuelve true o false en función de si la operación fue satisfactoria o no.
     */    
    public boolean retirar(double cantidade){
        if(cantidade > 0 && saldoConta - cantidade >= 0){
            saldoConta -= cantidade;
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * Muestra por pantalla los atributos de la cuenta actual.
     */
    @Override
    public String toString(){
        return "\n- Número de cuenta:\t" + numeroConta + ".\n- Nombre del cliente:\t" + nomeConta + ".\n- Saldo disponible:\t" + saldoConta + " euros.";
    }
    
    /**
     * Sistema de transferencias para pasar dinero de una cuenta a otra. 
     * Primero decrementa el saldo de la cuenta origen en función del parámetro importe siempre y cuando éste sea positivo y distinto de 0 y si hay saldo suficiente. Segundo incrementa el saldo de la cuenta destino mediante el setter correspondiente.
     * @param cuentaDestino Número de cuenta de quien recibirá el dinero.
     * @param importe Dinero a enviar.
     * @return Devuelve true o false en función de si la operación fue satisfactoria o no.
     */
    public boolean transferencia(Conta cuentaDestino, double importe){
        if(importe > 0 && saldoConta - importe >= 0){
            saldoConta -= importe; //this.saldoConta = this.SaldoConta - importe;
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + importe);
            return true;
        }else{
            return false;
        }
    }
    
}
