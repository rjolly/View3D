package tom.graphic.BeanUtils;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.beans.PropertyEditorSupport;
import java.util.EventObject;

// Referenced classes of package tom.graphic.BeanUtils:
//			FileDiagButton

public class FileNameEditor extends PropertyEditorSupport {

	String value;

	public FileNameEditor() {
		value = "noDef";
	}

	public void actionPerformed(ActionEvent actionevent) {
		setAsText(((Button)actionevent.getSource()).getLabel());
	}

	public String getAsText() {
		return value;
	}

	public Component getCustomEditor() {
		return new FileDiagButton(this);
	}

	public boolean isPaintable() {
		return true;
	}

	public void paintValue(Graphics g, Rectangle rectangle) {
		g.setColor(Color.lightGray);
		g.fill3DRect(rectangle.x + 2, rectangle.y + 2, rectangle.width - 2, rectangle.height - 2, true);
		g.setColor(Color.black);
		g.setClip(rectangle.x + 2, rectangle.y + 2, rectangle.width - 6, rectangle.height - 4);
		g.drawString(value, rectangle.x + 4, (rectangle.y + rectangle.height) - 6);
	}

	public void setAsText(String s) throws IllegalArgumentException {
		value = s;
		setValue(s);
	}

	public void setValue(Object obj) {
		value = (String)obj;
		super.setValue(obj);
	}

	public boolean supportsCustomEditor() {
		return true;
	}
}
