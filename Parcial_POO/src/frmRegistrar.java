import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmRegistrar extends JFrame {
    public frmRegistrar() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Registrar Estudiante");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);


        JLabel lblTitulo = new JLabel("Registrar Estudiante");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridwidth = 2;
        panelPrincipal.add(lblTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;

        gbc.gridy++;
        JLabel lblNombre = new JLabel("Nombre:");
        panelPrincipal.add(lblNombre, gbc);

        gbc.gridx++;
        JTextField txtNombre = new JTextField(13);
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblApellido = new JLabel("Apellido:");
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lblApellido, gbc);

        gbc.gridx++;
        JTextField txtApellido = new JTextField(13);
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(txtApellido, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblEdad = new JLabel("Edad:");
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lblEdad, gbc);

        gbc.gridx++;
        JTextField txtEdad = new JTextField(13);
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(txtEdad, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblCurso = new JLabel("Curso:");
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lblCurso, gbc);

        gbc.gridx++;
        JTextField txtCurso = new JTextField(13);
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(txtCurso, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int edad = Integer.parseInt(txtEdad.getText().trim());

                    Estudiante estudiante = new Estudiante(txtNombre.getText(), txtApellido.getText(), edad, txtCurso.getText());
                    Estudiante.estudiantes.add(estudiante);
                    Estudiante.guardarEstudiantes();

                    JOptionPane.showMessageDialog(null, "Estudiante registrado");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese una edad válida");
                }
            }
        });
        panelBotones.add(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panelBotones.add(btnCancelar);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(panelBotones, gbc);

        getContentPane().add(panelPrincipal);
        setVisible(true);
    }
}