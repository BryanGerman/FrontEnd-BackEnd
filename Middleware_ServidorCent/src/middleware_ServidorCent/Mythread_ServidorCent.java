package middleware_ServidorCent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.contadorServidores;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.servidores;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.clientes;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.numeroDeHilos;
/**
 *
 * @author Bryan German
 */
public class Mythread_ServidorCent implements Runnable {

    int puertoServidores;

    public Mythread_ServidorCent(int puertoServidores) {
        this.puertoServidores = puertoServidores;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ServerSocket socketServidores = new ServerSocket(puertoServidores);
                while (true) {
                    Socket servidorEsclavo = socketServidores.accept();
                    System.out.println("SERVIDORES CONECTADOS");
                    contadorServidores++;
                    servidores.add(servidorEsclavo);
                    System.out.println(servidores.toString());
                    Thread servidorEsc = new Thread(new Mythread_Servidores(puertoServidores, servidorEsclavo, contadorServidores));
                    servidorEsc.start();
                    
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
