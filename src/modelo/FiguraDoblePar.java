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
public class FiguraDoblePar extends FiguraMano implements Comparable<FiguraMano>{


    public FiguraDoblePar() {
    }

    
     public FiguraDoblePar(List<Carta> lista) {
          super.setCartas(lista);
         
           for (int i=0; i<lista.size();i++)
        {
            
            for (int z=i+1; z<lista.size(); z++)
            {
                if (lista.get(i).getNumero()==lista.get(z).getNumero())
            {
                super.getFiguraCartas().add(lista.get(i));
                super.getFiguraCartas().add(lista.get(z));
                
            }
            }
            
        }
           Collections.sort(super.getFiguraCartas(), Collections.reverseOrder());   
            
        }
        
         
    
    
    
   

    

    @Override
    public int getValor() {
        return 2;
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

    @Override
    public List<Carta> obtenerListaCartas() {
        return this.cartas;
    }

    @Override
    public List<Carta> obtenerListaCartasFormandoFigura() {
       return this.figuraCartas;
    }
    */
    
     @Override
    public String toString() {
        return "Doble Par";
    }

    @Override
    public boolean tiene(List<Carta> lista) {
          
        boolean resultado = false;
        
        /* Esta lista deberia tener 2 elementos*/
        List<Carta> valorPar = new ArrayList();
        
       
        for (int i=0; i<lista.size();i++)
        {
            
            for (int z=i+1; z<lista.size(); z++)
            {
                if (lista.get(i).getNumero()==lista.get(z).getNumero())
            {
                valorPar.add(lista.get(i));
                valorPar.add(lista.get(z));
                
            }
            }
            
        }
          
        if (valorPar.size()==4)
        {
            resultado=true;
        }
        
        return resultado;
    }
    
}
