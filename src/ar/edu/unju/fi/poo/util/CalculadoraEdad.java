package ar.edu.unju.fi.poo.util;

import java.util.Calendar;
import java.util.Date;

public class CalculadoraEdad {

    public static int calcularEdad(Date fechaNacimiento) {
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaNacimiento);

        Calendar ahora = Calendar.getInstance();

        int edad = ahora.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);

        if (ahora.get(Calendar.DAY_OF_YEAR) < fechaNacimientoCal.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        return edad;
    }
}
