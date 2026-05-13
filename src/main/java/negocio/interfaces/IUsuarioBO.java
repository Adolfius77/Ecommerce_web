/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.interfaces;

/**
 *
 * @author USER
 */
public interface IUsuarioBO {
    String autentificarGenerarToken(String correo, String contrasena);
}
