package Modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PQR {

    private int id;
    private String tipo;
    private String asunto;
    private String estado;
    private String fechaCreacion;
    private String fechaLimite;
    private int idUsuario;

    public PQR(Integer id) {
        this.id = id;
    }

    public PQR(Integer id, String tipo, String asunto, String estado, String fechaCreacion, String fechaLimite) {
        this.id = id;
        this.tipo = tipo;
        this.asunto = asunto;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
    }

    public PQR() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date sumarRestarDiasFecha(Date fecha, int dias) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fecha);

        calendar.add(Calendar.DAY_OF_YEAR, dias);

        return calendar.getTime();

    }

    public boolean vencimiento(String fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String fdate = formatter.format(date);
        if (fecha.equals(fdate)) {
            return true;
        }

        return false;
    }

}
