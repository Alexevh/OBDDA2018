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
public class Carta implements Comparable <Carta>{

    
    public enum Palo {
        CORAZON, DIAMANTE, TREBOL, PIQUE
    }

    private Palo palo;
    private int numero;
    private String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

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
        this.imagen = obtenerImagen();
    }

    public String obtenerImagen() {
        String img = "";
        /* El 11 es J, 12 es Q, 13 es K y 14 es A*/
        if (this.numero < 11) {
            img = this.numero + "" + obtenerCartaPalo(this.palo) + ".gif";
        } else if (this.numero == 11) {

            img = "J" + obtenerCartaPalo(palo) + ".gif";

        } else if (this.numero == 12) {
            img = "Q" + obtenerCartaPalo(palo) + ".gif";
        } else if (this.numero == 13) {
            img = "K" + obtenerCartaPalo(palo) + ".gif";
        } else {
            img="A"+obtenerCartaPalo(palo)+".gif";
        }

        return img;
    }

    public int obtenerValorPalo(Palo p) {

        switch (p) {

            case CORAZON:
                return 4;
            case DIAMANTE:
                return 3;
                case TREBOL:
                return 2;
            case PIQUE:
                return 1;

        }
        return 0;

    }

    private String obtenerCartaPalo(Palo p) {

        switch (p) {

            case CORAZON:
                return "c";
            case DIAMANTE:
                return "d";
            case PIQUE:
                return "p";
            case TREBOL:
                return "t";

        }
        return "";

    }

    @Override
    public boolean equals(Object object) {
        boolean mismo = false;

        if (object != null && object instanceof Carta) {
            if (this.getNumero() == ((Carta) object).getNumero() && this.getPalo() == ((Carta) object).getPalo()) {
                mismo = true;
            }
        }

        return mismo;
    }

    @Override
    public int compareTo(Carta o) {
        
        if (this.numero==o.numero)
        {
            return Integer.compare(this.obtenerValorPalo(palo), o.obtenerValorPalo(o.palo));
            
        } else {
            return Integer.compare(this.numero, o.numero);
        }
        
        
    }
    
    @Override
    public String toString()
    {
        return this.numero+""+this.obtenerCartaPalo(palo);
    }


}
