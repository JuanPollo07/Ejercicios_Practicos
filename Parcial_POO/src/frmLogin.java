import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class frmLogin extends JFrame {
    public frmLogin() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(lblTitulo, gbc);


        gbc.gridy++;
        gbc.gridwidth = 1;
        JTextField txtUsuario = new JTextField(20);
        JLabel lblUsuario = new JLabel("Usuario:");
        panelPrincipal.add(lblUsuario, gbc);

        gbc.gridx++;
        panelPrincipal.add(txtUsuario, gbc);


        gbc.gridy++;
        gbc.gridx = 0;
        JPasswordField txtContraseña = new JPasswordField(20);
        JLabel lblContraseña = new JLabel("Contraseña:");
        panelPrincipal.add(lblContraseña, gbc);

        gbc.gridx++;
        panelPrincipal.add(txtContraseña, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contraseña = new String(txtContraseña.getPassword());
                Login login = new Login();
                try {
                    if (login.validarInicioSesion(usuario, contraseña)) {
                        dispose();
                        new frmInicio();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo de usuarios");
                }
            }
        });
        panelPrincipal.add(btnIniciarSesion, gbc);

        getContentPane().add(panelPrincipal);
        setVisible(true);
    }

    public static void main(String[] args) {
        Estudiante.cargarEstudiantes();
        SwingUtilities.invokeLater(() -> new frmLogin());
    }
}
