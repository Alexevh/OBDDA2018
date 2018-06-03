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
public class FiguraColor implements FiguraMano{

    
     private List<Carta> cartas = new ArrayList();
    private List<Carta> figuraCartas = new ArrayList();

   public FiguraColor(List<Carta> lista) {
        
        this.cartas = lista;
        this.figuraCartas = lista;
        Collections.sort(lista, Collections.reverseOrder());
    }
    
    
    @Override
    public FiguraMano obtenerFigura(List<Carta> cartas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carta> obtenerListaCartas() {
        return this.cartas;
    }

    @Override
    public List<Carta> obtenerListaCartasFormandoFigura() {
        return this.figuraCartas;
    }

    @Override
    public int getValor() {
        return 3;
    }

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

    @Override
    public String toString() {
        return "Color";
    }
    
    
    
}
