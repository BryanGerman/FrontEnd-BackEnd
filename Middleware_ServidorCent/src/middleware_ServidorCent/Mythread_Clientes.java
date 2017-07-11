/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware_ServidorCent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.clientes;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.servidores;


/**
 *
 * @author Bryan German
 */
public class Mythread_Clientes implements Runnable {

    BufferedReader in;
    String direccionServidorEsc;
    Socket cliente;
    int puertoClientes;
    int contador;

    public Mythread_Clientes(Socket cliente, int puertoClientes,int contador) {
        this.cliente = cliente;
        this.puertoClientes = puertoClientes;
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            while(true){
                

                in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine + " " + contador);
                }
            }
            
        } catch (IOException ex) {
            try {
                System.out.println("Cliente "+contador+" atendido");
                int pos = 0;
                for (int i = 0; i < servidores.size(); i++) {
                    if(cliente == clientes.get(i)){
                        pos = i;
                    }
                }
                clientes.remove(pos);
                System.out.println("Servidores disponibles");
                System.out.println(servidores);
                cliente.close();
            } catch (IOException ex1) {
                Logger.getLogger(Mythread_Servidores.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

}
