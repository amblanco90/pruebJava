/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Intefaces.UsuarioInterface;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AM BLANCO
 */
public class UsuarioDAO implements UsuarioInterface {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario p = new Usuario();

    @Override
    public Usuario list(String documento, String pass) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario us = new Usuario();
        try {
            String consulta = "select * from usuario where Documento = ? and Contraseña = ?";
            pst = cn.getConexion().prepareStatement(consulta);
            pst.setString(1, documento);
            pst.setString(2, pass);
            rs = pst.executeQuery();

            rs = pst.executeQuery();

            if (rs.next()) {
                us.setDocumento(Integer.parseInt(rs.getString("Documento")));
                us.setContraseña(rs.getString("Contraseña"));
                us.setNombre(rs.getString("Nombre"));
                us.setRol(rs.getString("Rol"));

            }

        } catch (Exception e) {

            System.out.print("ERROR" + e);

        }
        return us;
    }

    @Override
    public boolean add(Usuario per) {
        PreparedStatement pst = null;
        try {
            String consulta = "insert into usuario "
                    + "(Nombre, Contraseña, Documento, Rol) values (?,?,?,?)";
            pst = cn.getConexion().prepareStatement(consulta);
            pst.setString(1, per.getNombre());
            pst.setString(2, per.getContraseña());
            pst.setInt(3, per.getDocumento());
            pst.setString(4, per.getRol());

            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {

            System.out.print("ERROR" + e);

        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List list() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from Usuario";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();

                us.setDocumento(rs.getInt("Documento"));
                us.setRol(rs.getString("Rol"));
                us.setNombre(rs.getString("Nombre"));
                us.setContraseña(rs.getString("Contraseña"));

                list.add(us);

            }
        } catch (Exception e) {

            System.out.println(e);
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }

}
