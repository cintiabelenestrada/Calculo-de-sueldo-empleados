package ar.edu.unju.fi.poo.dominio;

import java.util.Date;

public class Profesional extends Empleado {
    public Profesional() {
        this.tipo = 1;
    }

    public static final double ADICIONAL_PROFESIONAL = 80000;

    public Profesional(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public double getSueldoNeto() {
        System.out.println("Calculo del Sueldo Neto Profesional: ");

        double remunerativosBonificables = super.getSueldoNeto() + ADICIONAL_PROFESIONAL + (antiguedad * 7000);
        double salarioFamiliar = cantidadhijos * 8000;
        double descuentos = 0.15 * remunerativosBonificables;

        return remunerativosBonificables + salarioFamiliar - descuentos;
    }
}
