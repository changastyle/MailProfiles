package ws;
import com.google.gson.Gson;
import controlador.MasterController;
import java.util.*;
import mailsUtils.MailManager;
import mailsUtils.ParametroMail;
import modelo.*;
import modelo.Correo;
import org.springframework.web.bind.annotation.*;

@RestController
public class wsCorreos
{
    @RequestMapping(value = "test")
    public void test()
    {
        
        // 1 - TRAER EL TIPO DE CORREO DE DB:
        Correo mailDB = dameCorreoPorNombre("prueba");
        
        // 2 - LISTADO DE PARAMETROS NECESARIOS PARA EL CUERPO:
        List<ParametroMail> parametrosList = new ArrayList<>();
        
        parametrosList.add(new ParametroMail("titulo", "Tienes una nueva reserva - (" ));
        parametrosList.add(new ParametroMail("subtitulo","Querido "));
        parametrosList.add(new ParametroMail("finSubtitulo"," te ganaste una pataada en el orto! "));
        parametrosList.add(new ParametroMail("horario", "Consulta realizada:"));
        parametrosList.add(new ParametroMail("usuario", "Roberto"));
        parametrosList.add(new ParametroMail("hora", MasterController.formatearFechaAAlgoBonito(new Date(), true) + ") "));
        parametrosList.add(new ParametroMail("foto", "https://o.aolcdn.com/images/dims3/GLOB/legacy_thumbnail/630x315/format/jpg/quality/85/http%3A%2F%2Fi.huffpost.com%2Fgen%2F2714370%2Fimages%2Fn-POOP-EMOJI-ICE-CREAM-628x314.jpg"));
        parametrosList.add(new ParametroMail("enlaceFoto", "https://web.whatsapp.com/"));
       
        // 3 - METER ETIQUETAS ANGULAR EN ARCHIVO HTML:
        MailManager mailManager = new MailManager(mailDB.getRemitente(), mailDB.getPassRemitente());
        
        // 4 - ENVIAR EMAIL:
        mailManager.enviarEmail(mailDB, parametrosList);
        
    }
    @RequestMapping(value = "findCorreos")
    public static List<Correo> findCorreos()
    {
        List<Correo> mailsList = new ArrayList<Correo>();
        
        String jpql = "SELECT c FROM Correo c";
        mailsList = dao.DAOEclipse.findAllByJPQL(jpql);
        
        Collections.sort(mailsList);
        
        return mailsList;
    }
    
    @RequestMapping(value = "getMail")
    public static Correo getMail(@RequestParam(value = "idMail" , defaultValue = "-1") int idMail)
    {
        Correo mailDB = null;
        
        if(idMail != -1)
        {
            mailDB = (Correo) dao.DAOEclipse.get(Correo.class, idMail);
        }
        
        return mailDB;
    }
    @RequestMapping(value = "dameCorreoPorNombre")
    public static Correo dameCorreoPorNombre
    (
        @RequestParam(value = "nombre") String nombre
    )
    {
        Correo correoDB = null;
        
        String jpql = "SELECT c FROM Correo c WHERE LOWER(c.nombre) = LOWER(\"" +  nombre + "\")";
        
        if(nombre != null)
        {
            correoDB = (Correo) dao.DAOEclipse.getByJPQL(jpql);
        }
        
        return correoDB;
    }
}
