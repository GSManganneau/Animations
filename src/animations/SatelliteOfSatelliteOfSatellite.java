package animations;

import java.awt.Color;
import java.awt.Graphics;

public class SatelliteOfSatelliteOfSatellite extends Circle{
 
	public double x;
	public double y;
	public int side;
	public double x0;
	public double y0;
	private double teta;
	private double interval;
	private int rayon;
	public Color color = new Color (0,0,0);
	public Color color2 = new Color(118,199,232);
	public SatelliteOfSatellite s;
	public boolean dead;
	public boolean down = false;
	
	public SatelliteOfSatelliteOfSatellite(int r, SatelliteOfSatellite s){
		this.s=s;
		rayon=r;
		side=10;
		x0 = s.x;
		y0 = s.y;
		interval=0.01;
		teta=0;

		dead = false;
		
	}
	// FUNCTIONS

	public double getx() {
		return x;
	}

	public double gety() {
		return y;
	}
	public int getSide(){
		return side;
	}

	public void update() {
		if (teta>=2*Math.PI)teta=0;
		teta+=interval;
		x=rayon*Math.cos((teta))+this.s.x;
		y= rayon*Math.sin((teta))+this.s.y;
		
	}
	public boolean delete(){
		if(dead==true ||  y > AnimationsPanel.HEIGHT+side || x < 0-side || x > AnimationsPanel.WIDTH+side) {
			return true;
		}
		else return false;
	}
	
	
	public void draw(Graphics g) {
		
		/*g.setColor(Color.MAGENTA);
		g.fillOval((int)x, (int)y, side, side);
		g.fillOval((int)x0, (int)y0, side, side);
		g.setColor(this.color2);
		g.fillOval((int)x+5, (int)y+2, side/2, side/2);*/
	}
	public void death(){
		this.dead=true;
		
			}

	

	
}

