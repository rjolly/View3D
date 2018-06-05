package tom.graphic.BeanUtils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.beans.PropertyEditorSupport;
import java.io.PrintStream;

// Referenced classes of package tom.graphic.BeanUtils:
//			FileNameEditor

public class ImageEditor extends FileNameEditor {

	Image value;
	static String lastValue = "";

	public ImageEditor() {
		value = null;
		super.value = "Select...";
	}

	public String getAsText() {
		return lastValue;
	}

	public Object getValue() {
		return value;
	}

	public void paintValue(Graphics g, Rectangle rectangle) {
		if (value != null || value.getWidth(null) > 2) {
			g.setColor(Color.black);
			g.clearRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
			g.drawImage(value, rectangle.x, rectangle.y, null);
		} else {
			super.paintValue(g, rectangle);
		}
	}

	public void setAsText(String s) throws IllegalArgumentException {
		setValue(Toolkit.getDefaultToolkit().getImage(s));
		lastValue = s;
	}

	public void setValue(Object obj) {
		value = (Image)obj;
		System.out.println("W:" + value.getWidth(null) + " " + value.getHeight(null));
		firePropertyChange();
	}

}
