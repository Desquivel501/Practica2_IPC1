/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Derek
 */
public class ActividadComida implements Serializable{
    private String nombreAlimento;
    private String nombrePokemon;
    private String vidaAgregada;

    public ActividadComida(String nombreAlimento, String nombrePokemon, String vidaAgregada) {
        this.nombreAlimento = nombreAlimento;
        this.nombrePokemon = nombrePokemon;
        this.vidaAgregada = vidaAgregada;
    }

    public String getVidaAgregada() {
        return vidaAgregada;
    }

    public void setVidaAgregada(String vidaAgregada) {
        this.vidaAgregada = vidaAgregada;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }
    
}
