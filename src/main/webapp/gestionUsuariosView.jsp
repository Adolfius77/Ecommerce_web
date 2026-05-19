<%-- Gestión de usuarios: activar o desactivar cuentas (vista administrador) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Administración - Usuarios</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="./styles/estiloGestionPanel.css">
    </head>
    <body>
        <div class="layout-container">
            <aside class="sidebar">
                <nav>
                    <ul>
                        <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                        <li><a href="catalogoView.jsp"><i class="fa-solid fa-box-open"></i> Catálogo</a></li>
                        <li><a href="gestionProductosView.jsp"><i class="fa-solid fa-warehouse"></i> Inventario</a></li>
                        <li><a href="gestionCategoriasView.jsp"><i class="fa-solid fa-tags"></i> Categorías</a></li>
                        <li><a href="gestionUsuariosView.jsp" class="active"><i class="fa-solid fa-users"></i> Usuarios</a></li>
                        <li><a href="gestionPedidosPagosView.jsp"><i class="fa-solid fa-receipt"></i> Pedidos y pagos</a></li>
                        <li><a href="moderacionResenasView.jsp"><i class="fa-solid fa-star-half-stroke"></i> Moderación reseñas</a></li>
                        <li><a href="perfilUsuarioView.jsp"><i class="fa-solid fa-user"></i> Mi perfil (cliente)</a></li>
                        <li><a href="misPedidosView.jsp"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
                        <li><a href="loginView.jsp"><i class="fa-solid fa-right-to-bracket"></i> Iniciar sesión</a></li>
                    </ul>
                </nav>
            </aside>
            <div class="main-panel">
                <header class="topbar">
                    <div class="topbar-links">
                        <a href="${pageContext.request.contextPath}/Perfil"><i class="fas fa-user"></i> Perfil</a>
                        <a href="${pageContext.request.contextPath}/Logout"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>
                    </div>
                </header>
                <main class="content">
                    <div class="page-header">
                        <div>
                            <h2>Gestión de usuarios</h2>
                            <p>Activa o desactiva cuentas.</p>
                        </div>
                    </div>

                    <div class="table-wrap">
                        <table class="data-table">
                            <thead>
                                <tr>
                                    <th>Correo</th>
                                    <th>Rol</th>
                                    <th>Teléfono</th>
                                    <th>Estado de cuenta</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>cliente.demo@correo.com</td>
                                    <td>CLIENTE</td>
                                    <td>6441234567</td>
                                    <td><span class="badge-estado badge-activo">Activo</span></td>
                                    <td class="acciones-celda">
                                        <label class="toggle-cuenta">
                                            <input type="checkbox" checked aria-label="Cuenta activa">
                                            <span>Cuenta activa</span>
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>otro.usuario@correo.com</td>
                                    <td>CLIENTE</td>
                                    <td>6449876543</td>
                                    <td><span class="badge-estado badge-inactivo">Inactivo</span></td>
                                    <td class="acciones-celda">
                                        <label class="toggle-cuenta">
                                            <input type="checkbox" aria-label="Cuenta activa">
                                            <span>Cuenta activa</span>
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>admin@tienda.com</td>
                                    <td>ADMIN</td>
                                    <td>6440000000</td>
                                    <td><span class="badge-estado badge-activo">Activo</span></td>
                                    <td class="acciones-celda">
                                        <label class="toggle-cuenta">
                                            <input type="checkbox" checked aria-label="Cuenta activa">
                                            <span>Cuenta activa</span>
                                        </label>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </main>
                <footer class="footer">
                    <p>Aplicaciones Web – Unidad 4</p>
                </footer>
            </div>
        </div>
    </body>
</html>
