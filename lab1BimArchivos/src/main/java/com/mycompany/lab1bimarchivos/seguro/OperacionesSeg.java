/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab1bimarchivos.seguro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author win
 */
public class OperacionesSeg {
      private List <seguro> listaSeguro;

    public OperacionesSeg() {
        listaSeguro=new ArrayList<>();
    }
    
    Scanner leer=new Scanner(System.in);
    
    public void registrar (seguro seg){
         if(seg instanceof SeguroVida){
            SeguroVida segV=new  SeguroVida();
            segV.registrar();
            listaSeguro.add(segV);
            System.out.println("Seguro de Vida Registrado");
        }
        if( seg instanceof SeguroAccidentes){
            SeguroAccidentes segA=new  SeguroAccidentes();
            segA.registrar();
            listaSeguro.add(segA);
            System.out.println("Seguro de accidentes  Registrado");
        }
    }
    
    public void mostrarSegVida(){
        int sw=0,sw1=0;
        if(listaSeguro.size()>0){
            sw=1;
             for(seguro seg:listaSeguro){
                if(seg instanceof SeguroVida){
                    SeguroVida segV=  (SeguroVida) seg;
                    System.out.println("=====Seguro De Vida=====");
                    segV.mostrar();
                    sw1=1;
                }
//                else if(sw==0){
//                    System.out.println("No existe Nigun Seguro d vida Registrado");
//                }
            }
        }else if(sw==0){
            System.out.println("No existe Nigun Seguro Registrado"); 
        }
        
    }
    
     public void mostrarSegAcc(){
         int sw=0;
        if(listaSeguro.size()>0){
             for(seguro seg:listaSeguro){
                if(seg instanceof SeguroAccidentes){
                    SeguroAccidentes segA=  (SeguroAccidentes) seg;
                    System.out.println("=====Seguro De Accientes=====");
                    segA.mostrar();
                }
//                else{
//                    System.out.println("No existe Nigun Seguro de Accidentes Registrado");
//                }
            }
              
        }else if(sw==0){
            System.out.println("No existe Nigun Seguro Registrado"); 
        }
        
    }
     
     public void cuotMensual(){
         int sw=0,sw2=0;
         if(listaSeguro.size()>0){
             sw2=1;
             System.out.println("Ingrese su nombre completo");
             String nom=leer.nextLine();             
             for(seguro seg:listaSeguro){
                if(seg instanceof SeguroVida){
                    SeguroVida segV=  (SeguroVida) seg;
                    if(segV.getNombreAsegurado().equalsIgnoreCase(nom)){
                        
                        System.out.println("=====Seguro De Accientes=====");
                        segV.mostrar();
                        segV.cuotaMensual();
                         sw=1;
                    }else if(sw==0){
                        System.out.println("Seguro No encontrado");
                    }
                   
                }
//                else if(sw==0){
//                    System.out.println("No existe Nigun Seguro de Accidentes Registrado");
//                }
            }      
        }else if(sw2==0){
            System.out.println("No existe Nigun Seguro Registrado"); 
        }
         
     }
    public void Fechfinal(){
           int sw=0,sw2=0;
         if(listaSeguro.size()>0){
             sw2=1;
             System.out.println("Ingrese su nombre completo");
             String nom=leer.nextLine();   
             for(seguro seg:listaSeguro){
                if(seg instanceof SeguroAccidentes){
                    SeguroAccidentes segA=  (SeguroAccidentes) seg;
                    if(segA.getNombreAsegurado().equalsIgnoreCase(nom)){
                         System.out.println("=====Seguro De Accientes=====");
                         segA.mostrar(); 
                         segA.fechaFinal();
                         sw=1;

                    }else if(sw==0){
                        System.out.println("Seguro no encontado");
                    }       
                }
//                else if(sw==0){
//                    System.out.println("No existe Nigun Seguro de Accidentes Registrado");
//                }
            }
               
        }else if(sw2==0){
            System.out.println("No existe Nigun Seguro Registrado");
        }
    }
    ///CREAR ARCHIVO
     public void crearArchivo(){
         
        Path path=Paths.get("E:\\programacionIII\\archivoSeguro.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="E:\\programacionIII\\archivoSeguro.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaSeguro);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesSeg.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesSeg.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerClientes(){
        String ruta="E:\\programacionIII\\archivoSeguro.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaSeguro=(List<seguro>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesSeg.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesSeg.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesSeg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
}
