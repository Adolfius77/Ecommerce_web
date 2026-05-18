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
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import model.Usuario;
import negocio.UsuarioBO;
import negocio.interfaces.IUsuarioBO;

/**
 *
 * @author USER
 */
@WebServlet(name = "PerfilServlet", urlPatterns = {"/Perfil"})
public class PerfilServlet extends HttpServlet {

    private IUsuarioBO usarioBo;

    public PerfilServlet() {
        this.usarioBo = new UsuarioBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);

        if (sesion != null && sesion.getAttribute("usuario") != null) {
            String correo = (String) sesion.getAttribute("usuario");
            Optional<Usuario> usuarioOpt = usarioBo.obtenerUsuarioPorCorreo(correo);

            if (usuarioOpt.isPresent()) {
                request.setAttribute("usuarioPerfil", usuarioOpt.get());
                request.getRequestDispatcher("perfilUsuarioView.jsp").forward(request, response);
                return;
            }
            response.sendRedirect(request.getContextPath() + "/loginView.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessio = request.getSession(false);

        if (sessio == null || sessio.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/loginView.jsp");
            return;
        }
        String correo = (String) sessio.getAttribute("usuario");
        Optional<Usuario> usuarioOpt = usarioBo.obtenerUsuarioPorCorreo(correo);
        
        if(usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            
            String nombre = request.getParameter("nombrePerfil");
            String telefono = request.getParameter("telefonoPerfil");
            String direcion = request.getParameter("direccionPerfil");
            String paswordActual = request.getParameter("passwordActual");
            String paswordNueva = request.getParameter("passwordNueva");
            String paswordConfirmar = request.getParameter("passwordConfirmar");
            
            usuario.setNombre(nombre);
            usuario.setTelefono(telefono);
            usuario.setDireccion(direcion);
            
            if(paswordActual != null && !paswordActual.trim().isEmpty()){
                if(!usuario.getContrasena().equals(paswordActual)){
                    request.setAttribute("error", "la contrasena actual es incorrecta");
                    request.setAttribute("usuarioPerfil",usuario);
                    request.getRequestDispatcher("/perfilUsuarioView.jsp").forward(request, response);
                    return;
                }
                if(paswordNueva != null && paswordNueva.equals(paswordConfirmar) && !paswordNueva.trim().isEmpty()){
                    usuario.setContrasena(paswordNueva);
                }else{
                    request.setAttribute("error", "la nueva contrasena no coiciden o estan  vacias");
                    request.setAttribute("usuarioPerfil", usuario);
                    request.getRequestDispatcher("/perfilUsuarioView.jsp").forward(request, response);
                    return;
                }
            }
            try {
                usarioBo.actualizarUsuario(usuario);
                request.setAttribute("mensaje", "perfil actualizado con exito");
                request.setAttribute("usuarioPerfil", usuario);
                request.getRequestDispatcher("/perfilUsuarioView.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("error", "error al actualizar" + e.getMessage());
                request.setAttribute("usuarioPerfil", usuario);
                request.getRequestDispatcher("/perfilUsuarioView.jsp").forward(request, response);
            }
        }
    }

}
