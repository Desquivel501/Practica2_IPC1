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
public class ResultadoPelea implements Serializable{
    private String nombreGimnasio;
    private String nombrePokemon1;
    private String nombrePokemon2;
    private String ganador;

    public ResultadoPelea(String nombreGimnasio, String nombrePokemon1, String nombrePokemon2, String ganador) {
        this.nombreGimnasio = nombreGimnasio;
        this.nombrePokemon1 = nombrePokemon1;
        this.nombrePokemon2 = nombrePokemon2;
        this.ganador = ganador;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getNombreGimnasio() {
        return nombreGimnasio;
    }

    public void setNombreGimnasio(String nombreGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
    }

    public String getNombrePokemon1() {
        return nombrePokemon1;
    }

    public void setNombrePokemon1(String nombrePokemon1) {
        this.nombrePokemon1 = nombrePokemon1;
    }

    public String getNombrePokemon2() {
        return nombrePokemon2;
    }

    public void setNombrePokemon2(String nombrePokemon2) {
        this.nombrePokemon2 = nombrePokemon2;
    }
    
}
