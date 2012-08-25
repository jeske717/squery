package org.jesko.squery.widget;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.eclipse.swt.widgets.Button;
import org.junit.Test;

public class SwtButtonWidgetTest {

	@Test
	public void setTextSetsTextOnButton() throws Exception {
		Button button = mock(Button.class);
		SwtButtonWidget widget = new SwtButtonWidget(button, "foo");
		
		widget.setText("stuff and things");
		
		verify(button).setText("stuff and things");
	}
}
