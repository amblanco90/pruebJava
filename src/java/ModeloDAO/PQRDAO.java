
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD;
import Modelo.PQR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PQRDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    PQR p = new PQR();

    @Override
    public List listar() {
        ArrayList<PQR> list = new ArrayList<>();
        String sql = "select * from pqr";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PQR pqr = new PQR();

                pqr.setAsunto(rs.getString("Asunto"));
                pqr.setEstado(rs.getString("Estado"));
                pqr.setFechaCreacion(rs.getString("FechaCreacion"));
                pqr.setFechaLimite(rs.getString("FechaLimite"));
                pqr.setId(rs.getInt("id"));
                pqr.setIdUsuario(rs.getInt("idUsuario"));
                pqr.setTipo(rs.getString("Tipo"));
                System.out.println(pqr.getAsunto());
                list.add(pqr);

            }
        } catch (Exception e) {

            System.out.println(e);
        }
        return list;
    }

    @Override
    public PQR list(int id) {
        String sql = "select * from pqr where id=" + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                p.setAsunto(rs.getString("Asunto"));
                p.setEstado(rs.getString("Estado"));
                p.setFechaCreacion(rs.getString("FechaCreacion"));
                p.setFechaLimite(rs.getString("FechaLimite"));
                p.setId(rs.getInt("id"));
                p.setIdUsuario(rs.getInt("idUsuario"));
                p.setTipo(rs.getString("Tipo"));

            }
        } catch (Exception e) {
        }
        return p;
    }

    public boolean add(PQR per) {
        String sql = "insert into pqr(Asunto, Estado,FechaCreacion,FechaLimite,id,idUsuario,Tipo)"
                + "values('" + per.getAsunto() + "','" + per.getEstado() + "','" + per.getFechaCreacion()
                + "','" + per.getFechaLimite() + "','" + per.getId() + "','" + per.getIdUsuario() + "','" + per.getTipo() + "')";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
        return false;
    }

    public boolean edit(PQR per) {
        String sql = "update pqr set Asunto='" + per.getAsunto() + "',Estado='" + per.getEstado() + "'where Id=" + per.getId();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from pqr where Id=" + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public List listarPqrId(int id) {
        ArrayList<PQR> list = new ArrayList<>();
        String sql = "select * from pqr where  idUsuario=" + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PQR pqr = new PQR();

                pqr.setAsunto(rs.getString("Asunto"));
                pqr.setEstado(rs.getString("Estado"));
                pqr.setFechaCreacion(rs.getString("FechaCreacion"));
                pqr.setFechaLimite(rs.getString("FechaLimite"));
                pqr.setId(rs.getInt("id"));
                pqr.setIdUsuario(rs.getInt("idUsuario"));
                pqr.setTipo(rs.getString("Tipo"));
                System.out.println(pqr.getAsunto());
                list.add(pqr);

            }
        } catch (Exception e) {

            System.out.println(e);
        }
        return list;
    }

}
