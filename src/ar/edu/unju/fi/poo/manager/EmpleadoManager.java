package ar.edu.unju.fi.poo.manager;

import java.util.Date;
import java.util.List;

import ar.edu.unju.fi.poo.dominio.Empleado;
import ar.edu.unju.fi.poo.util.CalculadoraEdad;

/**
 * Esta clase se encarga de gestionar la lista
 * de objetos del tipo Empleados
 * 
 * @author Estrada Cintia Belén
 * @since 29/08/2024
 * @version 1.0
 *
 */
public class EmpleadoManager {

    public static void listarEmpleados(List<Empleado> listaEmpleados) {
        for (Empleado empleado : listaEmpleados) {
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Fecha de Nacimiento: " + empleado.getFechanacimiento());
            System.out.println();
        }
    }

    public static void listarEmpleadosPorEdad(List<Empleado> listaEmpleados, int edadDeseada) {
        for (Empleado empleado : listaEmpleados) {
            Date fechaNacimiento = empleado.getFechanacimiento();
            int edad = CalculadoraEdad.calcularEdad(fechaNacimiento);

            if (edad >= edadDeseada) {
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Fecha de Nacimiento: " + empleado.getFechanacimiento());
                System.out.println("Edad: " + CalculadoraEdad.calcularEdad(fechaNacimiento));
                System.out.println();
            }
        }
    }
}
