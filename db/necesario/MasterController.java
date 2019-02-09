package controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MasterController
{
	public static String generarCodigoAleatorio()
    {
        String salida = "";
        
        for(int i = 0 ;  i < 4 ; i ++)
        {
            int numeroRandom = (int) ((Math.random() * 10));
            salida += numeroRandom;
        }
        
        return salida;
    }
    public static String formatearFechaAAlgoBonito(Date fecha, boolean ponerHoras)
    {
        Date hoy = new Date();

        String fechaFormateada = "";

        int dia = fecha.getDate();
        int mes = fecha.getMonth() + 1 ;
        int year = fecha.getYear() + 1900;
        int hora = fecha.getHours();
        int minutos = fecha.getMinutes();

        String strDia;
        String strDiaSemana = "";
        String strMes;
        String strYear;
        String strH;
        String strM;


        //DIA:
        if(dia < 10)
        {
            strDia = "0" + dia;
        }
        else
        {
            strDia = "" + dia;
        }

        //MES:
        if(mes < 10)
        {
            strMes = "0" + mes;
        }
        else
        {
            strMes = "" + mes;
        }

        //YEAR:
        strYear = "" + year;

        //HORA:
        if(hora < 10)
        {
            strH = "0" + hora;
        }
        else
        {
            strH = "" + hora;
        }

        //MINUTOS:
        if(minutos < 10)
        {
            strM = "0" + minutos;
        }
        else
        {
            strM = "" + minutos;
        }
       
        strDiaSemana = resuelveDiaDeLaSemana(fecha.getDay());

        
        if(dia == hoy.getDate() && (mes == hoy.getMonth() + 1))
        {
            if(ponerHoras)
            {
                fechaFormateada = strH + ":" + strM + " hs";
            }
            else
            {
                fechaFormateada = "Hoy";
            }
        }
        else if((mes == hoy.getMonth() + 1))
        {
            if(ponerHoras)
            {
                fechaFormateada = strDiaSemana + " " +  strDia + " (" + strH + ":" + strM + " hs)";
            }
            else
            {
                fechaFormateada = strDiaSemana + " " +  strDia;
            }
        }
        else
        {
            if(ponerHoras)
            {
                fechaFormateada =  strDia + "/" + strMes + "/" + strYear + " (" + strH + ":" + strM +" hs)";
            }
            else
            {
                fechaFormateada =  strDia + "/" + strMes + "/" + strYear;
            }
        }


        return  fechaFormateada;
    }
    public static String resuelveDiaDeLaSemana(int dia)
    {
        String strDiaSemana = "";
        switch (dia)
        {
            case 0: strDiaSemana = "Dom"; break;
            case 1: strDiaSemana = "Lun"; break;
            case 2: strDiaSemana = "Mar"; break;
            case 3: strDiaSemana = "Mie"; break;
            case 4: strDiaSemana = "Jue"; break;
            case 5: strDiaSemana = "Vie"; break;
            case 6: strDiaSemana = "Sab"; break;

        }
        return strDiaSemana;
    }
    public static String resuelveStrMes(int mes)
    {
        String strMes = "";
        switch (mes)
        {
            case 1: strMes = "Enero"; break;
            case 2: strMes = "Febrero"; break;
            case 3: strMes = "Marzo"; break;
            case 4: strMes = "Abril"; break;
            case 5: strMes = "Mayo"; break;
            case 6: strMes = "Junio"; break;
            case 7: strMes = "Julio"; break;
            case 8: strMes = "Agosto"; break;
            case 9: strMes = "Septiembre"; break;
            case 10: strMes = "Octubre"; break;
            case 11: strMes = "Noviembre"; break;
            case 12: strMes = "Diciembre"; break;

        }
        return strMes;
    }
    

}
