
package models;

import java.io.Serializable;

/**
 *
 * @author Derek
 */
public class Asignar_Alimento implements Serializable{
    private int idActividad;
    private int idAlimento;
    private int idPokemon;

    public Asignar_Alimento(int idActividad, int idAlimento, int idPokemon) {
        this.idActividad = idActividad;
        this.idAlimento = idAlimento;
        this.idPokemon = idPokemon;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }
   

    
    
}
