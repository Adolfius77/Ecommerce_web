<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel Administrativo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <style>
        :root {
            --primary-color: #2c3e50;
            --secondary-color: #3498db;
            --danger-color: #e74c3c;
            --success-color: #27ae60;
        }
        
        body {
            background: linear-gradient(135deg, var(--primary-color) 0%, #34495e 100%);
            min-height: 100vh;
            padding: 20px 0;
        }
        
        .navbar {
            background-color: var(--primary-color);
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        
        .navbar-brand {
            font-weight: bold;
            font-size: 1.5rem;
            color: white !important;
        }
        
        .admin-title {
            color: white;
            text-align: center;
            margin: 40px 0 30px;
            font-size: 2.5rem;
            font-weight: bold;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
        }
        
        .admin-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 25px;
            max-width: 1200px;
            margin: 0 auto 40px;
            padding: 0 20px;
        }
        
        .admin-card {
            background: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
            transition: all 0.3s ease;
            cursor: pointer;
            text-decoration: none;
            color: inherit;
            display: flex;
            flex-direction: column;
        }
        
        .admin-card:hover {
            transform: translateY(-8px);
            box-shadow: 0 12px 30px rgba(0, 0, 0, 0.25);
        }
        
        .admin-card-header {
            padding: 25px;
            color: white;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        
        .admin-card-icon {
            font-size: 2.5rem;
            opacity: 0.9;
        }
        
        .admin-card-body {
            padding: 20px 25px;
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }
        
        .admin-card-title {
            font-size: 1.3rem;
            font-weight: bold;
            margin-bottom: 10px;
            color: var(--primary-color);
        }
        
        .admin-card-description {
            color: #7f8c8d;
            font-size: 0.95rem;
            margin-bottom: 15px;
            flex: 1;
        }
        
        .admin-card-button {
            display: inline-block;
            background: linear-gradient(135deg, var(--secondary-color) 0%, #2980b9 100%);
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            text-align: center;
            font-weight: 600;
            transition: all 0.3s ease;
        }
        
        .admin-card-button:hover {
            background: linear-gradient(135deg, #2980b9 0%, #1f618d 100%);
            color: white;
            transform: scale(1.05);
        }
        
        /* Color schemes for different card types */
        .card-usuarios .admin-card-header {
            background: linear-gradient(135deg, #9b59b6 0%, #8e44ad 100%);
        }
        
        .card-productos .admin-card-header {
            background: linear-gradient(135deg, #e74c3c 0%, #c0392b 100%);
        }
        
        .card-categorias .admin-card-header {
            background: linear-gradient(135deg, #f39c12 0%, #d68910 100%);
        }
        
        .card-pedidos .admin-card-header {
            background: linear-gradient(135deg, #27ae60 0%, #1e8449 100%);
        }
        
        .card-pagos .admin-card-header {
            background: linear-gradient(135deg, #16a085 0%, #117a65 100%);
        }
        
        .card-resenas .admin-card-header {
            background: linear-gradient(135deg, #3498db 0%, #2980b9 100%);
        }
        
        .logout-section {
            text-align: center;
            margin: 40px 0;
        }
        
        .btn-logout {
            background: linear-gradient(135deg, var(--danger-color) 0%, #c0392b 100%);
            color: white;
            padding: 12px 40px;
            font-weight: bold;
            font-size: 1rem;
            border-radius: 5px;
            text-decoration: none;
            transition: all 0.3s ease;
            display: inline-block;
        }
        
        .btn-logout:hover {
            background: linear-gradient(135deg, #c0392b 0%, #a93226 100%);
            color: white;
            transform: scale(1.05);
        }
        
        .stats-section {
            background: white;
            border-radius: 10px;
            padding: 30px;
            margin-bottom: 40px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
            max-width: 1200px;
            margin-left: auto;
            margin-right: auto;
        }
        
        .stats-title {
            color: var(--primary-color);
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
        }
        
        .welcome-section {
            color: white;
            text-align: center;
            margin-bottom: 20px;
            font-size: 1.1rem;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <span class="navbar-brand">
                <i class="fas fa-crown"></i> Panel Administrativo
            </span>
            <div class="ms-auto text-white">
                <span class="me-3">
                    <i class="fas fa-user"></i> ${sessionScope.usuario}
                </span>
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger btn-sm">
                    <i class="fas fa-sign-out-alt"></i> Cerrar Sesión
                </a>
            </div>
        </div>
    </nav>

    <!-- Welcome Message -->
    <div class="welcome-section">
        <h2>¡Bienvenido, Administrador!</h2>
        <p>Selecciona una opción para gestionar la plataforma</p>
    </div>

    <!-- Admin Cards Grid -->
    <div class="admin-grid">
        
        <!-- Gestión de Usuarios -->
        <a href="${pageContext.request.contextPath}/admin/gestionUsuarios" class="admin-card card-usuarios">
            <div class="admin-card-header">
                <div>
                    <h3 style="margin: 0; font-size: 1.2rem;">Usuarios</h3>
                </div>
                <div class="admin-card-icon">
                    <i class="fas fa-users"></i>
                </div>
            </div>
            <div class="admin-card-body">
                <div class="admin-card-title">Gestión de Usuarios</div>
                <div class="admin-card-description">
                    Administra cuentas de usuarios, cambia roles (CLIENTE/ADMIN), activa/desactiva cuentas.
                </div>
                <span class="admin-card-button">Ir a Usuarios</span>
            </div>
        </a>

        <!-- Gestión de Productos -->
        <a href="${pageContext.request.contextPath}/admin/gestionProductos" class="admin-card card-productos">
            <div class="admin-card-header">
                <div>
                    <h3 style="margin: 0; font-size: 1.2rem;">Productos</h3>
                </div>
                <div class="admin-card-icon">
                    <i class="fas fa-box"></i>
                </div>
            </div>
            <div class="admin-card-body">
                <div class="admin-card-title">Gestión de Productos</div>
                <div class="admin-card-description">
                    Crea, edita y elimina productos. Manage imágenes, precios, disponibilidad.
                </div>
                <span class="admin-card-button">Ir a Productos</span>
            </div>
        </a>

        <!-- Gestión de Categorías -->
        <a href="${pageContext.request.contextPath}/admin/gestionCategorias" class="admin-card card-categorias">
            <div class="admin-card-header">
                <div>
                    <h3 style="margin: 0; font-size: 1.2rem;">Categorías</h3>
                </div>
                <div class="admin-card-icon">
                    <i class="fas fa-tags"></i>
                </div>
            </div>
            <div class="admin-card-body">
                <div class="admin-card-title">Gestión de Categorías</div>
                <div class="admin-card-description">
                    Organiza los productos en categorías. Crea, edita y elimina categorías según sea necesario.
                </div>
                <span class="admin-card-button">Ir a Categorías</span>
            </div>
        </a>

        <!-- Gestión de Pedidos -->
        <a href="${pageContext.request.contextPath}/admin/gestionPedidos" class="admin-card card-pedidos">
            <div class="admin-card-header">
                <div>
                    <h3 style="margin: 0; font-size: 1.2rem;">Pedidos</h3>
                </div>
                <div class="admin-card-icon">
                    <i class="fas fa-shopping-cart"></i>
                </div>
            </div>
            <div class="admin-card-body">
                <div class="admin-card-title">Gestión de Pedidos</div>
                <div class="admin-card-description">
                    Visualiza todos los pedidos, actualiza estados (pendiente, enviado, entregado).
                </div>
                <span class="admin-card-button">Ir a Pedidos</span>
            </div>
        </a>

        <!-- Gestión de Pagos -->
        <a href="${pageContext.request.contextPath}/admin/gestionPedidos" class="admin-card card-pagos">
            <div class="admin-card-header">
                <div>
                    <h3 style="margin: 0; font-size: 1.2rem;">Pagos</h3>
                </div>
                <div class="admin-card-icon">
                    <i class="fas fa-credit-card"></i>
                </div>
            </div>
            <div class="admin-card-body">
                <div class="admin-card-title">Historial de Pagos</div>
                <div class="admin-card-description">
                    Revisa el historial de transacciones, métodos de pago utilizados y montos.
                </div>
                <span class="admin-card-button">Ir a Pagos</span>
            </div>
        </a>

        <!-- Moderación de Reseñas -->
        <a href="${pageContext.request.contextPath}/admin/moderacionResenas" class="admin-card card-resenas">
            <div class="admin-card-header">
                <div>
                    <h3 style="margin: 0; font-size: 1.2rem;">Reseñas</h3>
                </div>
                <div class="admin-card-icon">
                    <i class="fas fa-star"></i>
                </div>
            </div>
            <div class="admin-card-body">
                <div class="admin-card-title">Moderación de Reseñas</div>
                <div class="admin-card-description">
                    Aprueba o rechaza reseñas y comentarios de usuarios. Elimina contenido inapropiado.
                </div>
                <span class="admin-card-button">Ir a Reseñas</span>
            </div>
        </a>

    </div>

    <!-- Logout Section -->
    <div class="logout-section">
        <a href="${pageContext.request.contextPath}/logout" class="btn-logout">
            <i class="fas fa-sign-out-alt"></i> Cerrar Sesión
        </a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
