/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.print.Collation;

/**
 *
 * @author alex
 */
public class FiguraDoblePar implements FiguraMano, Comparable<FiguraMano>{
        private List<Carta> cartas = new ArrayList();
    private List<Carta> figuraCartas = new ArrayList();
    

    public FiguraDoblePar() {
    }

    
     public FiguraDoblePar(List<Carta> lista) {
         this.cartas = lista;
         
           for (int i=0; i<lista.size();i++)
        {
            
            for (int z=i+1; z<lista.size(); z++)
            {
                if (lista.get(i).getNumero()==lista.get(z).getNumero())
            {
                figuraCartas.add(lista.get(i));
                figuraCartas.add(lista.get(z));
                
            }
            }
            
        }
      Collections.sort(this.figuraCartas, Collections.reverseOrder());     
         
    }
    
    
   

    @Override
    public FiguraMano obtenerFigura(List<Carta> cartas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getValor() {
        return 2;
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
    public List<Carta> obtenerListaCartas() {
        return this.cartas;
    }

    @Override
    public List<Carta> obtenerListaCartasFormandoFigura() {
       return this.figuraCartas;
    }
    
     @Override
    public String toString() {
        return "Doble Par";
    }
    
}
