import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Login {
    public boolean validarInicioSesion(String usuario, String contraseña) throws IOException {
        FileReader fr = new FileReader("usuarios.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2 && parts[0].equals(usuario) && parts[1].equals(contraseña)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }
}