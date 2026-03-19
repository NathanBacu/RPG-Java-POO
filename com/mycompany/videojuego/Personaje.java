/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videojuego;

/**
 *
 * @author irlorth
 */
public abstract class Personaje {
    
    protected final int VIDA_MAX = 200;
    protected int vidaRestante = 200;
    protected String nombre;
    protected int dañoBase = 20;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.dañoBase = dañoBase;
    }
    
    
    public abstract boolean recibirDaño(int dañoRecibido);
    public abstract String mostrarEstado();
    public abstract String setMovimientos();
    public abstract int ataque1();
    public abstract int ataque2();
    public abstract int ataque3();
}
