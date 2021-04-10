
package models;

import java.io.Serializable;

/**
 *
 * @author Derek
 */
public class Pelea implements Serializable{
    int gimnasio;
    int idPokemon1;
    int idPokemon2;

    public Pelea(int gimnasio, int idPokemon1, int idPokemon2) {
        this.gimnasio = gimnasio;
        this.idPokemon1 = idPokemon1;
        this.idPokemon2 = idPokemon2;
    }

    public int getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(int gimnasio) {
        this.gimnasio = gimnasio;
    }

    public int getIdPokemon1() {
        return idPokemon1;
    }

    public void setIdPokemon1(int idPokemon1) {
        this.idPokemon1 = idPokemon1;
    }

    public int getIdPokemon2() {
        return idPokemon2;
    }

    public void setIdPokemon2(int idPokemon2) {
        this.idPokemon2 = idPokemon2;
    }
    
}
