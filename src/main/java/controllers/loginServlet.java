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
import negocio.UsuarioBO;
import negocio.interfaces.IUsuarioBO;

/**
 *
 * @author USER
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {
    
    private IUsuarioBO usuarioBo;
    
    public loginServlet() {
        this.usuarioBo = new UsuarioBO();
    }
    //nota esto redirige
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/loginView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String correo = request.getParameter("email");
      String password = request.getParameter("password");
      
      String token = usuarioBo.autentificarGenerarToken(correo, password);
      
      if(token != null){
          HttpSession sesion = request.getSession();
          sesion.setAttribute("token", token);
          sesion.setAttribute("usuario", correo);
          
          response.sendRedirect(request.getContextPath() + "/index.jsp");
      }else{
          request.setAttribute("error", "correo o contrasena incorrectos");
          request.getRequestDispatcher("/loginView.jsp").forward(request, response);
      }
    }

    
}
