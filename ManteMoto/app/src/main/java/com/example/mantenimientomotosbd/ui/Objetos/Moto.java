package com.example.mantenimientomotosbd.ui.Objetos;

public class Moto {
    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private int anhoFabricacion;
    private float cv;
    private float parMotor;

    public Moto(String matricula, String marca, String modelo, int cilindrada, int anhoFabricacion, float cv, float parMotor) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.anhoFabricacion = anhoFabricacion;
        this.cv = cv;
        this.parMotor = parMotor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getAnhoFabricacion() {
        return anhoFabricacion;
    }

    public void setAnhoFabricacion(int anhoFabricacion) {
        this.anhoFabricacion = anhoFabricacion;
    }

    public float getCv() {
        return cv;
    }

    public void setCv(float cv) {
        this.cv = cv;
    }

    public float getParMotor() {
        return parMotor;
    }

    public void setParMotor(float parMotor) {
        this.parMotor = parMotor;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cilindrada=" + cilindrada +
                ", anhoFabricacion=" + anhoFabricacion +
                ", cv=" + cv +
                ", parMotor=" + parMotor +
                '}';
    }
}
