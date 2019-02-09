package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "destinatarios")
public class Destinatario implements Comparable<Destinatario>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;

    public Destinatario()
    {
    }

    public Destinatario(String nombre, String direccion)
    {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    
    //<editor-fold desc="GETTERS Y SETTERS:">
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    
    
    //</editor-fold>

    @Override
    public String toString()
    {
        return "Destinatario{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    @Override
    public int compareTo(Destinatario o)
    {
        return 1;
    }
    
    
}
