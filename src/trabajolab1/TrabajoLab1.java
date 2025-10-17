
package trabajolab1;

/**
 *
 * @author axelr
 */
public class TrabajoLab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int leidos;
        Email us1= new Email("Axel Mancia", "Nos quedamos sin agua", "Ayuda, no hay agua desde ayer.");
        EmailAccount com= new EmailAccount("axel@unitc.edu", "tcherry", "Axel");
        
        System.out.println(com.recibirEmail(us1));
        us1.leido();
        
        com.printInbox();
        
        com.leerEmail(1);
    }
    
}
