/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware_ServidorCent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.servidores;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.numeroDeHilos;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.clientes;
/**
 *
 * @author Bryan German
 */
public class Mythread_Servidores implements Runnable {

    BufferedReader in;
    String direccionServidorEsc;
    
    int puertoServidores;
    Socket servidorEsclavo;
    int contador;
    public Mythread_Servidores(int puertoServidores,Socket servidorEsclavo,int contador) {
        this.puertoServidores = puertoServidores;
        this.servidorEsclavo = servidorEsclavo;
        this.contador = contador;
        
        
    }

    @Override
    public void run() {
        try {

            while(true){
                in = new BufferedReader(new InputStreamReader(servidorEsclavo.getInputStream()));
                String inputLine;
                PrintWriter out = new PrintWriter(servidorEsclavo.getOutputStream(), true);
                numeroDeHilos++;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine + " " + contador);
                        out.println(clientes.toString());
                    
                } 
            }
        } catch (IOException ex) {
            try {
                System.out.println("Se termino con la conexion con el servidor "+contador);
                int pos = 0;
                for (int i = 0; i < servidores.size(); i++) {
                    if(servidorEsclavo == servidores.get(i)){
                        pos = i;
                    }
                }
                servidores.remove(pos);
                numeroDeHilos--;
                System.out.println("Despues de cerrar el hilo "+numeroDeHilos);
                System.out.println("Servidores disponibles");
                System.out.println(servidores);
                servidorEsclavo.close();
            } catch (IOException ex1) {
                Logger.getLogger(Mythread_Servidores.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
}
