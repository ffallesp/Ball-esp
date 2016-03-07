package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

class Barra{
    public int Y;
    public int ANCHO = 60;
    public int ALTO = 15;
    public int velocidad = 1;
    int x=0;
    int x0;
    Juego juego;
    
    Barra(Juego juego){
        this.juego = juego;
    }
    
    public void setMedidas(int alto){
        this.Y = alto-30;
    }
    //metodo que mueve la barra
    public void mover(){
        if(x0<juego.getWidth()){
            if(x0>x)
                x = x+Math.abs(x-x0);
            else
                x = x-Math.abs(x-x0);
        }
    }
    //detecta el movimiento del mouse
    public void mouseMoved(MouseEvent e) {
        x0 = e.getX()-30; 
    }
    //pinta la barra
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x,Y,ANCHO,ALTO);
    }
    //crea un rectangulo de las medidas de la barra para detectar colisiones con este
    public Rectangle getBounds() {
        return new Rectangle(x, Y, ANCHO, ALTO);
    }
    
}
