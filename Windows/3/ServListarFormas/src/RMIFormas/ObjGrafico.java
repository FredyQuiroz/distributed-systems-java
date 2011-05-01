package RMIFormas;

import java.awt.Rectangle;
import java.awt.Color;
import java.io.Serializable;
public class ObjGrafico implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String tipo;
    public Rectangle cerrado;
    public Color linea;
    public Color relleno;
    public boolean esRelleno;
    
    //	constructores
    public ObjGrafico() { }
    
    public ObjGrafico(String unTipo, Rectangle unoCerrado, Color unaLinea,Color unRelleno, boolean unoEsRelleno) {
		tipo = unTipo;
		cerrado = unoCerrado;
		linea = unaLinea;
		relleno = unRelleno;
		esRelleno = unoEsRelleno;
    }
    
    public void print(){
		System.out.println(tipo);
		System.out.println("   " + cerrado.x + " , " + cerrado.y + " , " + cerrado.width + " , "  + cerrado.height);
		if(esRelleno) System.out.println("- Tiene color por dentro");else System.out.println("No tiene color por dentro");
	}
}
