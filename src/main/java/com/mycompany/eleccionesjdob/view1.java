/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eleccionesjdob;


import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import pojo.Candidato;

/**
 *
 * @author juan
 */
@ManagedBean(name="vista1")
@ApplicationScoped
public class view1 {
    private Candidato c = new Candidato();
    private ArrayList<Candidato> candi = new ArrayList<>();
    private Part foto;
     /**
     * Creates a new instance of view1
     */
    public view1() {
        
    }
    
    
    public void agregarCandidato(Candidato canddto){
            
            String partido = canddto.getPartido();
            String nombre = canddto.getNombre();
            int votos = c.getVotos();
            String imagen = view1.getImage(foto);
            Date fecha = canddto.getFecha();
         
        Candidato can = new Candidato(partido, nombre, votos, imagen, fecha);
        
        can.setPartido(partido);
        can.setNombre(nombre);
        can.setVotos(votos);
        can.setUrl_foto(imagen);
        can.setFecha(fecha);
        this.candi.add(can);
        
        
    }
    
    public void enviar(){
        FacesContext context = FacesContext.getCurrentInstance();
        view2 vistaB = context.getApplication().evaluateExpressionGet(context, "#{vista2}", view2.class);
        vistaB.setCandidato(candi);
        
    }
   

    public Candidato getC() {
        return c;
    }

    public void setC(Candidato c) {
        this.c = c;
    }

    public ArrayList<Candidato> getCandi() {
        return candi;
    }

    public void setCandi(ArrayList<Candidato> candi) {
        this.candi = candi;
    }

   
     public static String getImage(Part part){
        for(String cd : part.getHeader("content-disposition").split(";")){
            if(cd.trim().startsWith("filename")){
                String filename = cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('=')+1).substring(filename.lastIndexOf('\\')+1);
            }
        }
        return null;
    }

    public Part getFoto() {
        return foto;
    }

    public void setFoto(Part foto) {
        this.foto = foto;
    }
    
     
    
    
}
