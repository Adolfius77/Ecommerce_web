<%-- Gestión de categorías del catálogo (vista administrador) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administración - Categorías</title>
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
                    <li><a href="gestionCategoriasView.jsp" class="active"><i class="fa-solid fa-tags"></i> Categorías</a></li>
                    <li><a href="gestionUsuariosView.jsp"><i class="fa-solid fa-users"></i> Usuarios</a></li>
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
                    <a href="perfilUsuarioView.jsp"><i class="fas fa-user"></i> Perfil</a>
                    <a href="loginView.jsp"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>
                </div>
            </header>
            <main class="content">
                <div class="page-header">
                    <div>
                        <h2>Gestión de categorías</h2>
                        <p>Organiza el catálogo. </p>
                    </div>
                    <div class="toolbar">
                        <button type="button" class="btn-primario"><i class="fa-solid fa-plus"></i> Nueva categoría</button>
                    </div>
                </div>

                <div class="panel-card">
                    <h3>Nueva o editar categoría</h3>
                    <div class="form-grid-panel">
                        <div class="campo-form-panel">
                            <label for="catNombre">Nombre</label>
                            <input type="text" id="catNombre" name="catNombre" placeholder="Nombre de la categoría">
                        </div>
                        <div class="campo-form-panel campo-form-panel-full">
                            <label for="catDesc">Descripción (opcional)</label>
                            <textarea id="catDesc" name="catDesc" placeholder="Descripción breve"></textarea>
                        </div>
                    </div>
                    <div class="toolbar" style="margin-top:18px;">
                        <button type="button" class="btn-primario">Guardar categoría</button>
                        <button type="button" class="btn-secundario">Cancelar</button>
                    </div>
                </div>

                <div class="table-wrap">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Descripción</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Tecnología</td>
                                <td>Dispositivos electrónicos y accesorios</td>
                                <td class="acciones-celda">
                                    <button type="button" class="btn-icono" title="Editar"><i class="fa-solid fa-pen"></i></button>
                                    <button type="button" class="btn-peligro" title="Eliminar"><i class="fa-solid fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>Hogar</td>
                                <td>Artículos para el hogar</td>
                                <td class="acciones-celda">
                                    <button type="button" class="btn-icono" title="Editar"><i class="fa-solid fa-pen"></i></button>
                                    <button type="button" class="btn-peligro" title="Eliminar"><i class="fa-solid fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>Moda</td>
                                <td>Ropa y complementos</td>
                                <td class="acciones-celda">
                                    <button type="button" class="btn-icono" title="Editar"><i class="fa-solid fa-pen"></i></button>
                                    <button type="button" class="btn-peligro" title="Eliminar"><i class="fa-solid fa-trash"></i></button>
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
