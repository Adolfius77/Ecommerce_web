package util;

import jakarta.servlet.http.HttpServletRequest;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Validación de datos de pago y envío en checkout (RF 5.2).
 */
public final class PagoValidator {

    private static final Set<String> METODOS_PERMITIDOS = new HashSet<>(
            Arrays.asList("tarjeta", "transferencia", "contraentrega"));

    private PagoValidator() {
    }

    public static Optional<String> validar(HttpServletRequest request) {
        String metodoPago = trim(request.getParameter("metodoPago"));
        if (metodoPago == null || metodoPago.isEmpty()) {
            return Optional.of("Debe seleccionar un método de pago");
        }
        if (!METODOS_PERMITIDOS.contains(metodoPago)) {
            return Optional.of("Método de pago no válido");
        }

        String direccion = trim(request.getParameter("direccion"));
        String direccionEnvio = trim(request.getParameter("direccionEnvio"));
        if ((direccion == null || direccion.isEmpty())
                && (direccionEnvio == null || direccionEnvio.isEmpty())) {
            return Optional.of("Debe proporcionar la dirección de envío");
        }

        String cp = trim(request.getParameter("codigoPostal"));
        if (cp != null && !cp.isEmpty() && !cp.matches("\\d{5}")) {
            return Optional.of("El código postal debe tener 5 dígitos");
        }

        if ("tarjeta".equals(metodoPago)) {
            return validarTarjeta(request);
        }

        return Optional.empty();
    }

    private static Optional<String> validarTarjeta(HttpServletRequest request) {
        String numero = trim(request.getParameter("numeroTarjeta"));
        if (numero == null || numero.isEmpty()) {
            return Optional.of("El número de tarjeta es obligatorio");
        }
        String digitos = numero.replaceAll("\\s+", "");
        if (!digitos.matches("\\d{13,19}")) {
            return Optional.of("El número de tarjeta debe tener entre 13 y 19 dígitos");
        }
        if (!luhnValido(digitos)) {
            return Optional.of("El número de tarjeta no es válido");
        }

        String titular = trim(request.getParameter("titularTarjeta"));
        if (titular == null || titular.length() < 2) {
            return Optional.of("El titular de la tarjeta es obligatorio");
        }

        String expiracion = trim(request.getParameter("fechaExpiracion"));
        if (expiracion == null || !expiracion.matches("\\d{2}/\\d{2}")) {
            return Optional.of("La fecha de expiración debe tener formato MM/AA");
        }
        try {
            YearMonth ym = YearMonth.parse(expiracion, DateTimeFormatter.ofPattern("MM/yy"));
            if (ym.isBefore(YearMonth.now())) {
                return Optional.of("La tarjeta está vencida");
            }
        } catch (DateTimeParseException e) {
            return Optional.of("Fecha de expiración no válida");
        }

        String cvv = trim(request.getParameter("cvv"));
        if (cvv == null || !cvv.matches("\\d{3,4}")) {
            return Optional.of("El CVV debe tener 3 o 4 dígitos");
        }

        return Optional.empty();
    }

    private static boolean luhnValido(String digitos) {
        int suma = 0;
        boolean alternar = false;
        for (int i = digitos.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(digitos.charAt(i));
            if (alternar) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            suma += n;
            alternar = !alternar;
        }
        return suma % 10 == 0;
    }

    public static String construirDireccionEnvio(HttpServletRequest request) {
        String direccionEnvio = trim(request.getParameter("direccionEnvio"));
        if (direccionEnvio != null && !direccionEnvio.isEmpty()) {
            return direccionEnvio;
        }
        String direccion = trim(request.getParameter("direccion"));
        String ciudad = trim(request.getParameter("ciudad"));
        String cp = trim(request.getParameter("codigoPostal"));
        StringBuilder sb = new StringBuilder();
        if (direccion != null) {
            sb.append(direccion);
        }
        if (ciudad != null && !ciudad.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(ciudad);
        }
        if (cp != null && !cp.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(" CP ");
            }
            sb.append(cp);
        }
        return sb.toString();
    }

    private static String trim(String s) {
        return s == null ? null : s.trim();
    }
}
