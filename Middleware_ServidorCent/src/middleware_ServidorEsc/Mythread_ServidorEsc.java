package middleware_ServidorEsc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mythread_ServidorEsc implements Runnable {

    @Override
    public void run() {
        try {
            String direccionServidor = "localhost";
            ArrayList aux = new ArrayList();
            int puertoServidor = 5001;
            Socket servidor = new Socket(direccionServidor, puertoServidor);
            PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
                String inputLine = "";
                int i = 0;
                System.out.println("LLego hasta aqui");
                while (i == 0) {
                    Thread.sleep(1000);

                    out.println("activo");
                    if ((inputLine = in.readLine()) != null) {
                        System.out.println(inputLine);
                    }
                }

                out.close();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error cliente");
        }
    }

}
