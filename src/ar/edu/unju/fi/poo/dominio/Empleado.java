package ar.edu.unju.fi.poo.dominio;

import java.util.Date;

public abstract class Empleado {
    private Integer id;
    private String legajo;
    public String nombre;
    protected Integer cantidadhijos;
    protected Date fechaNacimiento;
    protected Integer antiguedad;
    protected Integer tipo;
    protected Integer categoria;
    public static final double SUELDO_BASICO = 150000;

    public double getSueldoNeto() {
        return SUELDO_BASICO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadhijos() {
        return cantidadhijos;
    }

    public void setCantidadhijos(Integer cantidadhijos) {
        this.cantidadhijos = cantidadhijos;
    }

    public Date getFechanacimiento() {
        return fechaNacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechaNacimiento = fechanacimiento;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Empleado " + id +", nombre=" + nombre + ", legajo=" + legajo + ", cantidad de hijos=" + cantidadhijos
                + ", fecha de nacimiento=" + fechaNacimiento + ", antigüedad=" + antiguedad;
    }
}