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
        <title>Proyecto ECommerce - Detalle del producto</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="./styles/estiloDetalleProducto.css">
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
                        <li><a href="misPedidosView.jsp"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
                        <li><a href="gestionProductosView.jsp"><i class="fa-solid fa-screwdriver-wrench"></i> Administración</a></li>
                        <li><a href="perfilUsuarioView.jsp"><i class="fa-solid fa-user"></i> Mi perfil</a></li>
                        <li><a href="loginView.jsp"><i class="fa-solid fa-right-to-bracket"></i> Iniciar sesión</a></li>
                    </ul>
                </nav>
            </aside>

            <!-- Panel principal (Derecha) -->
            <div class="main-panel">

                <!-- Barra Superior -->
                <header class="topbar">
                    <div class="topbar-links">
                        <a href="perfilUsuarioView.jsp"><i class="fas fa-user"></i> Perfil</a>
                        <a href="loginView.jsp"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>
                    </div>
                </header>

                <!-- Contenido -->
                <main class="content">
                    <div class="detalle-header">
                        <a class="link-volver" href="catalogoView.jsp"><i class="fa-solid fa-arrow-left"></i> Volver al catálogo</a>
                    </div>

                    <div class="detalle-producto">
                        <div class="detalle-galeria">
                            <div class="galeria-principal">Imagen principal</div>
                            <div class="galeria-mini">
                                <div class="galeria-thumb">1</div>
                                <div class="galeria-thumb">2</div>
                                <div class="galeria-thumb">3</div>
                                <div class="galeria-thumb">4</div>
                            </div>
                        </div>

                        <div class="detalle-info">
                            <h2>Audi­fonos inalambricos Pro</h2>
                            <p class="detalle-categoria">Electronica Â· Audio</p>
                            <div class="detalle-rating">
                                <span class="estrellas">3</span>
                                <span class="rating-text">4.8 (120 reseñas)</span>
                            </div>
                            <p class="detalle-precio">$149.99</p>
                            <p class="detalle-descripcion">
                                Disfruta de sonido envolvente con cancelacion de ruido activa y bater­a de larga duracion.
                                Incluye estuche de carga rapida y controles tactiles inteligentes.
                            </p>
                            <ul class="detalle-lista">
                                <li>Cancelacion de ruido activa</li>
                                <li>Autonomi­a hasta 30 horas</li>
                                <li>Conectividad Bluetooth 5.2</li>
                            </ul>

                            <div class="detalle-acciones">
                                <div class="selector-cantidad">
                                    <button type="button">-</button>
                                    <span>1</span>
                                    <button type="button">+</button>
                                </div>
                                <button class="btn-primario"><i class="fa-solid fa-cart-plus"></i> Agregar al carrito</button>
                            </div>

                            <div class="detalle-extra">
                                <span><i class="fa-solid fa-truck"></i> Envi­o 24-48h</span>
                                <span><i class="fa-solid fa-shield"></i> Garanti­a 1 año</span>
                            </div>
                        </div>
                    </div>
                </main>

                <!-- Pie de pagina -->
                <footer class="footer">
                    <p>Aplicaciones Web – Unidad 4</p>
                </footer>

            </div>
        </div>

    </body>
</html>
