/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videojuego;

/**
 *
 * @author irlorth
 */
public class Mago extends Personaje{
    
    private int mana = 100;

    public Mago(String nombre) {
        super(nombre);
        this.mana = mana;
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
        String mensaje = "Mago: Mana restante = " + this.mana + ", " + this.getNombre() + " HP: " + this.getVidaRestante() + "/" + this.getVIDA_MAX();
        return mensaje;
    }

    /**
     * Envia un String con la lista de ataques diponibles de este personaje
     * @return 
     */
    @Override
    public String setMovimientos() {
        String mensaje = "\n1.Ataque Cuerpo a Cuerpo\n2.Ataque a distancia (Coste: 20 Mana)\n3.Curacion";
        return mensaje;
    }
    
    
    //Aqui estan los metodos de los 3 ataques diponibles que tiene la clase de Mago
    /**
     * Ataque basico normal que tienen todos los personajes, es el daño base añadiendo la variable del personaje
     * @return 
     */
    @Override
    public int ataque1() {
        
        int dañoGenerado = this.getDañoBase()/2;
         
        return dañoGenerado;
    } 
    
    /**
     * Ataque a distancia que pega 40 de daño, pero gasta 20 de mana
     * @return 
     */
    @Override
    public int ataque2(){
        
        int dañoGenerado = 0;
        
        if(mana >= this.mana){
            dañoGenerado = this.getDañoBase()*2;
            this.mana -= 20;
        }
        
        return dañoGenerado;
    }
    
    /**
     * Cura 25 de vida, hasta un maximo de 200 (vida maxima)
     * @return 
     */
    @Override
    public int ataque3(){
        
        int curacion = 25;
        
        if (this.getVidaRestante() + curacion > this.getVIDA_MAX()){
            this.setVidaRestante(this.getVIDA_MAX());
        }
        else {
            this.setVidaRestante(getVidaRestante() + curacion);
        }
        return 0;
    }
    
}
