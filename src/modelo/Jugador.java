/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alex
 */
public class Jugador extends Usuario{
    
    private int saldo;

    private int oid;

    public Jugador() {
        
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
    
    
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Jugador(String nombreCompleto, String login, String password, int saldo) {
        this.saldo = saldo;
        super.setNombreCompleto(nombreCompleto);
        super.setNombreUsuario(login);
        super.setPassword(password);
        
    }
    
    public void sumarAlSaldo(int valor)
    {
        this.saldo = this.saldo+valor;
    }
    
     public void restarAlSaldo(int valor)
    {
        this.saldo = this.saldo-valor;
    }
    
    
    
}
