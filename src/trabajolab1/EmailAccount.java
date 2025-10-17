package trabajolab1;
import java.util.Calendar;
/**
 *
 * @author axelr
 */

public class EmailAccount {
    String direccionEmail;
    String password;
    String nombreUsuario;
    Email[] inbox= new Email[10];
    int contador=0;
    int sinleer=0;

    public EmailAccount(String direccionEmail, String password, String nombreUsuario) {
        this.direccionEmail = direccionEmail;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccionEmail() {
        return direccionEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public boolean recibirEmail(Email em){
        boolean estado=true;
        for (int i = 0; i < 10; i++) {
            if (inbox[i]!=null){
                estado= false;
            }else{
                inbox[i]=em;
                contador++;
                estado=true;
                i=10;
            }
        }
        return estado;
        
    }
    
    public void printInbox(){
        Calendar cal= Calendar.getInstance();
        System.out.println(cal.getTime());
        for (int i = 0; i < 10; i++) {
            if(inbox[i]!=null){
                System.out.println((i+1)+"."+inbox[i].emisor+" - "+inbox[i].asunto+" - "+inbox[i].leido);
                if (inbox[i].leido==false) {
                    sinleer++;
                }
            }
        }
        System.out.println("Correos totales: "+contador);
        System.out.println("Correos sin leer: "+sinleer);
    }
    
    public void leerEmail(int pos){
        if(inbox[pos]!=null){
            System.out.println(inbox[pos].emisor+" - "+inbox[pos].asunto+" - "+inbox[pos].leido);
            inbox[pos].leido();
        }else{
            System.out.println("Correo no existe.");
        }
        
    }
}
