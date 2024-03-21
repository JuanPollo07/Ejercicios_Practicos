import javax.swing.*;
import java.awt.*;

public class frmInicio extends JFrame {
    public frmInicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setSize(300, 200);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> new frmRegistrar());
        panelBotones.add(btnRegistrar);

        JButton btnListar = new JButton("Listar Usuarios");
        btnListar.addActionListener(e -> new frmListar());
        panelBotones.add(btnListar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelBotones, BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
