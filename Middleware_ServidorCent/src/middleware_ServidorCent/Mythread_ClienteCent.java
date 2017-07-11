package middleware_ServidorCent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.clientes;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.contadorClientes;

public class Mythread_ClienteCent implements Runnable {

    BufferedReader in;
    String direccionServidorEsc;
    int puertoClientes;

    public Mythread_ClienteCent(int puertoClientes) {
        this.puertoClientes = puertoClientes;
    }

    @Override
    public void run() {

        try {
            ServerSocket socketClientes = new ServerSocket(puertoClientes);

            while (true) {
                Socket cliente = socketClientes.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                String inputLine="";
                System.out.println("CLIENTES CONECTADOS");
                contadorClientes++;

                System.out.println(inputLine);
                clientes.add(in.readLine());
                System.out.println(clientes.toString());

            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
