/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab1bimarchivos.seguro;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author win
 */
public class SeguroAccidentes extends seguro implements Serializable{
    static final long serialVersionUID=43L;
    private double pagoSeguro;
    
    
    @Override
    public void registrar(){
        super.registrar();
        Scanner leer=new Scanner(System.in);
        System.out.println("Ingrese Pago de Seguro");
        this.pagoSeguro=leer.nextDouble();
        
    }
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Pago Seguro: "+this.pagoSeguro);
    }

    public void fechaFinal(){
          //definiendo eñ formtao de fecha de ingreso
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //parsendo la fecha de ingreso que esta en string
        LocalDate fechaIncial=LocalDate.parse(super.getFechainicio(), format);
        LocalDate fechafinal=fechaIncial.plusYears(1);
        
        String fechafin=fechafinal.format(format);
        System.out.println("-----La fecha finnal es:-------");
        System.out.println(fechafin);
        
    }
    
    public double getPagoSeguro() {
        return pagoSeguro;
    }

    public void setPagoSeguro(double pagoSeguro) {
        this.pagoSeguro = pagoSeguro;
    }
    
}
