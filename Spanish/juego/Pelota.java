package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JPanel;

class Pelota extends JPanel{
    int x = 20;
    int y = 200;
    int dx = 1;
    int dy = 1;
    int ejeX,ejeY,r;
    int ladrillo;
    double velocidad = 1.1;
    private final int ANCHO = 18;
    Juego juego;
    Random rnd = new Random();
    
    Pelota(Juego juego){
        this.juego = juego;
    }
    
    //metodo que mueve la pelota y da nuevos valores de dy y dx si colisiona con los bordes del frame y con los ladrillos y la barra 
    @SuppressWarnings("empty-statement")
    public void mover(){
        //colision con la barra
        if(colision()==true){ 
            ejeY = 1;
            dy = (int) (2*velocidad);
            r = rnd.nextInt(4);
            if(r==2 || r == 1)
                dx = -(int) (1*velocidad);
            else
                dx = (int) (2*velocidad); 
        }
        //colision con los ladrillos
        if(colisionBrick()==true){ 
            Integer nLadrillo = new Integer(ladrillo);
            juego.n1.misLadrillos.remove(nLadrillo.toString()); juego.miHud.score+=1000; velocidad += 0.3; dx += (int) (1*velocidad);
            if(ejeX==0)
                ejeX = 1;
            else
                ejeX = 0; 
            if(ejeY==0)
                ejeY = 1;
            else
                ejeY = 0; 
        }
        //Deteccion de los limites
        if(x>(juego.getWidth()-ANCHO)){
            ejeX = 1;  
            dx = (int) (1*velocidad);
        }
        if(y>500){
            juego.miHud.numVidas -=1;
            x=20;
            y=200;
            //ejeY = 1;
            //dy = rnd.nextInt(4);
        }
        if(x<0){
            ejeX = 0;
            dx = (int) (1*velocidad);
        }
        if(y<0){
            ejeY = 0;
            dy = (int) (1*velocidad);
        }
        //Movimientos
        if(ejeX == 0){
            x += dx;
        }else if (ejeX == 1){
            x -= dx;
        } 
        if(ejeY == 0)
            y += dy;
        else if(ejeY ==1)
            y -= dy;
    }
    
    //pinta la pelota
    @Override
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, ANCHO, ANCHO);
    }
    
    //crea un rectangulo alrededor de la pelota con el que se detectan las colisiones
    @Override
    public Rectangle getBounds() {
	return new Rectangle(x, y, ANCHO, ANCHO);
    }
 
    //detecta la colision con el rectangulo de la barra y usa el metodo intersects()
    public boolean colision(){
        return juego.miBarra.getBounds().intersects(getBounds());
    }
    
    //todos los metodos que detecta colisiones con cada uno de los 12 ladrillos
    public boolean colisionBrick(){
      for(int i=0; i<12; i++) {
        if(juego.n1.getBounds0(i).intersects(getBounds()) == true){ ladrillo = i;
            return true;
        }
      }//for
      return false;
    }
    
}

