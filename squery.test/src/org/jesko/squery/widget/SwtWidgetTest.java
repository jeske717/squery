package org.jesko.squery.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SwtWidgetTest {

	@Mock
	private Control control;
	
	@Test
	public void nameIsStoredOnUnderlyingWidget() throws Exception {
		when(control.getData("name")).thenReturn("controlName");
		
		SwtWidget widget = new SwtWidget(control);
		
		assertEquals("controlName", widget.getName());
	}
	
	@Test
	public void getControlReturnsInstanceWidgetWasConstructedWith() throws Exception {
		SwtWidget widget = new SwtWidget(control);
		
		Control result = widget.getControl();
		
		assertSame(control, result);
	}
	
	@Test
	public void packDelegatesToControl() throws Exception {
		SwtWidget widget = new SwtWidget(control);
		
		widget.pack();
		
		verify(control).pack();
	}
	
	@Test
	public void getParentReturnsWrappedParentWidget() throws Exception {
		Composite parent = mock(Composite.class);
		when(control.getParent()).thenReturn(parent);
		SwtWidget widget = new SwtWidget(control);
		
		IWidget result = widget.getParent();
		
		assertSame(parent, result.getControl());
	}
	
	@Test
	public void addMouseListenerDelegatesToControl() throws Exception {
		MouseListener listener = mock(MouseListener.class);
		SwtWidget widget = new SwtWidget(control);
		
		widget.addMouseListener(listener);
		
		verify(control).addMouseListener(listener);
	}
}
