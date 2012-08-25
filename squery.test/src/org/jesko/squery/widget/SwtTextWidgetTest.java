package org.jesko.squery.widget;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.eclipse.swt.widgets.Text;
import org.junit.Test;

public class SwtTextWidgetTest {

	@Test
	public void setTextSetsTextOnTextControl() throws Exception {
		Text text = mock(Text.class);
		SwtTextWidget textWidget = new SwtTextWidget(text, "foo");
		
		textWidget.setText("texty");
		
		verify(text).setText("texty");
	}
	
}
