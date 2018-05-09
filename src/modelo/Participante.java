/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author alex
 */
public class Participante {
    
    private boolean activo;
    private List<Carta> cartasMano;
    private Jugador jugador;

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Carta> getCartasMano() {
        return cartasMano;
    }

    public void setCartasMano(List<Carta> cartasMano) {
        this.cartasMano = cartasMano;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
   

    @Override
    public boolean equals(Object object)
    {
        boolean mismo = false;

        if (object != null && object instanceof Participante)
        {
            mismo = this.getJugador().getNombreUsuario().equals(((Participante) object).jugador.getNombreUsuario());
        }

        return mismo;
    }
    
    @Override
    public String toString(){
        return this.jugador.getNombreCompleto();
    }
    
}
