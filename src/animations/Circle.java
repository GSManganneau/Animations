package animations;



import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	// FIELDS

	public double x;
	public double y;
	public int side;
	public double x0;
	public double y0;
	private double teta;
	private double interval;
	private int rayon;
	public Color color =Color.RED;
	public Color color2 = Color.black;
	
	public boolean dead;
	public boolean down = false;
	

	// CONSTRUCTOR
	public Circle() {
		rayon=100;
		side=10;
		x0 = AnimationsPanel.WIDTH /2;
		y0 = AnimationsPanel.HEIGHT/2;
		interval=0.1;
		teta=1;

		dead = false;
		
	}
	public Circle(double x, double y,int r) {
	
		this.rayon =r;
		side=10;
		this.x0 =x;
		this.y0 =y;
		interval=1;
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
		//if (teta>=2*Math.PI)teta=0;
		do{
		teta+=interval;
		x=rayon*Math.cos((teta))+x0;
		y= rayon*Math.sin((teta))+y0;
		}while(teta<=2*Math.PI);
		System.out.println(teta);
		
	}
	public boolean delete(){
		if(dead==true ||  y > AnimationsPanel.HEIGHT+side || x < 0-side || x > AnimationsPanel.WIDTH+side) {
			return true;
		}
		else return false;
	}
	
	
	/**
	 * @param 
	 */
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval((int)x, (int)y, side, side);
	    g.fillOval((int)x0, (int)y0, side, side);
	g.setColor(this.color2);
		g.fillOval((int)x+5, (int)y+2, side/2, side/2);
		
	}
	public void death(){
		this.dead=true;
		
			}

	

	
}



