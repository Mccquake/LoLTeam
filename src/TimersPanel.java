package uk.co.eclipsion.lolteam;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TimersPanel extends Panel {
	
	private static final long serialVersionUID = 8175849159166393317L;
	private BufferedImage imgAshe = null;
	
	public TimersPanel() {
		try {
			imgAshe = ImageIO.read(this.getClass().getResource("/images/TimersBackground.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(imgAshe, 0, 0, getWidth(), getHeight(), this);
		super.paint(g);
	}
	
	
}
