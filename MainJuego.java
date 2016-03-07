package juego;

/*******************************************************************************
 *                             BRICKS v1.0 BETA                                *
 *                                                                             *
 *                       FACULTAD DE INGENIERIA ELECTRICA                      *
 *                UNIVERSIDAD MICHOACANA DE SAN NICOLAS DE HIDALGO             *
 *                                                                             *     
 *                      PROGRAMACION DE COMPUTADORAS II                        *
 *                   PROFESOR: MIGUEL ANGEL GARCIA TRILLO                      *
 *                                                                             *
 *                Autor: 1423218d LEON LOEZA FELIPE ALEJANDRO                  *
 *                                                                             *
 *                                                     ALL RITGHS RESERVED     *
 *                                                               09/DIC/15     *            
 *******************************************************************************/

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainJuego implements Runnable{
    static Juego juego = new Juego();
    Thread hilo;
    String nombre;

    MainJuego(){
        nombre = String.format("No te quedan vidas !Perdiste!\nTu escore fue de: %d",juego.miHud.score/100);
    }
    
    public void start(){
     if(hilo==null){
        hilo=new Thread(this);
            hilo.start();
        }
    }
    
    public void stop(){
     if(hilo!=null){
        hilo.stop();
        hilo=null;
     }
    }
    
    //Lo que ejecuta el hilo
    @Override
    public void run() {
        for(;;){
            juego.mover();
            juego.repaint();
            juego.medidas(juego.getWidth(), juego.getHeight());
            if(juego.miHud.numVidas==0){
                JOptionPane.showMessageDialog(juego, nombre, "Bricks v1.0", JOptionPane.ERROR_MESSAGE);
                break;
            }
            if(juego.n1.misLadrillos.isEmpty()){
                juego.ganaste();
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(0);
    }
    
    public static void main(String[] args) throws InterruptedException{
        JFrame miFrame = new JFrame("Bricks v1.0 BETA");
        MainJuego Jmain = new MainJuego();
        miFrame.add(juego);
        miFrame.setVisible(true);
        miFrame.setBackground(Color.white);
        miFrame.setSize(400, 500);
        miFrame.setResizable(false);
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        juego.n1.agregarLadrillos();
        Jmain.start();

    }
}
