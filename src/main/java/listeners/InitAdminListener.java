package listeners;

import Config.MongoClientProvider;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.Usuario;
import org.bson.types.ObjectId;

/**
 * Listener que se ejecuta al iniciar la aplicación e inserta un usuario ADMIN por defecto
 */
@WebListener
public class InitAdminListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            MongoCollection<Usuario> usuarioCollection = MongoClientProvider.INSTANCE.getcCollection("usuario", Usuario.class);
            
            // Verificar si ya existe un admin
            long adminCount = usuarioCollection.countDocuments(
                Filters.eq("rol", "ADMIN")
            );
            
            if (adminCount == 0) {
                System.out.println("[INIT] No se encontro usuario ADMIN. Creando usuario por defecto...");
                
                // crea al usuario admin
                Usuario admin = new Usuario();
                admin.setId(new ObjectId());
                admin.setNombre("Administrador");
                admin.setApellido("Sistema");
                admin.setCorreo("admin@tienda.com");
                
                //aqui se crea la contra angel
                String passwordPlain = "admin123";
                String passwordHash = BCrypt.withDefaults().hashToString(12, passwordPlain.toCharArray());
                admin.setContrasena(passwordHash);
                
                admin.setTelefono("0000000000");
                admin.setDireccion("Sistema Administrativo");
                admin.setRol("ADMIN");
                admin.setActivo(true);
                
                usuarioCollection.insertOne(admin);
                
                System.out.println("[INIT] Usuario ADMIN creado exitosamente");
                System.out.println("[INIT] Email: admin@tienda.com");
                System.out.println("[INIT] Contraseña: admin123");
                System.out.println("[INIT] CAMBIAR CONTRASEÑA EN PRODUCCION");
            } else {
                System.out.println("[INIT] Usuario ADMIN ya existe. Inicialización saltada.");
            }
            
        } catch (Exception e) {
            System.err.println("[INIT ERROR] Error al inicializar admin: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
     
    }
}
