/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Usuario;
import negocio.UsuarioBO;
import negocio.interfaces.IUsuarioBO;

@Path("auth")
public class Auth extends HttpServlet {
    private IUsuarioBO UsuarioBO;

    public Auth(IUsuarioBO UsuarioBO) {
        this.UsuarioBO = UsuarioBO;
    }
@POST
@Path("Login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public Response login(Usuario credenciales){
    String token = UsuarioBO.autentificarGenerarToken(credenciales.getCorreo(), credenciales.getContrasena());
    if(token !=null){
        return Response.ok(token).build();
    }else{
        return Response.status(Response.Status.UNAUTHORIZED).entity("crendenciales invalidad").build();
    }
}
    


}
