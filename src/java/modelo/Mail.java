package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "mails")
public class Mail implements Comparable<Mail>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String aliasRemitente;
    private String asunto;
    @JsonIgnore
    private String passRemitente;
    private String remitente;
    private String urlTemplate;
    
    
    //CONTRUCTOR VACIO:
    public Mail() 
    {
    }
    
    //CONTRUCTOR PARAMETROS SIN LISTAS:
    public Mail(String aliasRemitente,String asunto,String passRemitente,String remitente,String urlTemplate)
    {
        this.aliasRemitente = aliasRemitente;
        this.asunto = asunto;
        this.passRemitente = passRemitente;
        this.remitente = remitente;
        this.urlTemplate = urlTemplate;
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

    
    public int compareTo(Mail otro)
    {
        return 1;
    }
    
}
