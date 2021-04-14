/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab1bimarchivos.seguro;

import java.util.Scanner;

/**
 *
 * @author win
 */
public class principalSeguro {
     public static void main(String[] args) {
        
        seguro segVida=new SeguroVida();
        seguro segAcc=new SeguroAccidentes();
        
        OperacionesSeg obj=new OperacionesSeg();
        
        Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        int opcion;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Craear Archivo");
            System.out.println("2. Registrar Seguro de Vida");
            System.out.println("3. Registrar Seguro de Accidentes");
            System.out.println();
            System.out.println("4. Mostrar Seguro de Vida");
            System.out.println("5. Mostrar Seguro de Accidentes");
            System.out.println();
            System.out.println("6. Cuota Mensual de Seguro de Vida");
            System.out.println("7. Fecha final de seguro de Accidentes ");
            System.out.println("8. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.registrar(segVida);
                   obj.guardarObjetos();
                    break;
                case 3:
                    obj.registrar(segAcc);
                    obj.guardarObjetos();
                    break;
                case 4:
                    obj.leerClientes();
                    obj.mostrarSegVida();
                    break;
                case 5:
                    obj.leerClientes();
                    obj.mostrarSegAcc();
                    break;
                case 6:
                    obj.leerClientes();
                    obj.cuotMensual();
                    obj.guardarObjetos();
                    break;
                case 7:
                    obj.leerClientes();
                    obj.Fechfinal();
                    obj.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            }

        } while (continuar);
    }
}
