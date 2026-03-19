/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videojuego;

/**
 *
 * @author irlorth
 */
public class Barbaro extends Personaje{
    
    private boolean isFuria = false;
    private int turnosFuria = 0;

    public Barbaro(String nombre) {
        super(nombre);
    }


    /**
     * Comprueba y actualiza la vida restante, si es 0 o menos, envia un true conforme el personaje ha muerto
     * @param dañoRecibido
     * @return 
     */
    @Override
    public boolean recibirDaño(int dañoRecibido) {
        
        if(dañoRecibido >= vidaRestante){
            return true;
        }
        else {
            this.vidaRestante -= dañoRecibido;
            return false;
        }
    }

    /**
     * Devuelve un String con los datos del personaje: nombre, mana restante y vida restante
     * @return 
     */
    @Override
    public String mostrarEstado() {
        
        String mensaje = "Barbaro: Modo Furia = " + this.isFuria + " turnos restantes, " + this.nombre + " HP: " + this.vidaRestante + "/" + this.VIDA_MAX;
        return mensaje;
    }
    
    /**
     * Envia un String con la lista de ataques diponibles de este personaje
     * @return 
     */
    @Override
    public String setMovimientos() {
        
        String mensaje = "\n1.Ataque Cuerpo a Cuerpo\n2.Entrar en Furia\n3.Ataque Robo de Vida";
        return mensaje;
    }
    
    
    //Aqui estan los metodos de los 3 ataques diponibles que tiene la clase de Barbaro
    
    /**
     * Ataque basico normal que tienen todos los personajes, es el daño base añadiendo la variable del personaje
     * @return 
     */
    @Override
    public int ataque1() {
        
        int dañoGenerado = this.dañoBase;
        
        if (isFuria) {
          dañoGenerado *= 2;
          --this.turnosFuria;
        }
        
        if (this.turnosFuria == 0){
            this.isFuria = false;
        }
         
        return dañoGenerado;
    } 
    
    /**
     * Entra en furia, lo que hace que haga mas daño y se cure mas, solo dura 3 turnos
     * @return 
     */
    @Override
    public int ataque2(){
        
        this.isFuria = true;
        this.turnosFuria = 3;
        
        return 0;
    }
    
    /**
     * Ataque con Robo de Vida
     * @return 
     */
    @Override
    public int ataque3(){
        
        int dañoGenerado = this.dañoBase - 5;
        int curacion = 10;
        
        if(this.isFuria){
            dañoGenerado *= 2;
            curacion *= 2;
            --this.turnosFuria;
        }
        
        if (this.vidaRestante + curacion > this.VIDA_MAX){
            this.vidaRestante = 200;
        }
        else {
            this.vidaRestante += curacion;
        }
        
        //Comprobamos el contador de turnos, y si esta a 0 quitamos el modo furia
        if (this.turnosFuria == 0){
            this.isFuria = false;
        }
        
        return dañoGenerado;
    }
    
}
