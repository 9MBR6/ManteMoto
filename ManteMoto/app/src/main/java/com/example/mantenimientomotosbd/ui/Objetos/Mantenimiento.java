package com.example.mantenimientomotosbd.ui.Objetos;

public class Mantenimiento {
    private int idMantenimiento;
    private String fecha;
    private int km;
    private String aceite;
    private String filtroAceite;
    private String filtroAire;
    private String bujia;
    private String pastillasDelanteras;
    private String pastillasTraseras;
    private String liquidoFrenos;
    private String kitArrastre;
    private String comentarios;

    public Mantenimiento(int idMantenimiento, String fecha, int km, String aceite, String filtroAceite,
                         String filtroAire, String bujia, String pastillasDelanteras, String pastillasTraseras,
                         String liquidoFrenos, String kitArrastre, String comentarios) {
        this.idMantenimiento = idMantenimiento;
        this.fecha = fecha;
        this.km = km;
        this.aceite = aceite;
        this.filtroAceite = filtroAceite;
        this.filtroAire = filtroAire;
        this.bujia = bujia;
        this.pastillasDelanteras = pastillasDelanteras;
        this.pastillasTraseras = pastillasTraseras;
        this.liquidoFrenos = liquidoFrenos;
        this.kitArrastre = kitArrastre;
        this.comentarios = comentarios;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getAceite() {
        return aceite;
    }

    public void setAceite(String aceite) {
        this.aceite = aceite;
    }

    public String getFiltroAceite() {
        return filtroAceite;
    }

    public void setFiltroAceite(String filtroAceite) {
        this.filtroAceite = filtroAceite;
    }

    public String getFiltroAire() {
        return filtroAire;
    }

    public void setFiltroAire(String filtroAire) {
        this.filtroAire = filtroAire;
    }

    public String getBujia() {
        return bujia;
    }

    public void setBujia(String bujia) {
        this.bujia = bujia;
    }

    public String getPastillasDelanteras() {
        return pastillasDelanteras;
    }

    public void setPastillasDelanteras(String pastillasDelanteras) {
        this.pastillasDelanteras = pastillasDelanteras;
    }

    public String getPastillasTraseras() {
        return pastillasTraseras;
    }

    public void setPastillasTraseras(String pastillasTraseras) {
        this.pastillasTraseras = pastillasTraseras;
    }

    public String getLiquidoFrenos() {
        return liquidoFrenos;
    }

    public void setLiquidoFrenos(String liquidoFrenos) {
        this.liquidoFrenos = liquidoFrenos;
    }

    public String getKitArrastre() {
        return kitArrastre;
    }

    public void setKitArrastre(String kitArrastre) {
        this.kitArrastre = kitArrastre;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" +
                "idMantenimiento=" + idMantenimiento +
                ", fecha='" + fecha + '\'' +
                ", km=" + km +
                ", aceite='" + aceite + '\'' +
                ", filtroAceite='" + filtroAceite + '\'' +
                ", filtroAire='" + filtroAire + '\'' +
                ", bujia='" + bujia + '\'' +
                ", pastillasDelanteras='" + pastillasDelanteras + '\'' +
                ", pastillasTraseras='" + pastillasTraseras + '\'' +
                ", liquidoFrenos='" + liquidoFrenos + '\'' +
                ", kitArrastre='" + kitArrastre + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
