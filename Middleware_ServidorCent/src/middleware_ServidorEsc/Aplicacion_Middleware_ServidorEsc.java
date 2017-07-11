/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware_ServidorEsc;

/**
 *
 * @author Bryan German
 */
public class Aplicacion_Middleware_ServidorEsc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            Thread t = new Thread(new Mythread_ServidorEsc());
            t.start();
        }

    }

}
