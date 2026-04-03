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
    
    private final int VIDA_MAX = 200;
    private int vidaRestante = 200;
    private String nombre;
    private int dañoBase = 20;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.dañoBase = dañoBase;
    }

    public int getVidaRestante() {
        return vidaRestante;
    }

    public void setVidaRestante(int vidaRestante) {
        this.vidaRestante = vidaRestante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDañoBase() {
        return dañoBase;
    }

    public void setDañoBase(int dañoBase) {
        this.dañoBase = dañoBase;
    }

    public int getVIDA_MAX() {
        return VIDA_MAX;
    }
    
    public abstract boolean recibirDaño(int dañoRecibido);
    public abstract String mostrarEstado();
    public abstract String setMovimientos();
    public abstract int ataque1();
    public abstract int ataque2();
    public abstract int ataque3();
}
