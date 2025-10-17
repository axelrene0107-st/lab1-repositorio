/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajolab1;

/**
 *
 * @author Gabriel
 */
import java.util.Calendar;
public class Email {
    
    public String emisor;
    public String asunto;
    public String contenido;
    public boolean leido;
    public Calendar fechaEnvio;

    public Email(String emisor, String asunto, String contenido) {
        this.emisor = emisor;
        this.asunto = asunto;
        this.contenido = contenido;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public boolean isLeido() {
        return leido;
    }

    public Calendar getFechaEnvio() {
        return fechaEnvio;
    }
    
    public void leido(){
        leido=true;
        
    }
    
    public void print(){
        fechaEnvio = Calendar.getInstance();
        System.out.println("DE: "+emisor);
        System.out.println("ASUNTO: "+asunto);
        System.out.println("CONTENIDO: "+contenido);
        System.out.println("FECHA: "+fechaEnvio.getTime());
        if(leido=true)
            System.out.println("ESTADO: LEIDO");
        else
            System.out.println("ESTADO: SIN LEER");
        
    }
}
