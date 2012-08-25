package org.jesko.squery;

import static org.jesko.squery.SQuery.$;
import static org.jesko.squery.widget.Widgets.ButtonWidget;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class ClickListener {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		
		$(shell).append(ButtonWidget("button"));
		$("button").text("Click me!").click(new ICallback() {
			@Override
			public void run(MouseEvent e) {
				MessageBox msgBox = new MessageBox(shell);
				msgBox.setMessage("Congratulations!");
				msgBox.setText("Congratulations!");
				msgBox.open();
			}
		});
		
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
