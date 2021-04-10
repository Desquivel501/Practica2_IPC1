
package models;

import java.io.Serializable;

/**
 *
 * @author Derek
 */
public class Pokemon_Pokeball implements Serializable{
    private int idAsignacion;
    private int idPokeball;
    private int idPokemon;

    public Pokemon_Pokeball(int idAsignacion, int idPokeball, int idPokemon) {
        this.idAsignacion = idAsignacion;
        this.idPokeball = idPokeball;
        this.idPokemon = idPokemon;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getIdPokeball() {
        return idPokeball;
    }

    public void setIdPokeball(int idPokeball) {
        this.idPokeball = idPokeball;
    }
    
}
