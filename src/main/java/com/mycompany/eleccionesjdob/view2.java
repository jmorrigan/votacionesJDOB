/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eleccionesjdob;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.PieChartModel;
import pojo.Candidato;

/**
 *
 * @author juan
 */
@ManagedBean(name="vista2")
@SessionScoped
public class view2 implements Serializable {

    private ArrayList<Candidato> candidato = new ArrayList<Candidato>();
    private ArrayList<Candidato> ganadorC = new ArrayList<Candidato>();
    private int contador = 0;
    private Candidato c = new Candidato();
    
    private PieChartModel livePieModel;
    
    private view3 vistaC = new view3();
    
    public view2() {
        
    }
    
    @PostConstruct
    public void init(){
        createPieModels();
    }
    
    public PieChartModel getLivePieModel() {
        for(Candidato c : candidato){
        livePieModel.getData().put(c.getNombre(), c.getVotos());
        }
        livePieModel.setTitle("Votes");
        livePieModel.setLegendPosition("ne");
        livePieModel.setShowDataLabels(true);
        return livePieModel;
    }
   
    public ArrayList<Candidato> getCandidato() {
        return candidato;
    }

    public void setCandidato(ArrayList<Candidato> candidato) {
        this.candidato = candidato;
    }

    private void createPieModels() {
        
        createLivePieModel();
    }
   
    public void refresh(){
        actualizar();
    }
    private void actualizar (){
        for(Candidato c : candidato){
        livePieModel.getData().put(c.getNombre(), c.getVotos());
        }
        livePieModel.setTitle("Votes");
        livePieModel.setLegendPosition("ne");
    }
    private void createLivePieModel() {
        livePieModel = new PieChartModel();
        
        for(Candidato c: candidato){
            livePieModel.set(c.getNombre(), c.getVotos());
        }
    }
    
    public void votos() {
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public void votar(RowEditEvent event){
        Candidato c = (Candidato)event.getObject();
        contador ++;
        c.setVotos(contador);
        System.out.println("votó");
        this.ganadorC.add(c);
    }
    
    public void cancelar(RowEditEvent event){
        
    }
    
    
    public void enviar(){
        FacesContext context = FacesContext.getCurrentInstance();
        view3 vista = context.getApplication().evaluateExpressionGet(context, "#{vista3}", view3.class);
        vista.setGanador(ganadorC);
    }

    public ArrayList<Candidato> getGanadorC() {
        return ganadorC;
    }

    public void setGanadorC(ArrayList<Candidato> ganadorC) {
        this.ganadorC = ganadorC;
    }

    public void imprimir(){
        for (Candidato c : ganadorC){
            System.out.println(c.getPartido() + "  " + c.getNombre() + " " + c.getVotos());
        }
    }
    public Candidato getC() {
        return c;
    }

    public void setC(Candidato c) {
        this.c = c;
    }

    public view3 getVistaC() {
        return vistaC;
    }

    public void setVistaC(view3 vistaC) {
        this.vistaC = vistaC;
    }
       
    
    
}
