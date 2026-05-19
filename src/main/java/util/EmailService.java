package util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Servicio para enviar emails
 */
public class EmailService {
    
    private static final String SENDER_EMAIL = System.getenv("SENDER_EMAIL");
    private static final String SENDER_PASSWORD = System.getenv("SENDER_PASSWORD");
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    
    private Session session;
    
    public EmailService() {
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.connectiontimeout", "5000");
        props.put("mail.smtp.timeout", "5000");
        props.put("mail.smtp.writetimeout", "5000");
        
        this.session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD);
            }
        });
    }
    
    public void enviarConfirmacionPedido(String destinatario, String nombreCliente, String numeroPedido, 
                                        Double total) throws MessagingException {
        String asunto = "Confirmación de Pedido - " + numeroPedido;
        
        String cuerpo = "<html><body>" +
                "<h2>¡Gracias por tu pedido!</h2>" +
                "<p>Hola " + nombreCliente + ",</p>" +
                "<p>Tu pedido ha sido confirmado exitosamente.</p>" +
                "<p><strong>Número de Pedido:</strong> " + numeroPedido + "</p>" +
                "<p><strong>Total:</strong> $" + String.format("%.2f", total) + "</p>" +
                "<p>Puedes consultar el estado de tu pedido en tu cuenta en nuestra plataforma.</p>" +
                "<p>Gracias por confiar en nosotros.</p>" +
                "<p>Saludos,<br/>El equipo de E-Commerce</p>" +
                "</body></html>";
        
        enviarEmail(destinatario, asunto, cuerpo, true);
    }
    
    public void enviarEmail(String destinatario, String asunto, String cuerpo, boolean esHTML) 
            throws MessagingException {
        if (SENDER_EMAIL == null || SENDER_PASSWORD == null) {
            throw new MessagingException("Las credenciales de email no están configuradas");
        }
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(SENDER_EMAIL));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject(asunto);
        
        if (esHTML) {
            message.setContent(cuerpo, "text/html; charset=utf-8");
        } else {
            message.setText(cuerpo);
        }
        
        Transport.send(message);
    }
}
