package util;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Utilidad para hash y validación de contraseñas con BCrypt
 */
public class PasswordUtil {
    
    private static final int COST = 12;
    
    public PasswordUtil() {
    }
    
    /**
     * Hashea una contraseña en texto plano
     */
    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(COST, password.toCharArray());
    }
    
    /**
     * Verifica una contraseña en texto plano contra un hash
     */
    public static boolean verifyPassword(String password, String hash) {
        return BCrypt.verifyer().verify(password.toCharArray(), hash).verified;
    }
}
