/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author alex
 */
public class FiguraColor extends FiguraMano implements Comparable<FiguraMano>{

    
   

   public FiguraColor(List<Carta> lista) {
        
        super.setCartas(lista);
        super.setFiguraCartas(lista);
        Collections.sort(lista, Collections.reverseOrder());
    }
    
    
 

    @Override
    public int getValor() {
        return 3;
    }

    /*
   @Override
    public int compareTo(FiguraMano o) {
         if (this.getValor()==o.getValor())
        {
           if (this.figuraCartas.get(0).getNumero()>o.obtenerListaCartasFormandoFigura().get(0).getNumero())
           {
               return 1;
           } else if (this.figuraCartas.get(0).getNumero()==o.obtenerListaCartasFormandoFigura().get(0).getNumero())
           {
                return Integer.compare(this.cartas.get(0).obtenerValorPalo(this.cartas.get(0).getPalo()), o.obtenerListaCartas().get(0).obtenerValorPalo( o.obtenerListaCartas().get(0).getPalo()));
           }
           
           
           else
           {
               return 0;
           }
            
            
        } else {
            return Integer.compare(this.getValor(), o.getValor());
        }
    }
*/
    @Override
    public String toString() {
        return "Color";
    }

    @Override
    public String tiene(List<Carta> lista) {
          String resultado = "";
        
        Carta.Palo palo = lista.get(0).getPalo();
        
        if (lista.get(1).getPalo()==palo && lista.get(2).getPalo()==palo && lista.get(3).getPalo()==palo && lista.get(4).getPalo()==palo)
        {
            resultado = this.toString();
        }
        
        return resultado;
    }
    
    
    
}
