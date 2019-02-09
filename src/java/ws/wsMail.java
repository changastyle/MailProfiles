package ws;
import com.google.gson.Gson;
import controlador.MasterController;
import java.util.*;
import mailsUtils.MailManager;
import mailsUtils.ParametroMail;
import modelo.*;
import modelo.Mail;
import org.springframework.web.bind.annotation.*;

@RestController
public class wsMail
{
    @RequestMapping(value = "findMails")
    public static List<Mail> findMails()
    {
        List<Mail> mailsList = new ArrayList<Mail>();
        
        String jpql = "SELECT m FROM Mail m";
        mailsList = dao.DAOEclipse.findAllByJPQL(jpql);
        
        Collections.sort(mailsList);
        
        return mailsList;
    }
    
    @RequestMapping(value = "guardarMail")
    public static boolean guardarMail(@RequestParam(value = "strMail" , defaultValue = "") String strMail)
    {
        boolean guarde = false;
        boolean modoEdit = false;
        
        Mail mailDB = null;
        if(strMail != null)
        {
            try
            {
                Mail mailRecibido = new Gson().fromJson(strMail, Mail.class);
                
                if(mailRecibido != null)
                {
                    // MODO EDIT:
                    if(mailRecibido.getId() != -1)
                    {
                        mailDB = (Mail) dao.DAOEclipse.get(Mail.class, mailRecibido.getId());
                        
                        if(mailDB != null)
                        {
                            // 0 - ACTUALIZO VALORES DEL OBJ.DB CON LOS DEL OBJ.RECIBIDOS:
                            mailDB.setUrlTemplate(mailRecibido.getUrlTemplate());
                            mailDB.setRemitente(mailRecibido.getRemitente());
                            mailDB.setAliasRemitente(mailRecibido.getAliasRemitente());
                            mailDB.setPassRemitente(mailRecibido.getPassRemitente());
                            mailDB.setAsunto(mailRecibido.getAsunto());
                            {
                                guarde = dao.DAOEclipse.update(mailDB);
                            }
                        }
                    }
                    else
                    {
                        // 3 - MODO ADD:
                        
                        guarde = dao.DAOEclipse.update(mailRecibido);
                        
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        
        return guarde;
    }
    
    @RequestMapping(value = "getMail")
    public static Mail getMail(@RequestParam(value = "idMail" , defaultValue = "-1") int idMail)
    {
        Mail mailDB = null;
        
        if(idMail != -1)
        {
            mailDB = (Mail) dao.DAOEclipse.get(Mail.class, idMail);
        }
        
        return mailDB;
    }
    @RequestMapping(value = "getMailEmpty")
    public Mail getMailEmpty()
    {
       Mail mailEmpty = new Mail();
       mailEmpty.setId(-1);
       return mailEmpty;
    }
    @RequestMapping(value = "test")
    public void test()
    {
        Mail mailDB = (Mail) dao.DAOEclipse.get(Mail.class, 1);
        
        // ENVIAR EMAIL:
        List<String> destinatarios = new ArrayList<>();
        destinatarios.add("nico.grossi4@gmail.com");

        // 3 - CONVERTIME EL ARCHIVO HTML CON ETIQUETAS ANGULAR CON LOS VALORES QUE YO NECESITO:
        List<ParametroMail> parametrosMailList = new ArrayList<>();

        List<ParametroMail> parametrosList = new ArrayList<>();
        parametrosList.add(new ParametroMail("titulo", "Tienes una nueva reserva - (" ));
        parametrosList.add(new ParametroMail("subtitulo","Querido "));
        parametrosList.add(new ParametroMail("finSubtitulo"," te ganaste una pataada en el orto! "));
        parametrosList.add(new ParametroMail("horario", "Consulta realizada:"));
        parametrosList.add(new ParametroMail("usuario", "Roberto"));
        parametrosList.add(new ParametroMail("hora", MasterController.formatearFechaAAlgoBonito(new Date(), true) + ") "));
        parametrosList.add(new ParametroMail("foto", "https://o.aolcdn.com/images/dims3/GLOB/legacy_thumbnail/630x315/format/jpg/quality/85/http%3A%2F%2Fi.huffpost.com%2Fgen%2F2714370%2Fimages%2Fn-POOP-EMOJI-ICE-CREAM-628x314.jpg"));
        parametrosList.add(new ParametroMail("enlaceFoto", "https://web.whatsapp.com/"));
       
        MailManager mailManager = new MailManager(mailDB.getRemitente(), mailDB.getPassRemitente());
        mailManager.enviarEmail(mailDB, destinatarios, parametrosList);
    }
}
