/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;


public abstract class FiguraMano {
    
    /*
    public FiguraMano obtenerFigura(List<Carta> cartas);
    
    public List<Carta> obtenerListaCartas();
    
    public List<Carta> obtenerListaCartasFormandoFigura();
    
    public int getValor();
    
    public int compareTo(FiguraMano f);
    
    public String toString();
    
*/
    private List<Carta> cartas = new ArrayList();
    private List<Carta> figuraCartas = new ArrayList();
    

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<Carta> getFiguraCartas() {
        return figuraCartas;
    }

    public void setFiguraCartas(List<Carta> figuraCartas) {
        this.figuraCartas = figuraCartas;
    }
    
    
    public abstract boolean tiene(List<Carta> figuraCartas);
    
    
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
    
    public int getValor() {
        return 1;
    }
    
      
    public List<Carta> obtenerListaCartas() {
        return this.cartas;
    }


    public List<Carta> obtenerListaCartasFormandoFigura() {
       return this.figuraCartas;
    }
    
        /*El juego si puede ir directo a la fachada y pedir que avise a sus observadores 
    public static FiguraMano obtenerFigura(List<Carta> lista) {
        FiguraMano figura = null;

        if (tienePar(lista)) {
            figura = new FiguraPar(lista);

        } else if (tieneDoblePar(lista)) {
            figura = new FiguraDoblePar(lista);
        } else if (tieneColor(lista)) {
            figura = new FiguraColor(lista);
        } else {
            figura = new FiguraVacia(lista);
        }

        return figura;
    }

    */
    
    
    /* Este metodo dada una lista de cartas se fija si tiene par unicamente */
    public static boolean tienePar(List<Carta> lista)
    {
        
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
          
        if (valorPar.size()==2)
        {
            resultado=true;
        }
        
        return resultado;
        
    }
   
     public static boolean tieneDoblePar(List<Carta> lista)
    {
        
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
    public static boolean tieneColor(List<Carta> lista)
    {
        boolean resultado = false;
        
        Carta.Palo palo = lista.get(0).getPalo();
        
        if (lista.get(1).getPalo()==palo && lista.get(2).getPalo()==palo && lista.get(3).getPalo()==palo && lista.get(4).getPalo()==palo)
        {
            resultado = true;
        }
        
        return resultado;
    }
    

    
    
}
