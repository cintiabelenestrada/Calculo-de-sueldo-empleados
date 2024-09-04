package ar.edu.unju.fi.poo.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.poo.dominio.Administrativo;
import ar.edu.unju.fi.poo.dominio.Empleado;
import ar.edu.unju.fi.poo.dominio.Profesional;
import ar.edu.unju.fi.poo.manager.EmpleadoManager;
import ar.edu.unju.fi.poo.util.CalculadoraEdad;

public class MainEmpleado {
    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de empleado (Administrativo/Profesional): ");
        String tipoEmpleado = scanner.nextLine();

        Empleado empleado;

        if (tipoEmpleado.equalsIgnoreCase("Administrativo")) {
            empleado = new Administrativo();
            System.out.println("Ingrese la categoría (1 a 5): ");
            int categoria = scanner.nextInt();
            ((Administrativo) empleado).setCategoria(categoria);
        } else if (tipoEmpleado.equalsIgnoreCase("Profesional")) {
            empleado = new Profesional();
        } else {
            System.out.println("Tipo de empleado no válido");
            return;
        }
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese Nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la antigüedad del empleado (en años): ");
        int antiguedad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        empleado.setAntiguedad(antiguedad);

        System.out.println("Ingrese la cantidad de hijos a cargo del empleado: ");
        int cantidadhijos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        empleado.setCantidadhijos(cantidadhijos);

        // Solicitar al usuario que ingrese la fecha de nacimiento como una cadena
        System.out.println("Ingrese la fecha de nacimiento (formato dd/MM/yyyy): ");
        String cadenafechaNacimiento = scanner.nextLine();
        // Esta línea utiliza un objeto Scanner llamado scanner para leer la siguiente
        // línea de entrada del usuario. La entrada se almacena como una cadena (String)
        // y se asigna a la variable cadenafechaNacimiento

        // Convertir la cadena de fecha a un objeto Date
        SimpleDateFormat variableFormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date Fechanacimiento = null;

        // Esto indica un bloque try-catch, que se utiliza para manejar excepciones.
        // try: En este bloque se colocan las instrucciones que podrían generar una
        // excepción.
        try {
            Fechanacimiento = variableFormatoFecha.parse(cadenafechaNacimiento);
            // En este bloque de código se intenta convertir la cadena de fecha
            // en un objeto Date. Esto se hace utilizando el método parse del objeto
            // SimpleDateFormat. Si la conversión es exitosa, el objeto Date resultante se
            // asigna a la variable fechaNacimiento.

        } catch (ParseException variableconexception) {
            // catch (): Si se produce una excepción del tipo ParseException (que podría
            // ocurrir si el usuario ingresa una fecha en un formato incorrecto), el código
            // dentro de este bloque se ejecutará la variableconexception
            variableconexception.printStackTrace();
            System.out.println("Error al parsear la fecha");// Manejo de errores
            return;
            // printStackTrace();: Esta línea imprime la traza de la pila (stack trace) en
            // la consola. Muestra información sobre dónde ocurrió la excepción y qué causó
            // la excepción.
        }

        // Calcular la edad
        int edad = CalculadoraEdad.calcularEdad(Fechanacimiento);

        // Mostrar la edad
        System.out.println("La edad es: " + edad + " años");

        double sueldoNeto = empleado.getSueldoNeto();

        System.out.println("El salario neto de " + nombre + " es: " + sueldoNeto + " pesos");

        List<Empleado> listaEmpleados = new ArrayList<>();

        
        System.out.println("4)Ingrese la edad a partir de la cual desea buscar empleados: ");
        int edadDeseada = scanner.nextInt();

        EmpleadoManager.listarEmpleadosPorEdad(listaEmpleados, edadDeseada);

        EmpleadoManager.listarEmpleados(listaEmpleados);
        // 4.Mostrar los empleados cuya edad sea mayor o igual a un valor solicitado al usuario.
        // 5. Calcular el importe neto acumulado de todos los empleados cuya edad sea mayor o igual a un valor solicitado al usuario.
        // 6. Incrementar en un 10% el salario básico a todos los empleados cuya antigüedad sea menor o igual a 2 años
        scanner.close();

    }
}
