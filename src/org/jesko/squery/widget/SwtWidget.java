package org.jesko.squery.widget;

import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Control;

public class SwtWidget implements IWidget {

	protected final Control control;

	public SwtWidget(Control control) {
		this.control = control;
	}
	
	@Override
	public void setText(String text) {
	}

	@Override
	public String getName() {
		return (String) control.getData("name");
	}

	@Override
	public void addMouseListener(MouseListener listener) {
		control.addMouseListener(listener);
	}

	@Override
	public void pack() {
		control.pack();
	}

	@Override
	public IWidget getParent() {
		return new SwtWidget(control.getParent());
	}

	@Override
	public Control getControl() {
		return control;
	}

}
