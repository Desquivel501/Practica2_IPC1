
package models;

import java.io.Serializable;

/**
 *
 * @author Derek
 */
public class Pokeball implements Serializable{
    private int id;
    private String tipo;

    public Pokeball(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

