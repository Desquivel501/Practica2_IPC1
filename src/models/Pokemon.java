
package models;
import java.io.Serializable;

/**
 *
 * @author Derek
 */
public class Pokemon implements Serializable{
    private int id;
    private String tipo;
    private String nombre;
    private Double vida;
    private Double ataque;
    private boolean capturado;
    private boolean estado;
    

    public Pokemon(int id, String tipo,String nombre, Double vida, Double ataque, boolean capturado, boolean estado) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.capturado = capturado;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getVida() {
        return vida;
    }

    public void setVida(Double vida) {
        this.vida = vida;
    }

    public Double getAtaque() {
        return ataque;
    }

    public void setAtaque(Double ataque) {
        this.ataque = ataque;
    }

    public boolean isCapturado() {
        return capturado;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }
    
}

