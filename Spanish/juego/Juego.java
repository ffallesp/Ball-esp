package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel{
    Barra miBarra = new Barra(this);
    Pelota miPelota = new Pelota(this);
    Nivel n1 = new Nivel(12);
    HUD miHud = new HUD(this);
    String nombre;
    
    Juego(){
        this.setBackground(Color.white);
        //agrega la deteccion del mouse
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                miBarra.mouseMoved(e);
            }

        });
    }
    //llama a todos los metodos mover de las clases
    public void mover() {
        miBarra.mover();
        miPelota.mover();
    }
    
    //metodo para agregar la imagen
    @Override
    public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/imagen/Prueba.png")).getImage());
        g.drawImage(imagen.getImage(), 0, 0,tam.width,tam.height,null);
    }
    
    //llama a todos los metodos que se pintaran en la pantalla
    @Override
    public void paint(Graphics g){
        super.paint(g);
        n1.paint(g);
        miBarra.paint(g);
        miPelota.paint(g);
        miHud.paint(g);

    }
    //envia las medidas del frame
    public void medidas(int ancho,int alto){
        miBarra.setMedidas(alto);
        miHud.setMedidas(ancho);
    }
    //metodo que pone el anuncio que ganaste
    public void ganaste(){
        String nombre1;
        nombre1 = String.format("Ganaste!\n Tu score fue de: %d",miHud.score/100);
        JOptionPane.showMessageDialog(this, nombre1, "Bricks V1",JOptionPane.INFORMATION_MESSAGE);
    }

}
