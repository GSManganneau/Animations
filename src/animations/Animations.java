package animations;

import javax.swing.JFrame;
public class Animations extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Animations(String s){
		super(s);
	}

	public static void main(String[] args) {
	   Animations window = new Animations("Animations");
	   window.setLocationRelativeTo(null);    
	   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	   window.setResizable(false);
	   window.setSize(700,900);
	   window.setAlwaysOnTop(false);
	   AnimationsPanel panel=new AnimationsPanel();
	   panel.setFocusable(true);
	   window.setContentPane(panel);
	   window.setVisible(true);
	   window.setLocationRelativeTo(null);
	}


	


	
}

