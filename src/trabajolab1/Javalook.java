package trabajolab1;

/**
 *
 * @author axelr
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Javalook {
    
    private EmailAccount[] cuentas;
    private EmailAccount accountActual = null;
    
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new Javalook().crearGUI();
        });
    }
    
    public void crearGUI() {
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); 
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
   
        crearPanelInicial();
        crearPanelLogin();
        crearPanelRegistro();
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    private void crearPanelInicial(){
        
        JPanel panelInicial = new JPanel();
        panelInicial.setLayout(new GridLayout(4, 1, 10, 10));
        panelInicial.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("SISTEMA DE CORREO", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        
        JButton btnLogin = new JButton("INICIAR SESIÓN");
        JButton btnRegistro = new JButton("CREAR CUENTA");
        JButton btnSalir = new JButton("SALIR");
        
        btnLogin.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        
        btnRegistro.addActionListener(e -> cardLayout.show(mainPanel, "Registro"));
        
        btnSalir.addActionListener(e -> System.exit(0));

        panelInicial.add(titulo);
        panelInicial.add(btnLogin);
        panelInicial.add(btnRegistro);
        panelInicial.add(btnSalir);

        mainPanel.add(panelInicial, "Inicial");
    }
    
    private void crearPanelLogin() {
        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new GridLayout(5, 1, 10, 10));
        panelLogin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("INICIAR SESIÓN", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField txtCorreo = new JTextField();
        JPasswordField txtPassword = new JPasswordField();

        JButton btnIngresar = new JButton("INGRESAR");
        JButton btnVolver = new JButton("VOLVER");

        panelLogin.add(titulo);
        panelLogin.add(new JLabel("Correo:"));
        panelLogin.add(txtCorreo);
        panelLogin.add(new JLabel("Contraseña:"));
        panelLogin.add(txtPassword);
        panelLogin.add(btnIngresar);
        panelLogin.add(btnVolver);


        btnIngresar.addActionListener(e -> {
            String correo = txtCorreo.getText().trim();
            String password = new String(txtPassword.getPassword());

            if (login(correo, password)) {
                JOptionPane.showMessageDialog(frame, "¡Bienvenido " + accountActual.getNombreUsuario() + "!");
                cardLayout.show(mainPanel, "Inicial");
            } else {
                JOptionPane.showMessageDialog(frame, "Correo o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnVolver.addActionListener(e->{
            txtCorreo.setText("");
            txtPassword.setText("");
            cardLayout.show(mainPanel, "Inicial");
        });

        mainPanel.add(panelLogin, "Login");
    }
    
    private boolean login(String correo, String password) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null && cuentas[i].getDireccionEmail().equals(correo) &&  cuentas[i].getPassword().equals(password)){
                accountActual = cuentas[i];
                return true;
            }
        }
        return false;
    }
    
    private void crearPanelRegistro() {
        JPanel panelRegistro = new JPanel();
        panelRegistro.setLayout(new GridLayout(6, 1, 10, 10));
        panelRegistro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("CREAR CUENTA", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField txtCorreo = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JTextField txtNombre = new JTextField();

        JButton btnCrear = new JButton("CREAR CUENTA");
        JButton btnVolver = new JButton("VOLVER");

        panelRegistro.add(titulo);
        panelRegistro.add(new JLabel("Correo:"));
        panelRegistro.add(txtCorreo);
        panelRegistro.add(new JLabel("Contraseña:"));
        panelRegistro.add(txtPassword);
        panelRegistro.add(new JLabel("Nombre:"));
        panelRegistro.add(txtNombre);
        panelRegistro.add(btnCrear);
        panelRegistro.add(btnVolver);

        // Acción del botón Crear
        btnCrear.addActionListener(e -> {
            String correo = txtCorreo.getText().trim();
            String password = new String(txtPassword.getPassword());
            String nombre = txtNombre.getText().trim();

            if (crearCuenta(correo, password, nombre)) {
                JOptionPane.showMessageDialog(frame, "¡Cuenta creada exitosamente!\nBienvenido " + nombre);
                txtCorreo.setText("");
                txtPassword.setText("");
                txtNombre.setText("");
                cardLayout.show(mainPanel, "Inicial");
            }
        });

        // Acción del botón Volver
        btnVolver.addActionListener(e -> {
            txtCorreo.setText("");
            txtPassword.setText("");
            txtNombre.setText("");
            cardLayout.show(mainPanel, "Inicial");
        });

        mainPanel.add(panelRegistro, "Registro");
    }
    
    private boolean crearCuenta(String correo, String password, String nombre) {
       
        if (correo.isEmpty() || password.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null && cuentas[i].getDireccionEmail().equals(correo)) {
                JOptionPane.showMessageDialog(frame, "Este correo ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        //valido la contraseña
        if (!validarPassword(password)) {
            JOptionPane.showMessageDialog(frame, 
                "La contraseña debe tener:\n" +
                "- Mínimo 5 caracteres\n" +
                "- Al menos 1 mayúscula\n" + 
                "- Al menos 1 número\n" +
                "- Al menos 1 símbolo", 
                "Error en contraseña", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //crear y guardar la cuenta
        EmailAccount nuevaCuenta = new EmailAccount(correo, password, nombre);
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = nuevaCuenta;
                accountActual = nuevaCuenta;
                return true;
            }
        }
        JOptionPane.showMessageDialog(frame, "No hay espacio para más cuentas", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        
    }
    
    private boolean validarPassword(String password) {
        if (password.length() < 5) return false;

        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayuscula = true;
            if (Character.isDigit(c)) tieneNumero = true;
            if (!Character.isLetterOrDigit(c)) tieneSimbolo = true;
        }
        return tieneMayuscula && tieneNumero && tieneSimbolo;
    }   
}
