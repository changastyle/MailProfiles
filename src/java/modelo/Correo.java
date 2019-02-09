package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "correos")
public class Correo implements Comparable<Correo>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String aliasRemitente;
    private String asunto;
    @JsonIgnore
    private String passRemitente;
    private String remitente;
    private String urlTemplate;
    @OneToMany(mappedBy = "correo")
    private List<RelCorreoDestinatario> relDestinatariosList;
    
    
    
    //CONTRUCTOR VACIO:
    public Correo() 
    {
        relDestinatariosList = new ArrayList<>();
    }
    
    //CONTRUCTOR PARAMETROS SIN LISTAS:
    public Correo(String aliasRemitente,String asunto,String passRemitente,String remitente,String urlTemplate)
    {
        this.aliasRemitente = aliasRemitente;
        this.asunto = asunto;
        this.passRemitente = passRemitente;
        this.remitente = remitente;
        this.urlTemplate = urlTemplate;
        
        
        relDestinatariosList = new ArrayList<>();
    }


    //<editor-fold desc="GETTERS Y SETTERS:">
    public int getId() 
    {
        return id;
    }
    public String getAliasRemitente() 
    {
        return aliasRemitente;
    }
    public String getAsunto() 
    {
        return asunto;
    }
    public String getPassRemitente() 
    {
        return passRemitente;
    }
    public String getRemitente() 
    {
        return remitente;
    }
    public String getUrlTemplate() 
    {
        return urlTemplate;
    }

    public String getNombre()
    {
        return nombre;
    }

    public List<RelCorreoDestinatario> getRelDestinatariosList()
    {
        return relDestinatariosList;
    }

    public void setRelDestinatariosList(List<RelCorreoDestinatario> relDestinatariosList)
    {
        this.relDestinatariosList = relDestinatariosList;
    }
    
    

    //SET
    public void setId( int id ) 
    {
        this.id = id;
    }
    public void setAliasRemitente( String aliasRemitente ) 
    {
        this.aliasRemitente = aliasRemitente;
    }
    public void setAsunto( String asunto ) 
    {
        this.asunto = asunto;
    }
    public void setPassRemitente( String passRemitente ) 
    {
        this.passRemitente = passRemitente;
    }
    public void setRemitente( String remitente ) 
    {
        this.remitente = remitente;
    }
    public void setUrlTemplate( String urlTemplate ) 
    {
        this.urlTemplate = urlTemplate;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    
    //</editor-fold>
    
    //@Override
    public String toString()
    {
        String str = "{";
        str += "id:" + id + ", ";
        str += "aliasRemitente:" + aliasRemitente + ", ";
        str += "asunto:" + asunto + ", ";
        str += "passRemitente:" + passRemitente + ", ";
        str += "remitente:" + remitente + ", ";
        str += "urlTemplate:" + urlTemplate + ", ";
        
        str += "}";
        
        return str;
    }

 
        
    
    //DYN:

    
    public int compareTo(Correo otro)
    {
        return 1;
    }
    public List<String> dameListadoEnStringDeLosDestinatarios()
    {
        List<String> arrStr = new ArrayList<String>();
        
        for(RelCorreoDestinatario relLoop : relDestinatariosList)
        {
            arrStr.add(relLoop.getDestinatario().getDireccion());
        }
        
        return arrStr;
    }
    
}
