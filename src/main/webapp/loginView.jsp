<%-- 
    Document   : newjsp
    Created on : May 12, 2026, 7:34:43 PM
    Author     : adolfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Aplicaciones Web - Unidad 2</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="./styles/estiloLogin.css">
    </head>
    <body>

        <div class="layout-container">
            <!-- Menu Lateral -->
            <aside class="sidebar">
                <nav>
                    <ul>
                        <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                        <li><a href="catalogoView.jsp"><i class="fa-solid fa-box-open"></i> Catálogo de productos</a></li>
                        <li><a href="carritoView.jsp"><i class="fa-solid fa-shopping-cart"></i> Carrito de compras</a></li>
                        <li><a href="#pedidos"><i class="fa-solid fa-list"></i> Gestión de pedidos</a></li>
                        <li><a href="loginView.jsp"><i class="fa-solid fa-user"></i> Iniciar sesión</a></li>
                    </ul>
                </nav>
            </aside>

            <!-- Panel principal (Derecha) -->
            <div class="main-panel">

                <!-- Barra Superior -->
                <header class="topbar">
                    <div class="topbar-links">
                        <a href="#perfil"><i class="fas fa-user"></i> Perfil</a>
                        <a href="#logout"><i class="fas fa-sign-out-alt"></i> Cerrar sesiÃ³n</a>
                    </div>
                </header>

                <!-- Contenido -->
                <main class="content">
                    <div class="contenedor-login">
                        <div class ="cabecera-login">
                            <h2>Bienvenido al sistema</h2>
                            <p>Ingrese sus credenciales</p>
                        </div>
                        <form id = "loginForm" class = "formulario-login">
                            <input type="hidden" name="accion" value="loginAdmin">
                            <div class="campo-form">
                                <label for="email">Correo electronico:</label>
                                <input type="email" id="email" name="email" required>
                            </div>
                            <div class="campo-form">
                                <label for="password">Contraseña:</label>
                                <input type="password" id="password" name="password" required>
                            </div>
                            <div class="contrasena-olvidada">
                                <p><a href="#recuperar">¿Olvidaste tu contraseña?</a></p>
                            </div>
                            <div class = "boton-login">
                                <button type="submit">Iniciar sesion</button>
                            </div>

                            <div class = "pie-login">
                                <hr>
                                <p>¿No tienes una cuenta? <a href="registroView.jsp">Regi­strate aqui­</a></p>
                            </div>

                            <div class="btn-regresar">
                                <button type="button" onclick="window.history.back();"><i class="fa-solid fa-arrow-left"></i> Regresar</button>                        </div>
                        </form>
                    </div>
                </main>

                <!-- Pie de pagina -->
                <footer class="footer">
                    <p>Aplicaciones Web – Unidad 4</p>
                </footer>

            </div>
        </div>
        <script>
            document.getElementById('loginForm').addEventListener('submit', async function(event) {
        
        event.preventDefault();

        const correoInput = document.getElementById('email').value;
        const contrasenaInput = document.getElementById('password').value;

        const credenciales = {
            correo: correoInput,
            contrasena: contrasenaInput
        };

        try {
            const response = await fetch('resources/auth/Login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(credenciales)
            });

            if (response.ok) {
                const token = await response.text();
                
                localStorage.setItem('jwtToken', token); 
                
                alert('¡Inicio de sesión exitoso!');
                
                window.location.href = 'catalogoView.jsp'; 
            } else {
                alert('Correo o contraseña incorrectos. Por favor, intenta de nuevo.');
            }
        } catch (error) {
            console.error('Error de red o de servidor:', error);
            alert('Ocurrió un error al intentar conectarse al servidor.');
        }
    });
        </script>


    </body>
</html>