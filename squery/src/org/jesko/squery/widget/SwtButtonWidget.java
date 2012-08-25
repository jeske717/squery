package org.jesko.squery.widget;

import org.eclipse.swt.widgets.Button;

class SwtButtonWidget extends SwtWidget {

	private final Button button;

	public SwtButtonWidget(Button button, String name) {
		super(button, name);
		this.button = button;
	}

	@Override
	public void setText(String text) {
		button.setText(text);
	}
}
