package middleware_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan German
 */
public class Aplicacion_Middleware_Cliente {

    public static void main(String[] args) {
        try {
            
            String direccionServidor = "localhost";
            int puertoServidor = 5000;
            Socket servidor = new Socket(direccionServidor, puertoServidor);
            PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String desdeServidor;
            String desdeUsuario = "";
            System.out.println("Escriba su nombre de usuario");
            desdeUsuario += stdIn.readLine()+":";
            System.out.println("Escriba su contrasena");
            desdeUsuario += stdIn.readLine()+":";
            System.out.println("Escriba el mensaje");
            desdeUsuario += stdIn.readLine();
            while(true){
            out.println(desdeUsuario);
            }
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
