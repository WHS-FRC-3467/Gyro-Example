package team3467.smartdashboard.extentsion.jake.shooter;

import javax.swing.JLabel;

import team3467.smartdashboard.extentsion.jake.Extension;

public class Shooter {
	public static int x = 0;
	public static int y = 0;
	
	public static void shooter(int xPos, int yPos) {
		x = xPos;
		y = yPos;
		
		drawTitle();
		drawTableCompenents();
	}

	static JLabel title;
	private static void drawTitle() {
		title  = new JLabel("Shooter");
		//title.setLocation(x, y);
		Extension.instance.add(title);
	}
	
	static JLabel topColumn;
	private static void drawTableCompenents() {
		//topColumn.setBounds(100, 0, 100, 50);
		//topColumn = new JLabel("Actual        Desired        Offset        Status");
		topColumn = new JLabel("location");
		topColumn.setLocation(200, 0);
		Extension.instance.add(topColumn);
	}
}
