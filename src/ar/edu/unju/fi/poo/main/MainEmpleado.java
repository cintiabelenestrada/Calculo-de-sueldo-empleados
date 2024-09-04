package ar.edu.unju.fi.poo.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.poo.dominio.Administrativo;
import ar.edu.unju.fi.poo.dominio.Empleado;
import ar.edu.unju.fi.poo.dominio.Profesional;
import ar.edu.unju.fi.poo.util.CalculadoraEdad;

public class MainEmpleado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Empleado> empleadosList = new ArrayList<>(); // Lista para almacenar empleados

        String continuar= "";
        do {
            int tipo = 0;
            do {
                try {
                    System.out.print("Tipo de empleado (1- Profesional, 2- Administrativo): ");
                    tipo = scanner.nextInt();
                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Debe ingresar 1 para Profesional o 2 para Administrativo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número (1 o 2).");
                    scanner.next(); // Limpiar la entrada incorrecta
                }
            } while (tipo != 1 && tipo != 2);

            Empleado empleado;

            if (tipo == 1) {
                empleado = new Profesional();
            } else if (tipo == 2) {
                empleado = new Administrativo();
                int categoria;
                do {
                    System.out.print("Ingrese la categoría (1 a 20): ");
                    categoria = scanner.nextInt();
                    if (categoria < 1 || categoria > 20) {
                        System.out.println("La categoría debe estar entre 1 y 20. Por favor, intente de nuevo.");
                    }
                } while (categoria < 1 || categoria > 20);

                ((Administrativo) empleado).setCategoria(categoria);
            } else {
                System.out.println("Debe ingresar 1 para Profesional o 2 para Administrativo.");
                continue;  // Si el tipo no es 1 o 2, vuelve al principio del ciclo
            }

            System.out.println("Ingrese Nombre del empleado: ");
            scanner.nextLine();  // Consumir el salto de línea
            String nombre = scanner.nextLine();
            empleado.setNombre(nombre);

            System.out.println("Ingrese la cantidad de años de antigüedad del empleado: ");
            int antiguedad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            empleado.setAntiguedad(antiguedad);

            System.out.println("Ingrese la cantidad de hijos a cargo del empleado: ");
            int cantidadhijos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            empleado.setCantidadhijos(cantidadhijos);

            System.out.println("Ingrese la fecha de nacimiento (formato dd/MM/yyyy): ");
            // scanner.nextLine();
            String cadenafechaNacimiento = scanner.nextLine();

            SimpleDateFormat variableFormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date Fechanacimiento = null;

            try {
                Fechanacimiento = variableFormatoFecha.parse(cadenafechaNacimiento);
                empleado.setFechanacimiento(Fechanacimiento);
            } catch (ParseException variableconexception) {
                variableconexception.printStackTrace();
                System.out.println("Error al parsear la fecha");// Manejo de errores
                continue;  // Volver al inicio del ciclo si hay un error al parsear la fecha
            }

    
            double sueldoNeto = empleado.getSueldoNeto();
    
            System.out.println("El salario neto de " + nombre + " es: " + sueldoNeto + " pesos");
    
            // Calcular la edad
            int edad = CalculadoraEdad.calcularEdad(Fechanacimiento);
            System.out.println("La edad es: " + edad + " años");

            // Agregar empleado a la lista
            empleadosList.add(empleado);

            System.out.print("¿Desea continuar cargando empleados? (S/N): ");
            continuar = scanner.next();
            
        } while (continuar.equalsIgnoreCase("S"));
        // Mostrar empleados según edad
        System.out.print("Ingrese la edad a partir de la cual desea buscar empleados: ");
        int edadMinima = scanner.nextInt();

        System.out.println("Empleados con edad mayor o igual a " + edadMinima + ":");
        for (Empleado empleado : empleadosList) {
            int edadEmpleado = CalculadoraEdad.calcularEdad(empleado.getFechanacimiento());
            if (edadEmpleado >= edadMinima) {
                System.out.println(empleado.getNombre() + " - Edad: " + edadEmpleado);
            }
        }

        scanner.close();

        // EmpleadoManager.listarEmpleados(listaEmpleados);

        // 5. Calcular el importe neto acumulado de todos los empleados cuya edad sea mayor o igual a un valor solicitado al usuario.
        // 6. Incrementar en un 10% el salario básico a todos los empleados cuya antigüedad sea menor o igual a 2 años
        

    }
}
