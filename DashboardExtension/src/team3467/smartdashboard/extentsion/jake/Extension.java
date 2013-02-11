package team3467.smartdashboard.extentsion.jake;

import javax.swing.JLabel;

import team3467.smartdashboard.extentsion.jake.shooter.Shooter;

import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.properties.Property;

public class Extension extends StaticWidget {
	private static final long serialVersionUID = -4213192836327176630L;
	
	public static Extension instance;
	
	JLabel label;
	@Override
	public void init() {
		instance = this;
		label = new JLabel("RAAWWRRR v3");
		add(label);
		
		Shooter.shooter(0, 0);
	}

	@Override
	public void propertyChanged(Property property) {
		
	}
}
