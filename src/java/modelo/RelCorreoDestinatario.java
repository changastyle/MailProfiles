package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "relacionesCorreoDestinatario")
public class RelCorreoDestinatario implements Comparable<RelCorreoDestinatario>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne() @JoinColumn(name = "fkCorreo") @JsonIgnore
    private Correo correo;
    @OneToOne() @JoinColumn(name = "fkDestinatario")
    private Destinatario destinatario;
    
    
    //CONTRUCTOR VACIO:
    public RelCorreoDestinatario() 
    {
    }
    
    //CONTRUCTOR PARAMETROS SIN LISTAS:
    public RelCorreoDestinatario(Correo correo,Destinatario destinatario)
    {
        this.correo = correo;
        this.destinatario = destinatario;
    }


    //<editor-fold desc="GETTERS Y SETTERS:">
    public int getId() 
    {
        return id;
    }
    public Correo getCorreo() 
    {
        return correo;
    }
    public Destinatario getDestinatario() 
    {
        return destinatario;
    }

    //SET
    public void setId( int id ) 
    {
        this.id = id;
    }
    public void setCorreo( Correo correo ) 
    {
        this.correo = correo;
    }
    public void setDestinatario( Destinatario destinatario ) 
    {
        this.destinatario = destinatario;
    }
    //</editor-fold>
    
    //@Override
    public String toString()
    {
        String str = "{";
        str += "id:" + id + ", ";
        str += "correo:" + correo + ", ";
        str += "destinatario:" + destinatario + ", ";
        
        str += "}";
        
        return str;
    }

 
        
    
    //DYN:

    
    public int compareTo(RelCorreoDestinatario otro)
    {
        return 1;
    }
    
}
