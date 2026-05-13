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
    <title>Proyecto ECommerce - Checkout</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./styles/estiloCheckout.css">
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
                <div class="checkout-header">
                    <h2>Checkout: pago y envío</h2>
                    <p>Selecciona la dirección, método de envío y pago.</p>
                </div>

                <div class="checkout-grid">
                    <section class="checkout-form">
                        <div class="form-section">
                            <h3>Dirección de envío</h3>
                            <div class="form-row">
                                <div class="campo-form">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" id="nombre" placeholder="Nombre">
                                </div>
                                <div class="campo-form">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" id="apellido" placeholder="Apellido">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="campo-form">
                                    <label for="email">Correo</label>
                                    <input type="email" id="email" placeholder="correo@ejemplo.com">
                                </div>
                                <div class="campo-form">
                                    <label for="telefono">Teléfono</label>
                                    <input type="tel" id="telefono" placeholder="+52 555 000 000">
                                </div>
                            </div>
                            <div class="campo-form">
                                <label for="direccion">Dirección</label>
                                <input type="text" id="direccion" placeholder="Calle, número, colonia">
                            </div>
                            <div class="form-row">
                                <div class="campo-form">
                                    <label for="ciudad">Ciudad</label>
                                    <input type="text" id="ciudad" placeholder="Ciudad">
                                </div>
                                <div class="campo-form">
                                    <label for="cp">Código postal</label>
                                    <input type="text" id="cp" placeholder="00000">
                                </div>
                            </div>
                        </div>

                        <div class="form-section">
                            <h3>Método de envío</h3>
                            <label class="opcion-radio"><input type="radio" name="envio" checked> Estándar (2-4 días) - $8.00</label>
                            <label class="opcion-radio"><input type="radio" name="envio"> Express (24h) - $15.00</label>
                        </div>

                        <div class="form-section">
                            <h3>Método de pago</h3>
                            <label class="opcion-radio"><input type="radio" name="pago" checked> Tarjeta de crédito/débito</label>
                            <div class="form-row">
                                <div class="campo-form">
                                    <label for="tarjeta">Número de tarjeta</label>
                                    <input type="text" id="tarjeta" placeholder="0000 0000 0000 0000">
                                </div>
                                <div class="campo-form">
                                    <label for="titular">Titular</label>
                                    <input type="text" id="titular" placeholder="Nombre en la tarjeta">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="campo-form">
                                    <label for="expira">Fecha de expiración</label>
                                    <input type="text" id="expira" placeholder="MM/AA">
                                </div>
                                <div class="campo-form">
                                    <label for="cvv">CVV</label>
                                    <input type="password" id="cvv" placeholder="***">
                                </div>
                            </div>
                            <label class="opcion-radio"><input type="radio" name="pago"> Transferencia bancaria</label>
                            <label class="opcion-radio"><input type="radio" name="pago"> Pago contra entrega</label>
                        </div>
                    </section>

                    <aside class="resumen-card">
                        <h3>Resumen del pedido</h3>
                        <div class="resumen-linea">
                            <span>Subtotal</span>
                            <span>$238.00</span>
                        </div>
                        <div class="resumen-linea">
                            <span>Envío</span>
                            <span>$8.00</span>
                        </div>
                        <div class="resumen-linea total">
                            <span>Total</span>
                            <span>$246.00</span>
                        </div>
                        <button class="btn-primario">Confirmar pedido</button>
                        <p class="nota-resumen">Al confirmar aceptas los términos y condiciones.</p>
                        <div class="mensaje-confirmacion">
                            <i class="fa-solid fa-circle-check"></i>
                            Pedido confirmado. Recibirás un correo con los detalles.
                        </div>
                    </aside>
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
