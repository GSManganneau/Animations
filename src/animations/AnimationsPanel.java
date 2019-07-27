package animations;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class AnimationsPanel extends JPanel implements Runnable{
	/**
**/

	private static final long serialVersionUID = 1L;
	// FIELDS
	public static int WIDTH = 700;
	public static int HEIGHT = 900;

	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics2D g;
	private int FPS = 30;
	public static ArrayList<Circle> Circles;
	
	// CONSTRUCTOR
	public AnimationsPanel() {
		super();
		
	
	}

	// FUNCTIONS
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}

	}

	public void run() {
		Circles = new ArrayList<Circle>();
		Circle balle1=new Circle();
		Circles.add(balle1);
		Circle satellite1 = new Satellite(100,balle1);
		Circles.add(satellite1);
		SatelliteOfSatellite satelliteOfSatellite1 = new SatelliteOfSatellite (80,(Satellite)satellite1);
		Circles.add(satelliteOfSatellite1);
		//SatelliteOfSatelliteOfSatellite satelliteOfSatelliteOfSatellite = new SatelliteOfSatelliteOfSatellite (50,(SatelliteOfSatellite)satelliteOfSatellite1);
		//Circles.add(satelliteOfSatelliteOfSatellite);
		running = true;
		image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		
		g = (Graphics2D) image.getGraphics();
		// Lissage du text uniquement
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		// Lissage des dessins
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		long startTime;
		long URDTimeMillis;
		long waitTime;

		long targetTime = 1000 / FPS;
	

			running = true;

			
			// Animations LOOP
			while (running) {
				startTime = System.nanoTime();
				AnimationsUpdate();
				AnimationsRender();
				AnimationsDraw();

				URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
				waitTime = targetTime - URDTimeMillis;
				try {
					Thread.sleep(waitTime);
				} catch (Exception e) {
					e.printStackTrace();
				}

			
			
	}
			}

	private void AnimationsUpdate() {
		for (int i = 0; i < Circles.size(); i++) {
			Circles.get(i).update();
			boolean delete = Circles.get(i).delete();
			if (delete) {
				Circles.add(new Circle());
				Circles.remove(i);
				i--;

			}
			
		}
		
	}

	// Powerups update

	// Collisions Cubes-Vaisseau

	// add powerups

	private void AnimationsRender() {
		Color color = new Color(2,255,255);
		//g.fillRect(0, 0, WIDTH, HEIGHT);
		for (int i = 0; i < Circles.size(); i++) {
			Circles.get(i).draw(g);
			
		}

	}

	// Affichage Gravity && Inversion

	// Affichage du jeu sur la fenetre
	private void AnimationsDraw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		// g2.dispose();
	}


}

