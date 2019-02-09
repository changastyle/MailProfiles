package mailsUtils;

import controlador.MasterController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import modelo.Mail;

public class MailManager 
{
    /*private String usuarioRemitenteEmail = "viewdevscompany@gmail.com";
    private String passRemitenteEmail = "d3sc4rg4r";
    private String aliasRemitente = "View Devs Company";
    */
    Session session = null;
    private static Message mensajeListo;
    
    public MailManager(String usuarioRemitenteEmail , String passRemitente) 
    {
        if (session == null) 
        {
            inicializarParametros(usuarioRemitenteEmail , passRemitente);
        }
    }

    public  Message inicializarParametros(String usuarioRemitenteEmail , String passRemitente) 
    {
        Message mensajePreparado = null;
        
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
            new javax.mail.Authenticator() 
            {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(usuarioRemitenteEmail, passRemitente);
                }
            });

            mensajePreparado = new MimeMessage(session);
            mensajeListo = mensajePreparado;
                //mensajeListo.setFrom(new InternetAddress(usuario, alias));
                //message.setFrom(new InternetAddress("from-email@gmail.com"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return mensajePreparado;
    }

    public void sendMail(String usuarioRemitenteEmail , String passRemitente, String aliasRemitente, String asunto, String cuerpo , List<String> destinatarios ) 
    {
        if (session == null) 
        {
            inicializarParametros(usuarioRemitenteEmail , passRemitente);
        }
        try 
        {
            if(mensajeListo == null)
            {
                mensajeListo = inicializarParametros(usuarioRemitenteEmail , passRemitente);
            }
            //ensajeListo.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nico.grossi4@gmail.com"));


            mensajeListo.setSubject(asunto + " " + MasterController.formatearFechaAAlgoBonito(new Date(), true));

            mensajeListo.setContent(cuerpo, "text/html; charset=utf-8");
           // mensajeListo.setText("Dear Mail Crawler, No spam to my email, please!");

            Address[] destinatariosConAddress = new Address[destinatarios.size()];
            
            int i = 0;
            for(String destinatarioLoop : destinatarios)
            {
                destinatariosConAddress[i] = new InternetAddress(destinatarioLoop);
                i++;
            }

            mensajeListo.setRecipients(Message.RecipientType.TO,destinatariosConAddress);
            mensajeListo.setFrom(new InternetAddress(usuarioRemitenteEmail, aliasRemitente));

            Multipart multipart = new MimeMultipart();
            MimeBodyPart attachPart = new MimeBodyPart();

            Transport.send(mensajeListo);

            System.out.println("EMAIL ENVIADO CON EXITO!");

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.out.println("EMAIL NO ENVIADO");
        }
    }
    public static void enviarEmail
    (
        Mail mail,
        List<String> arrDestinatarios,
        List<ParametroMail> arrParametros
    )
    {
       // 5 - GENERO UN HTML POPULADO CON ESTA INFORMACION:
       List<String> htmlSinValoresList = HtmlParserForMails.testHTMLAutocompletar(mail.getUrlTemplate(), arrParametros);
       String htmlFinal = HtmlParserForMails.dameHtmlAsStringFromList(htmlSinValoresList);

       // 6 - FINALMENTE ENVIO EL MAIL:
       System.out.println("ENVIO EL MAIL!!");
       MailManager mailManager = new MailManager(mail.getRemitente() , mail.getPassRemitente() );
       mailManager.sendMail(mail.getRemitente(), mail.getPassRemitente(), mail.getAliasRemitente(), mail.getAsunto(), htmlFinal, arrDestinatarios);
    }

}
