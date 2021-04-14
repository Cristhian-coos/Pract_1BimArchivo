/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab1bimarchivos.seguro;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class seguro implements Serializable {
    static final long serialVersionUID=41L;
    private String nombreAsegurado;
    private String montoAsegurado;
    private String fechainicio;
    
    
    public void registrar(){
        Scanner leer=new Scanner(System.in);
        System.out.println("Ingrese  Nombre Completo");
        this.nombreAsegurado=leer.nextLine();
        System.out.println("ingrese El monto del Asegurado");
        this.montoAsegurado=leer.nextLine();
        System.out.println("ingrese la fecha de Inicio DD/MM/AAAA");
        this.fechainicio=leer.nextLine();
    }
    public void mostrar(){
        System.out.println("Nombre: "+this.nombreAsegurado);
        System.out.println("Monto de Asegurado. "+this.montoAsegurado);
        System.out.println("Feacha de Inincio: "+this.fechainicio);
    }

    public String getNombreAsegurado() {
        return nombreAsegurado;
    }

    public void setNombreAsegurado(String nombreAsegurado) {
        this.nombreAsegurado = nombreAsegurado;
    }

    public String getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(String montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }
}
