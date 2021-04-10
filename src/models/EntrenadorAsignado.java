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
public class EntrenadorAsignado implements Serializable{
    private int idAsignacion;
    private String nombreEntrenador;
    private String nombrePokemon1;
    private String nombrePokemon2;
    private String nombrePokemon3;
    private String nombrePokemon4;
    private String nombrePokemon5;

    public EntrenadorAsignado(int idAsignacion, String nombreEntrenador, String nombrePokemon1, String nombrePokemon2, String nombrePokemon3, String nombrePokemon4, String nombrePokemon5) {
        this.idAsignacion = idAsignacion;
        this.nombreEntrenador = nombreEntrenador;
        this.nombrePokemon1 = nombrePokemon1;
        this.nombrePokemon2 = nombrePokemon2;
        this.nombrePokemon3 = nombrePokemon3;
        this.nombrePokemon4 = nombrePokemon4;
        this.nombrePokemon5 = nombrePokemon5;
    }

    public String getNombrePokemon5() {
        return nombrePokemon5;
    }

    public void setNombrePokemon5(String nombrePokemon5) {
        this.nombrePokemon5 = nombrePokemon5;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
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

    public String getNombrePokemon3() {
        return nombrePokemon3;
    }

    public void setNombrePokemon3(String nombrePokemon3) {
        this.nombrePokemon3 = nombrePokemon3;
    }

    public String getNombrePokemon4() {
        return nombrePokemon4;
    }

    public void setNombrePokemon4(String nombrePokemon4) {
        this.nombrePokemon4 = nombrePokemon4;
    }
    
}

