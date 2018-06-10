/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Juego;
import modelo.Jugador;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class Persistencia {
    
    private static Persistencia instancia = new Persistencia();
    private BaseDatos base;

    public static Persistencia getInstancia() {
        return instancia;
    }
   
    private Persistencia() {
        base = BaseDatos.getInstancia();
        base.conectar("pokerGame", "root", "root");
    }
    private int proximoOid(){
        int oid = -1;
        ResultSet rs = base.consultar("SELECT valor from oid");
        try {
            if(rs.next()){ //hay un registro
                oid = rs.getInt("valor");
                base.modificar("UPDATE oid set valor = " + (oid+1));
            }
            else{
                System.out.println("DEBE INICIALIZAR EL oid");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener oid:"+ ex.getMessage());
        }
        return oid;
    }
    public void guardar(Mapeador p){
        if(p.getOid()==0){
            insertar(p);
        }else modificar(p);
    }

    private void insertar(Mapeador p) {
        int oid = proximoOid();
        p.setOid(oid);
        ArrayList<String> sqls = p.getSqlInsertar();
        if(!base.transaccion(sqls)){
            System.out.println("NO SE PUDO INSERTAR EL OBJETO");
            p.setOid(0);
        }
    }

    private void modificar(Mapeador p) {
        
        ArrayList<String> sqls = p.getSqlModificar();
        if(!base.transaccion(sqls)){
            System.out.println("ERROR AL ACTUALIZAR EL OBJETO");
        }

    }
    public void borrar(Mapeador p){
        if(p.getOid()==0) return;
        ArrayList<String> sqls = p.getSqlBorrar();
        if(!base.transaccion(sqls)){
            System.out.println("ERROR AL BORRAR EL OBJETO");
        }else{
            p.setOid(0);
        }
    }
    public ArrayList<Jugador> todos(Mapeador map){
        return buscar(map,null);
    }
    
     public ArrayList<Juego> todosJuegos(Mapeador map){
        return buscar(map,null);
    }
    
    public ArrayList buscar(Mapeador map,String filtro){
        ArrayList lista = new ArrayList();
        String sql = map.getSqlSelect();//
        if(filtro!=null) sql+= " WHERE " + filtro;
        ResultSet rs = base.consultar(sql);
        try {
            //ASUMO ORDEN POR OID
            int oidAnt=-1;
            int oidActual;
            while(rs.next()){
               oidActual = rs.getInt("oid"); //EL CAMPO DEBE LLAMARSE ASI
               if(oidActual!=oidAnt){
                    map.crearNuevo();
                    map.setOid(oidActual); 
                    oidAnt = oidActual;
                    lista.add(map.getObjeto());
                    map.leerCompuesto(rs); //cabezal
               }
               map.leerComponente(rs);//linea
               
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar:" + ex);
            return null;
        }
        return lista;
    }
    
    
}
