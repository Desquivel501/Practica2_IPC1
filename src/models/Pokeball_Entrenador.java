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
public class Pokeball_Entrenador implements Serializable{
    private int idAsignacion;
    private int idEntrenador;
    private int idPokeball;

    public Pokeball_Entrenador(int idAsignacion, int idEntrenador, int idPokeball) {
        this.idAsignacion = idAsignacion;
        this.idEntrenador = idEntrenador;
        this.idPokeball = idPokeball;
    }

    public int getIdPokeball() {
        return idPokeball;
    }

    public void setIdPokeball(int idPokeball) {
        this.idPokeball = idPokeball;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }
    
}
