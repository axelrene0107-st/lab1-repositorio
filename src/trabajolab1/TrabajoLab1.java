/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
        
        Email e1 = new Email("gabriez@gamil.com","Prueba","Probando main");
        e1.isLeido();
        System.out.println(e1.isLeido());
        
        e1.leido();
        System.out.println(e1.isLeido());
        
        e1.print();
        
              
    }
    
}
