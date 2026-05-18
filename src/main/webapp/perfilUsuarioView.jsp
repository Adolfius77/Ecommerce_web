<%-- Perfil del cliente: editar nombre, dirección y contraseña --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi perfil</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./styles/estiloRegistro.css">
</head>
<body>
    <div class="layout-container">
        <aside class="sidebar">
            <nav>
                <ul>
                    <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                    <li><a href="catalogoView.jsp"><i class="fa-solid fa-box-open"></i> Catálogo de productos</a></li>
                    <li><a href="carritoView.jsp"><i class="fa-solid fa-shopping-cart"></i> Carrito de compras</a></li>
                    <li><a href="misPedidosView.jsp"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
                    <li><a href="gestionProductosView.jsp"><i class="fa-solid fa-screwdriver-wrench"></i> Administración</a></li>
                    <li><a href="perfilUsuarioView.jsp" class="active"><i class="fa-solid fa-user"></i> Mi perfil</a></li>
                    <li><a href="loginView.jsp"><i class="fa-solid fa-right-to-bracket"></i> Iniciar sesión</a></li>
                </ul>
            </nav>
        </aside>
        <div class="main-panel">
            <header class="topbar">
                <div class="topbar-links">
                    <a href="perfilUsuarioView.jsp"><i class="fas fa-user"></i> Perfil</a>
                    <a href="loginView.jsp"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>
                </div>
            </header>
            <main class="content">
                <div class="registro-card">
                    <div class="registro-header">
                        <h2>Mi perfil</h2>
                        <p>Actualiza tu nombre para mostrar, dirección y contraseña. El backend puede mapear solo correo, teléfono y dirección según el modelo Usuario actual.</p>
                    </div>
                    <%-- Mostrar mensajes de exito o error --%>
                    <% if (request.getAttribute("mensaje") != null) { %>
                        <div style="background-color: #d4edda; border: 1px solid #c3e6cb; color: #155724; padding: 12px; border-radius: 4px; margin-bottom: 15px;">
                            <i class="fas fa-check-circle"></i> <%= request.getAttribute("mensaje") %>
                        </div>
                    <% } %>
                    <% if (request.getAttribute("error") != null) { %>
                        <div style="background-color: #f8d7da; border: 1px solid #f5c6cb; color: #721c24; padding: 12px; border-radius: 4px; margin-bottom: 15px;">
                            <i class="fas fa-exclamation-circle"></i> <%= request.getAttribute("error") %>
                        </div>
                    <% } %>
                    <form class="registro-form" action="${pageContext.request.contextPath}/Perfil" method="post">
                        <div class="form-grid">
                            <div class="campo-form">
                                <label for="nombrePerfil">Nombre para mostrar</label>
                                <input type="text" id="nombrePerfil" name="nombrePerfil" value="${usuarioPerfil.nombre}">
                            </div>
                            <div class="campo-form">
                                <label for="correoPerfil">Correo electrónico</label>
                                <input type="email" id="correoPerfil" name="correoPerfil" value="${usuarioPerfil.correo}" readonly>
                            </div>
                        </div>
                        <div class="form-grid">
                            <div class="campo-form">
                                <label for="telefonoPerfil">Teléfono</label>
                                <input type="tel" id="telefonoPerfil" name="telefonoPerfil" value="${usuarioPerfil.telefono}">
                            </div>
                            <div class="campo-form">
                                <label for="direccionPerfil">Dirección</label>
                                <input type="text" id="direccionPerfil" name="direccionPerfil" value="${usuarioPerfil.direccion}">
                            </div>
                        </div>
                        <hr style="border:none;border-top:1px solid #e0e0e0;margin:20px 0;">
                        <p style="font-size:14px;color:#5f6368;margin-bottom:12px;">Cambiar contraseña</p>
                        <div class="form-grid">
                            <div class="campo-form">
                                <label for="passwordActual">Contraseña actual</label>
                                <input type="password" id="passwordActual" name="passwordActual" autocomplete="current-password">
                            </div>
                            <div class="campo-form">
                                <label for="passwordNueva">Nueva contraseña</label>
                                <input type="password" id="passwordNueva" name="passwordNueva" autocomplete="new-password">
                            </div>
                        </div>
                        <div class="form-grid">
                            <div class="campo-form">
                                <label for="passwordConfirmar">Confirmar nueva contraseña</label>
                                <input type="password" id="passwordConfirmar" name="passwordConfirmar" autocomplete="new-password">
                            </div>
                        </div>
                        <div class="botones-form" style="margin-top:10px;">
                            <button type="submit" class="btn-primario">Guardar cambios</button>
                            <a class="btn-secundario" href="catalogoView.jsp">Volver al catálogo</a>
                        </div>
                    </form>
                </div>
            </main>
            <footer class="footer">
                <p>Aplicaciones Web – Unidad 4</p>
            </footer>
        </div>
    </div>
</body>
</html>
