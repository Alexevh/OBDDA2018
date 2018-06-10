/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Jugador;
import persistencia.Mapeador;

/**
 *
 * @author alex
 */
public class MapeadorJugador implements Mapeador {

    
    private Jugador j;

    public MapeadorJugador(Jugador j) {
        this.j = j;
    }

    public MapeadorJugador() {
        j= new Jugador();
    }

    public Jugador getJ() {
        return j;
    }

    public void setJ(Jugador j) {
        this.j = j;
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
        ArrayList<String> sqls = new ArrayList();
        sqls.add("INSERT INTO jugadores values (" + getOid() + ",'" +
                     j.getSaldo()+ "','" + j.getNombreCompleto()+ "','"+j.getNombreUsuario()+"','"+j.getPassword()+ "')");
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlModificar() {
         ArrayList<String> sqls = new ArrayList();
        sqls.add("UPDATE jugadores set nombrecompleto='" + j.getNombreCompleto() +
                     "',password='" + j.getPassword() +
                     "',saldo='" + j.getSaldo() +
                     "',usuario='" + j.getNombreUsuario()+
                     "' where oid=" + getOid());
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
         return "SELECT * FROM jugadores";
    }

    @Override
    public void crearNuevo() {
         j = new Jugador();
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        j.setNombreCompleto(rs.getString("nombrecompleto"));
        j.setPassword(rs.getString("password"));
        j.setNombreUsuario(rs.getString("usuario"));
        j.setSaldo(rs.getInt("saldo"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }

    @Override
    public Object getObjeto() {
        return j;
    }
    
}
