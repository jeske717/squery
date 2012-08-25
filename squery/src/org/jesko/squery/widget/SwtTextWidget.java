package org.jesko.squery.widget;

import org.eclipse.swt.widgets.Text;

class SwtTextWidget extends SwtWidget {

	private final Text textField;

	public SwtTextWidget(Text text, String name) {
		super(text, name);
		this.textField = text;
	}

	@Override
	public void setText(String text) {
		textField.setText(text);
	}
}
