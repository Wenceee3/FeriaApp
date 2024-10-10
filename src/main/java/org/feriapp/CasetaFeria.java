package org.feriapp;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "caseta")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "nombre", "titular", "aforo", "tipoCaseta" })
public class CasetaFeria {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "titular")
    private String titular;

    @XmlElement(name = "aforo")
    private int aforo;

    @XmlElement(name = "tipoCaseta")
    private String tipoCaseta;

    // Constructor por defecto
    public CasetaFeria() {}

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
