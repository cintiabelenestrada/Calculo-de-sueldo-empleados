package ar.edu.unju.fi.poo.dominio;

import java.util.Date;

public class Administrativo extends Empleado {
    public Administrativo() {
        this.tipo = "Administrativo";
    }

    private static final double[] VALORES_CATEGORIA = { 10000, 14000, 18000, 30000,
            40000 };

    private int categoria;

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Administrativo(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public double getSueldoNeto() {

        System.out.println("Calculo sueldo Neto Administrativo");

        double remunerativosBonificables = super.getSueldoNeto()
                + (categoria > 0 ? VALORES_CATEGORIA[categoria - 1] : 0) + (antiguedad * 7000);
        double salarioFamiliar = cantidadhijos * 8000;
        double descuentos = 0.15 * remunerativosBonificables;

        return remunerativosBonificables + salarioFamiliar - descuentos;

    }
}