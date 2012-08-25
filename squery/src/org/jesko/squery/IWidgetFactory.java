package org.jesko.squery;

import org.jesko.squery.widget.IWidget;


public interface IWidgetFactory {

	IWidget build(IWidget parent, String name);
	String getName();
}
