package org.jesko.squery;

import static org.jesko.squery.SQuery.$;
import static org.jesko.squery.widget.Widgets.TextField;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TextArea {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		$(shell).append(TextField("joey"));
		$("joey").text("This is a text area added to the shell by SQuery!");
		
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
