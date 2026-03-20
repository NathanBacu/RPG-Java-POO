/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.videojuego;

import static com.mycompany.videojuego.Batalla.iniciarPelea;
import java.util.Scanner;

/**
 *
 * @author irlorth
 */
public class VideoJuego {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Personaje j1;
        Personaje j2;
        
        int numPersonajeJ1 = 0;
        int numPersonajeJ2 = 0;
       
        String nombreJ1;
        String nombreJ2;
        
        boolean numCorrecto = true;
        
        int eleccion = 0;
        boolean eleccionCorrecta = true;   
        
        //Abrimos un  primer bucle para volver a iniciar otra partida o salir del juego
        do {


            //Preguntamos al jugador 1 y 2 que personaje quieren entre los 3 que hay y que nombre quiere ponerle
            do{
                System.out.println("Jugador 1, que personaje quieres elegir? \n1.Mago \n2.Barbaro \n3.Paladin");

                try {
                    numPersonajeJ1 = sc.nextInt();


                    numCorrecto = (numPersonajeJ1 >= 1 && numPersonajeJ1 <= 3);

                    if(!numCorrecto) System.out.println("El numero solo puede ser 1, 2 o 3");

                }catch(Exception e){
                    System.out.println("Tiene que ser un numero entero");
                    sc.next();
                    numCorrecto = false;
                }

            }while(!numCorrecto);

            //Limpiamos el Scanner para que no salte en el siguiente
            sc.nextLine();

            System.out.println("Que nombre le quieres poner a tu personaje?");
            nombreJ1 = sc.nextLine();

            //Una vez comprobado que todo esta bien en el J1, hacemos lo mismo para el J2
            do{
                System.out.println("Jugador 2, que personaje quieres elegir? \n1.Mago \n2.Barbaro \n3.Paladin");

                try {
                    numPersonajeJ2 = sc.nextInt();

                    numCorrecto = (numPersonajeJ2 >= 1 && numPersonajeJ2 <= 3);

                    if(!numCorrecto) System.out.println("El numero solo puede ser 1, 2 o 3");

                }catch(Exception e){
                    System.out.println("Tiene que ser un numero entero");
                    sc.next();
                    numCorrecto = false;
                }

            }while(!numCorrecto);
            //limpiamos el Scanner para que no salte en el siguiente
            sc.nextLine();

            System.out.println("Que nombre le quieres poner a tu personaje?");
            nombreJ2 = sc.nextLine();

            //Asignamos el personaje creado a cada uno de los jugadores
            switch (numPersonajeJ1) {
                case 1:
                    {
                        j1 = new Mago(nombreJ1);
                        break;
                    }
                case 2:
                    {
                        j1 = new Barbaro(nombreJ1);
                        break;
                    }
                default:
                    {
                        j1 = new Paladin(nombreJ1);
                        break;
                    }
            }

            switch (numPersonajeJ2) {
                case 1:
                    {
                        j2 = new Mago(nombreJ2);
                        break;
                    }
                case 2:
                    {
                        j2 = new Barbaro(nombreJ2);
                        break;
                    }
                default:
                    {
                        j2 = new Paladin(nombreJ2);
                        break;
                    }
            }

            //Entramos en la clase batalla y devuelve un numero segun el jugador que haya ganado
            int jugadorGanador = iniciarPelea(j1,j2);

            if (jugadorGanador == 1){
                System.out.println("El jugador 1 ha ganado!!!");
            }
            else {
                System.out.println("El jugador 2 ha ganado!!!");
            }
            
            do{
                eleccionCorrecta = true;
                
                try {
                    
                    System.out.println("Partida finalizada: \n1.Volver a jugar\n2.Salir");
                    eleccion = sc.nextInt();

                    if(eleccion != 1 && eleccion != 2) {
                        System.out.println("El numero solo puede ser 1 o 2");
                        eleccionCorrecta = false;
                    }

                }catch(Exception e){
                    System.out.println("Tiene que ser un numero entero");
                    sc.next();
                    eleccionCorrecta = false;
                }
                
            }while(!eleccionCorrecta);
            //Cerramos el bucle para elegir si salir del juego o volver a jugar
            

        } while(eleccion != 2);
    }
}
