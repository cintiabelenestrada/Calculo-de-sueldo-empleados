package ar.edu.unju.fi.poo.dominio;

import java.util.Date;

public class Administrativo extends Empleado {
    public Administrativo() {
        this.tipo = "Administrativo";
    }

    private static final double[] VALORES_CATEGORIA = {
        10000, 14000, 18000, 22000, 26000, 
        30000, 34000, 38000, 42000, 46000, 
        50000, 54000, 58000, 62000, 66000, 
        70000, 74000, 78000, 82000, 86000
    };

    private int categoria;

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        if (categoria < 1 || categoria > 20) {
            throw new IllegalArgumentException("Categoría debe estar entre 1 y 20.");
        }
        this.categoria = categoria;
    }

    public Administrativo(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public double getSueldoNeto() {

        System.out.println("****Calculo sueldo Neto Administrativo********");

        double remunerativosBonificables = super.getSueldoNeto()
                + (categoria > 0 ? VALORES_CATEGORIA[categoria - 1] : 0) + (antiguedad * 7000);
        double salarioFamiliar = cantidadhijos * 8000;
        double descuentos = 0.15 * remunerativosBonificables;

        return remunerativosBonificables + salarioFamiliar - descuentos;
    }
}