package org.feriapp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CasetaFeria {
    private int id;
    private String nombre;
    private String titular;
    private int aforo;
    private String tipoCaseta;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getTipoCaseta() {
        return tipoCaseta;
    }

    public void setTipoCaseta(String tipoCaseta) {
        this.tipoCaseta = tipoCaseta;
    }

    @Override
    public String toString() {
        return "CasetaFeria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", titular='" + titular + '\'' +
                ", aforo=" + aforo +
                ", tipoCaseta='" + tipoCaseta + '\'' +
                '}';
    }
}
