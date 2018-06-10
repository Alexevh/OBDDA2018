/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import Excepciones.PokerExcepciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Juego;
import modelo.Jugador;
import modelo.Participante;
import persistencia.Mapeador;




public class MapeadorJuego implements Mapeador{

    private Juego j;

    public Juego getJ() {
        return j;
    }

    public void setJ(Juego j) {
        this.j = j;
    }

    public MapeadorJuego(Juego j) {
        this.j = j;
    }

    public MapeadorJuego() {
    }
    
    
    
    
    
    @Override
    public int getOid() {
        return j.getOid();
    }

    @Override
    public void setOid(int oid) {
        j.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        
          ArrayList<String> sqls = new ArrayList();
        sqls.add("INSERT INTO partidas VALUES (" + getOid() + "," 
                                                + null + ","
                                                + "'"+formatter.format(j.getFechaInicio())+"'" 
                                                + "," +j.getCantidadJugadores()
                                                +"," +j.obtenerTotalApuestas()
                                                +","+j.getListaManos().size()+")");
        generarParticipantes(sqls);
        return sqls;
    }
    
      private void generarParticipantes(ArrayList<String> sqls) {
        
        int nro=1;
        for(Participante  p :j.getListaParticipantes()){
            
            sqls.add("INSERT INTO participantes VALUES (" + getOid() + ","
                                                  + nro + ",'"
                                                  + p.getJugador().getNombreCompleto() + "'," + p.getTotalApostado()
                                                  + "," + p.getSaldoInicial() + ","+ p.getTotalGanado()+")"
            );
            nro++;
        }
    }

    @Override
    public ArrayList<String> getSqlModificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
         return "SELECT * FROM partidas p, participantes j WHERE p.oid = j.oid ORDER BY p.oid,j.idParticipante";
    }

    @Override
    public void crearNuevo() {
        j = new Juego();
        j.setLuz(0);
        j.setCantidadJugadores(6);
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        
        j.setFechaInicio(rs.getDate("fecha"));
        j.setTotalApostadoPartida(rs.getInt("totalapostado"));
        j.setCantidadJugadoresTotal(rs.getInt("cantidadjugadores"));
        j.setCantidadManosJugadasFinal(rs.getInt("cantidadmanos"));
        
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        Participante p = new Participante();
        p.setSaldoInicial(rs.getInt("saldoinicial"));
        p.setTotalApostado(rs.getInt("totalapostado"));
        p.setTotalGanado(rs.getInt("totalganado"));
        
        /*Consultar si esta bien esto o debemos traernos el registro del jugador completo de la BD*/
        Jugador ju = new Jugador();
        ju.setNombreCompleto(rs.getString("nombrecompleto"));   
        ju.setSaldo(rs.getInt("saldoinicial"));
        p.setJugador(ju);
        
        try {
            j.agregarJugador(p);
        } catch (PokerExcepciones ex) {
            Logger.getLogger(MapeadorJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object getObjeto() {
        return j;
    }

  
    
    
}
