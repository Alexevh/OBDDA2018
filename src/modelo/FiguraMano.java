/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;


public interface FiguraMano {
    
    public FiguraMano obtenerFigura(List<Carta> cartas);
    
    public List<Carta> obtenerListaCartas();
    
    public List<Carta> obtenerListaCartasFormandoFigura();
    
    public int getValor();
    
    public int compareTo(FiguraMano f);
    
    public String toString();
    

    
    
}
