package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class HUD {
    int X=5;
    int Y=12;
    int x;
    int y;
    public int numVidas=3,i=0;
    public int score=2000;
                    //Arreglos para los poligonos(corazones)
                   //   1    2    3    4    5    6
    int valoresX[] = { 345, 340, 350, 360, 355, 350};
    int valoresY[] = { 5, 10, 20, 10, 5, 10 };
    int valoresX2[] = { 320, 315, 325, 335, 330, 325};
    int valoresY2[] = { 5, 10, 20, 10, 5, 10 };
    int valoresX3[] = { 295, 290, 300, 310, 305, 300};
    int valoresY3[] = { 5, 10, 20, 10, 5, 10 };
    Polygon poligono1 = new Polygon( valoresX, valoresY, 6 );
    Polygon poligono2 = new Polygon( valoresX2, valoresY2, 6 );
    Polygon poligono3 = new Polygon( valoresX3, valoresY3, 6 );
    String texto;
    Juego juego;
    
    HUD(Juego juego){
        this.juego = juego;
    }
    //pinta en pantalla el score y las vidas(poligonos)
    public void paint(Graphics g){
        g.setColor(Color.blue);
        score--;
        if(score==200000)score=0;
        texto = String.format("SCORE: %d",score/100);
        g.drawString(texto, X, Y);
        g.drawString("VIDAS:",x-145,Y);
        g.setColor(Color.red);
            if(numVidas==1)
                g.fillPolygon(poligono1);
            if(numVidas==2){
                g.fillPolygon(poligono2);
                g.fillPolygon(poligono1);
            }
            if(numVidas==3){
                g.fillPolygon(poligono3);
                g.fillPolygon(poligono2);
                g.fillPolygon(poligono1);
            }
    }
    //recibe el ancho de la pantalla
    public void setMedidas(int ancho){
        x =ancho;
    }
}
