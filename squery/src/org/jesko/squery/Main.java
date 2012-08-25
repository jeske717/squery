package org.jesko.squery;

import static org.jesko.squery.SQuery.$;
import static org.jesko.squery.widget.Widgets.*;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Main {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		
		$(shell).append(TextField("helloWorldTest"));
		$("helloWorldTest").text("Hello World SWT");
		$(shell).append(ButtonWidget("helloWorldButton"));
		
		$("helloWorldButton").click(new ICallback() {
			private int clickCount = 0;
			@Override
			public void run(MouseEvent e) {
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage("HELLO!!");
				messageBox.setText("sQuery is awesome");
				messageBox.open();
				$("helloWorldButton").text("" + ++clickCount + " click(s)");
			}
		}).text("Say Hi!");
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
		
	}
}
