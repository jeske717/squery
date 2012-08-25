package org.jesko.squery;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.jesko.squery.widget.IWidget;
import org.jesko.squery.widget.SwtWidget;

public class SQuery {
	
	private static SQuery instance = new SQuery();
	
	private IWidget activeControl;
	private Map<String, IWidget> controls;
	
	private SQuery() {
		controls = new HashMap<String, IWidget>();
	}

	static SQuery $(Control control) {
		if(control instanceof Composite) {
			((Composite)control).setLayout(new GridLayout());
		}
		IWidget widget = new SwtWidget(control);
		instance.addControl(widget);
		instance.setActiveControl(widget);
		return instance;
	}
	
	static SQuery $(String control) {
		instance.setActiveControl(instance.controls.get(control));
		return instance;
	}

	public SQuery append(IWidgetFactory widgetFactory) {
		IWidget newControl = widgetFactory.build(activeControl, widgetFactory.getName());
		addControl(newControl);
		activeControl.pack();
		return this;
	}
	
	public SQuery text(String text) {
		activeControl.setText(text);
		activeControl.pack();
		activeControl.getParent().pack();
		return this;
	}
	
	public SQuery click(final ICallback callback) {
		activeControl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				callback.run(e);
			}
		});
		return this;
	}
	
	private void setActiveControl(IWidget control) {
		this.activeControl = control;
	}
	
	private void addControl(IWidget control) {
		controls.put((String) control.getName(), control);
	}
}