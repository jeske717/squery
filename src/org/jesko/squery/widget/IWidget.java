package org.jesko.squery.widget;

import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Control;

public interface IWidget {
	void setText(String text);
	String getName();
	void addMouseListener(MouseListener listener);
	void pack();
	IWidget getParent();
	Control getControl();
}
