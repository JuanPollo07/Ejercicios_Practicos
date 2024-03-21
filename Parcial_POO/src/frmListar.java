import javax.swing.*;
import java.awt.*;

class frmListar extends JFrame {
    public frmListar() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Listar Usuarios");
        setSize(500, 300);
        setLocationRelativeTo(null);

        String[] columnas = {"Nombre", "Apellido", "Edad", "Curso"};
        Object[][] datos = new Object[Estudiante.estudiantes.size()][4];

        for (int i = 0; i < Estudiante.estudiantes.size(); i++) {
            Estudiante est = Estudiante.estudiantes.get(i);
            datos[i][0] = est.getNombre();
            datos[i][1] = est.getApellido();
            datos[i][2] = est.getEdad();
            datos[i][3] = est.getCurso();
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tabla);
        tabla.setFillsViewportHeight(true);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver a Inicio");
        btnVolver.addActionListener(e -> {
            dispose();
            new frmInicio();
        });

        getContentPane().add(btnVolver, BorderLayout.SOUTH);

        setVisible(true);
    }
}
