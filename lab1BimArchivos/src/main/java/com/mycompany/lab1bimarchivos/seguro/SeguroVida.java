/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab1bimarchivos.seguro;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class SeguroVida extends seguro implements Serializable{
    
    static final long serialVersionUID=42L;
    
    private String fechaFinal;
    private String NombreBeneficiario;
    private int costoSeguro;
    
   
    
    @Override
    public void registrar(){
        super.registrar();
         Scanner leer=new Scanner(System.in);
        System.out.println("Ingrese la fecha final DD/MM/AAAA");
        this.fechaFinal=leer.nextLine();
        System.out.println("Ingrese el nombre del Beneficiario");
        this.NombreBeneficiario=leer.nextLine();
        System.out.println("Ingrese el costo del Seguro");
        this.costoSeguro=leer.nextInt();
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Fecha Final: "+this.fechaFinal);
        System.out.println("Nombre del Beneficiario "+this.NombreBeneficiario);
        System.out.println("Costo Seguro "+this.costoSeguro);
    }
    
    public void cuotaMensual(){
         //definiendo eñ formtao de fecha de ingreso
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //parsendo la fecha de ingreso que esta en string
        LocalDate fechaIncial=LocalDate.parse(super.getFechainicio(), format);
        LocalDate fechaFinal=LocalDate.parse(this.fechaFinal, format);
        
        long tM=ChronoUnit.MONTHS.between(fechaIncial, fechaFinal);
        double t = (int)tM;
        double año=t/12;
        double costoMensual=this.costoSeguro/t;
        System.out.println("------La cuota mensual es---------");
        System.out.println(costoMensual);
        System.out.println("tiempo es de "+año+" años");
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getNombreBeneficiario() {
        return NombreBeneficiario;
    }

    public void setNombreBeneficiario(String NombreBeneficiario) {
        this.NombreBeneficiario = NombreBeneficiario;
    }

    public int getCostoSeguro() {
        return costoSeguro;
    }

    public void setCostoSeguro(int costoSeguro) {
        this.costoSeguro = costoSeguro;
    }
}
