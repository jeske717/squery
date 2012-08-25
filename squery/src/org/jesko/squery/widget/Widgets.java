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
			public IWidget build(IWidget parent, String name) {
				Text text = new Text((Composite) parent.getControl(), SWT.NONE);
				text.setData("name", name);
				return new SwtWidget(text) {
					@Override
					public void setText(String text) {
						((Text)control).setText(text);
					}
				};
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
			public IWidget build(IWidget parent, String name) {
				Button button = new Button((Composite) parent.getControl(), SWT.PUSH);
				button.setData("name", name);
				return new SwtWidget(button){
					@Override
					public void setText(String text) {
						((Button)control).setText(text);
					}
				};
			}
		};
	}

}
