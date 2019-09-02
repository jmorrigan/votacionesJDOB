/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eleccionesjdob;


import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import pojo.Candidato;

/**
 *
 * @author juan
 */
@ManagedBean(name = "vista3")
@SessionScoped
public class view3 implements Serializable {
    
    private ArrayList<Candidato> ganador = new ArrayList<Candidato>();
    /**
     * Creates a new instance of view3
     */
    public view3() {
    }

    public ArrayList<Candidato> getGanador() {
        return ganador;
    }

    public void setGanador(ArrayList<Candidato> ganador) {
        this.ganador = ganador;
    }

    public void insertar(Candidato c){
        this.ganador.add(c);
    }
    
    public void imprimir(){
        for (Candidato c : ganador){
            System.out.println(c.getPartido() + "  " + c.getNombre());
        }
    }
    
}
