/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videojuego;

import java.util.Scanner;

/**
 *
 * @author irlorth
 */
public class Batalla {
    
    public static void iniciarPelea(Personaje j1, Personaje j2){
        
        Scanner sc = new Scanner(System.in);
        
        int contadorTurnos = 1;
        int jugadorGanador = 0;
        
        int dañoGenerado;
        boolean estaMuerto = false;
        
        //Iniciamos un primer bucle con el que iran pasando las rondas, se rompe solo cuando alguien muere
        do {
            //Boolean para comprobar que el jugador no ponga algo que no és
            boolean todoOk;
            
            //Bucle del turno del jugador, se repite mientras ponga algo que no sea 1,2 o 3
            do {
                todoOk = true;
                System.out.println("J1. Turno " + contadorTurnos);
                System.out.println(j1.mostrarEstado());
                System.out.println(j1.setMovimientos());

                int eleccion = sc.nextInt();
                
                try {
                    todoOk = true;
                    if (eleccion == 1) {
                        dañoGenerado = j1.ataque1();
                        estaMuerto = j2.recibirDaño(dañoGenerado);
                    }
                    else if (eleccion == 2){
                        dañoGenerado = j1.ataque2();
                        estaMuerto = j2.recibirDaño(dañoGenerado);
                    }
                    else if (eleccion == 3){
                        dañoGenerado = j1.ataque3();
                        estaMuerto = j2.recibirDaño(dañoGenerado);
                    }
                    else {
                        System.out.println("Solo puedes escoger 1,2 y 3");
                        todoOk = false;
                    }
                }catch(Exception e){
                    System.out.println("Solo puede ser numero 1,2 y 3");
                }
                
            } while (!todoOk);
            
            //Comprobamos que el jugador 1 no haya matado al jugador 2, y en caso de hacerlo rompemos el bucle enseñando el mensaje de victoria
            if (estaMuerto){
                jugadorGanador = 1;
                break;
            }
            
            //Bucle del turno del jugador, se repite mientras ponga algo que no sea 1,2 o 3
            do {
                todoOk = true;
                System.out.println("J2. Turno " + contadorTurnos);
                System.out.println(j2.mostrarEstado());
                System.out.println(j2.setMovimientos());

                int eleccion = sc.nextInt();
                
                try {
                    if (eleccion == 1) {
                        dañoGenerado = j2.ataque1();
                        estaMuerto = j1.recibirDaño(dañoGenerado);
                    }
                    else if (eleccion == 2){
                        dañoGenerado = j2.ataque2();
                        estaMuerto = j1.recibirDaño(dañoGenerado);
                    }
                    else if (eleccion == 3){
                        dañoGenerado = j2.ataque3();
                        estaMuerto = j1.recibirDaño(dañoGenerado);
                    }
                    else {
                        System.out.println("Solo puedes escoger 1,2 y 3");
                        todoOk = false;
                    }
                }catch(Exception e){
                    System.out.println("Solo puede ser numero 1,2 y 3");
                }
                
                ++contadorTurnos;
            } while (!todoOk);
            
            //Comprobamos que el jugador 2 no haya matado al jugador 1, y en caso de hacerlo rompemos el bucle enseñando el mensaje de victoria
            if (estaMuerto){
                jugadorGanador = 2;
                break;
            }
            
        }while(true);
        
        
        if (jugadorGanador == 1){
            System.out.println("El jugador 1 ha ganado!!!");
        }
        else {
            System.out.println("El jugador 2 ha ganado!!!");
        }
        
    }
    
}
