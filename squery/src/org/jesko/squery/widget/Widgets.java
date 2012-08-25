package org.jesko.squery.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.jesko.squery.IWidgetFactory;

public class Widgets {

	public static IWidgetFactory TextField(final String name) {
		return new IWidgetFactory() {
			
			@Override
			public String getName() {
				return name;
			}
			
			@Override
			public IWidget build(IWidget parent) {
				Text text = new Text((Composite) parent.getControl(), SWT.NONE);
				return new SwtTextWidget(text, name);
			}
		};
	}

	public static IWidgetFactory ButtonWidget(final String name) {
		return new IWidgetFactory() {
			
			@Override
			public String getName() {
				return name;
			}
			
			@Override
			public IWidget build(IWidget parent) {
				Button button = new Button((Composite) parent.getControl(), SWT.PUSH);
				return new SwtButtonWidget(button, name);
			}
		};
	}

}
