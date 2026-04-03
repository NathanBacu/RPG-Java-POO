/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videojuego;

/**
 *
 * @author irlorth
 */
public class Paladin extends Personaje{
    
    private int buffDaño = 0;
    private int contBuff = 0;

    public Paladin(String nombre) {
        super(nombre);
    }

    /**
     * Comprueba y actualiza la vida restante, si es 0 o menos, envia un true conforme el personaje ha muerto
     * @param dañoRecibido
     * @return 
     */
    @Override
    public boolean recibirDaño(int dañoRecibido) {
        if(dañoRecibido >= this.getVidaRestante()){
            return true;
        }
        else {
            this.setVidaRestante(this.getVidaRestante() - dañoRecibido);
            return false;
        }
    }

    /**
     * Devuelve un String con los datos del personaje: nombre, mana restante y vida restante
     * @return 
     */
    @Override
    public String mostrarEstado() {
        String mensaje = "Paladin: Buff DMG nivel " + this.contBuff + " (+10 por nivel), " + this.getNombre() + " HP: " + this.getVidaRestante() + "/" + this.getVIDA_MAX();
        return mensaje;
    }
    
    /**
     * Envia un String con la lista de ataques diponibles de este personaje
     * @return 
     */
    @Override
    public String setMovimientos() {
        String mensaje = "\n1.Ataque Cuerpo a Cuerpo\n2.Subir Ataque en 10 Puntos\n3.Curacion";
        return mensaje;
    }
    
    
    //Aqui estan los metodos de los 3 ataques diponibles que tiene la clase de Barbaro
    /**
     * Ataque basico normal que tienen todos los personajes, es el daño base añadiendo la variable del personaje
     * @return 
     */
    @Override
    public int ataque1() {
        
        int dañoGenerado = this.getDañoBase() + this.buffDaño;
         
        return dañoGenerado;
    } 
    
    /**
     * Sube su daño en 10 puntos permanentemente
     * @return 
     */
    @Override
    public int ataque2(){
        
        this.buffDaño += 10;
        ++this.contBuff;
        return 0;
    }
    
    /**
     * Cura la vida hasta un maximo de 200 (Vida max)
     * @return 
     */
    @Override
    public int ataque3(){
        
        int curacion = 20;
        
        if (this.getVidaRestante() + curacion > this.getVIDA_MAX()){
            this.setVidaRestante(this.getVIDA_MAX());
        }
        else {
            this.setVidaRestante(getVidaRestante() + curacion);
        }
        
        return 0;
    }
    
    
}
