import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String curso;

    public Estudiante(String nombre, String apellido, int edad, String curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
    }
    public static List<Estudiante> estudiantes = new ArrayList<>();

    public static void guardarEstudiantes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("estudiantes.txt", false))) {
            for (Estudiante estudiante : estudiantes) {
                String linea = estudiante.getNombre() + "," + estudiante.getApellido() + "," +
                        estudiante.getEdad() + "," + estudiante.getCurso() + "\n";
                bw.write(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void cargarEstudiantes() {
        estudiantes.clear();
        File archivo = new File("estudiantes.txt");
        if (!archivo.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    try {
                        Estudiante estudiante = new Estudiante(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3]);
                        estudiantes.add(estudiante);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurso() {
        return curso;
    }
}