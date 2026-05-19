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
        <link rel="stylesheet" href="./styles/estiloIndex.css">
    </head>
    <body>

        <div class="layout-container">
            <!-- Menu Lateral -->
            <aside class="sidebar">
                <nav>
                    <ul>
                        <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                        <li><a href="${pageContext.request.contextPath}/catalogo"><i class="fa-solid fa-box-open"></i> Catálogo de productos</a></li>
                        <li><a href="${pageContext.request.contextPath}/carrito"><i class="fa-solid fa-shopping-cart"></i> Carrito de compras</a></li>
                        <li><a href="${pageContext.request.contextPath}/misPedidos" class="active"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
                        <li><a href="${pageContext.request.contextPath}/Perfil"><i class="fa-solid fa-user"></i> Mi perfil</a></li>
                        <li><a href="loginView.jsp"><i class="fa-solid fa-right-to-bracket"></i> Iniciar sesión</a></li>
                    </ul>
                </nav>
            </aside>

            <!-- Panel principal (Derecha) -->
            <div class="main-panel">

                <!-- Barra Superior -->
                <header class="topbar">
                    <div class="topbar-links">
                        <a href="${pageContext.request.contextPath}/Perfil"><i class="fas fa-user"></i> Perfil</a>
                        <a href="${pageContext.request.contextPath}/Logout"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>               
                    </div>
                </header>

                <!-- Contenido -->
                <main class="content">
                    <section class="equipo">
                        <div class="equipo-grid">

                            <div class="equipo-info">
                                <h3 class="titulo-principal">Proyecto ECommerce</h3>
                                <p class="subtitulo-principal">Unidad 4</p>

                                <div class="texto-desarrollo">
                                    <h3> Equipo de Desarrollo</h3>
                                </div>

                                <div class="equipo-desarrollo">
                                    <div class="tarjeta-desarrollador">
                                        <div class="icono-dev">
                                            <span>&lt;&gt;</span>
                                        </div>
                                        <div class="info-dev">
                                            <p class="nombre-dev">Jose Adolfo Ortega Ruiz</p>
                                            <p class="id-dev">ID: 00000252882</p>
                                        </div>
                                    </div>

                                    <div class="tarjeta-desarrollador">
                                        <div class="icono-dev">
                                            <span>&lt;&gt;</span>
                                        </div>
                                        <div class="info-dev">
                                            <p class="nombre-dev">Angel Gabriel Beltran Duarte</p>
                                            <p class="id-dev">ID: 00000244865</p>
                                        </div>
                                    </div>

                                    <div class="info-proyecto">
                                        <h3>&#8505; Sobre este proyecto</h3>
                                        <p>Esta aplicación web es parte de los requerimientos para la Unidad 2. Implementa la estructura básica solicitada, incluyendo navegación consistente, manejo de modos claro/oscuro y diseño responsivo utilizando HTML Y CSS.</p>
                                    </div>

                                </div> 
                            </div>
                        </div>
                    </section>
                </main>

                <!-- Pie de pagina -->
                <footer class="footer">
                    <p>Aplicaciones Web – Unidad 4</p>
                </footer>

            </div>
        </div>

    </body>
</html>