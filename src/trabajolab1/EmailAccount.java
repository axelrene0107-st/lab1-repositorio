package trabajolab1;

/**
 *
 * @author axelr
 */

public class EmailAccount {
    String direccionEmail;
    String password;
    String nombreUsuario;
    Email[] inbox= new Email[10];

    public EmailAccount(String direccionEmail, String password, String nombreUsuario) {
        this.direccionEmail = direccionEmail;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        inbox[]=null;
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
    
    public static boolean recibirEmail(Email em){
        
    }
    
}
