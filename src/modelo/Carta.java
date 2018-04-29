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
public class Carta {
 
   public enum Palo {CORAZON, DIAMANTE, TREBOL, PIQUE}
   
   private Palo palo;
   private int numero;

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Carta(Palo palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }
    
   
    
    private int obtenerValorPalo(Palo p)
    {
        
      switch (p){
          
          case CORAZON:
              return 4;
          case DIAMANTE:
              return 3;
          case PIQUE:
              return 2;
          case TREBOL:
              return 1;
                  
      }
         return 0;     
              
    }

}
