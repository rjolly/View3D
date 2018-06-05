package tom.graphic.BeanUtils;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextComponent;
import java.awt.TextField;

// Referenced classes of package tom.graphic.BeanUtils:
//			FileNameEditor

class FileDiagButton extends Panel {

	FileNameEditor myParent;
	Button button;
	TextField label;

	public FileDiagButton(FileNameEditor filenameeditor) {
		myParent = filenameeditor;
		setLayout(new BorderLayout());
		add("Center", label = new TextField(filenameeditor.value));
		add("East", button = new Button("..."));
	}

	public boolean action(Event event, Object obj) {
		if (event.target == button) {
			Object obj1 = button;
			boolean flag = false;
			do
				if (java.awt.Frame.class.isInstance(obj1))
					flag = true;
				else
					obj1 = ((Component) (obj1)).getParent();
			while (obj1 != null && !flag);
			if (flag) {
				FileDialog filedialog = new FileDialog((Frame)obj1, "Load a new object");
				filedialog.setFile(myParent.getAsText());
				filedialog.show();
				if (filedialog.getFile() != null) {
					StringBuffer stringbuffer = new StringBuffer(filedialog.getDirectory());
					String s = filedialog.getFile();
					stringbuffer.append(s);
					label.setText(stringbuffer.toString());
					myParent.setAsText(stringbuffer.toString());
				}
			}
		} else {
			myParent.setAsText((String)obj);
		}
		return true;
	}
}
