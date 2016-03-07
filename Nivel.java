package juego;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;

public class Nivel {
    int NoLadrillos;
    int x=15;
    int y=100;
    int ancho=80;
    int alto=15;
    List<String>misLadrillos = new ArrayList<>();
    
    Nivel(int NoLadrillos){
        this.NoLadrillos = NoLadrillos;
    }
    
    //metodo que agrega los ladrillos al array que los contiene
    public void agregarLadrillos(){
        Integer i=0;
        while(i<NoLadrillos){
            misLadrillos.add(i.toString());
            i++;
        }
    }
    
    //pinta los ladrillos en pantalla
    public void paint(Graphics g){
      //System.out.println(misLadrillos);
      int Xaux=0, Yaux=0;
      for(Integer i=0; i<12; i++) {
         if(i==4 || i==8) { Xaux=0; Yaux+=25; }
         if(misLadrillos.contains(i.toString())) g.fillRect(x+(90*Xaux), y+Yaux, ancho, alto);
         Xaux++;
      }
    }
    
    //Funcion para cada ladrillo//Crea un rectangulo del mismo tamaño del ladrillo para la deteccion de colisiones
    public Rectangle getBounds0(int ladrillo){
      int Xaux=0, Yaux=0;
      for(Integer i=0; i<12; i++) {
        if(i==4 || i==8) { Xaux=0; Yaux+=25; }
        if(ladrillo==i && misLadrillos.contains(i.toString())){ Rectangle re0 = new Rectangle(x+(90*Xaux),y+Yaux,ancho,alto);
           return re0;
        }
        Xaux++;
      }
      return new Rectangle(0,0,1,1);
    }
}

