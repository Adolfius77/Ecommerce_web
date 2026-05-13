/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Config.MongoClientProvider;
import model.Usuario;
import negocio.interfaces.IUsuarioBO;
import persistencia.IUsuarioDAO;
import persistencia.impl.UsuarioDAO;
import util.JWTProvider;

/**
 *
 * @author USER
 */
public class UsuarioBO implements IUsuarioBO{
    private  IUsuarioDAO usuarioBO;

    public UsuarioBO(IUsuarioDAO usuarioBO) {
        this.usuarioBO = new UsuarioDAO(MongoClientProvider.INSTANCE.getcCollection("usuario",Usuario.class));
    }
    
    @Override
    public String autentificarGenerarToken(String correo, String contrasena) {
        Usuario usuarioValido = usuarioBO.autentificar(correo, contrasena, "CLIENTE");
        
        if(usuarioValido != null){
            return JWTProvider.generarTokem(usuarioValido.getCorreo(), usuarioValido.getRol());
            
        }
        return null;
    }
    
}
