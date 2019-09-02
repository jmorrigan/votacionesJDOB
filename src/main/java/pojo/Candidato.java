/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author juan
 */
public class Candidato {
    private String partido;
    private String nombre;
    private int votos = 1;
    private String url_foto;
    private Date fecha;
    

    public Candidato() {
    }

    public Candidato(String partido, String nombre, int votos, String url_foto, Date fecha) {
        this.partido = partido;
        this.nombre = nombre;
        this.votos = votos;
        this.url_foto = url_foto;
        this.fecha = fecha;
        
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
