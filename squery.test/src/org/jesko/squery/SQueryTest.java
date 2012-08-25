package org.jesko.squery;

import static org.jesko.squery.SQuery.$;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Control;
import org.jesko.squery.widget.IWidget;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SQueryTest {

	@Mock
	private Control control;
	@Mock
	private IWidgetFactory factory;
	@Mock
	private IWidget widget;
	
	@Before
	public void setUp() {
		when(factory.build(any(IWidget.class), anyString())).thenReturn(widget);
		when(widget.getParent()).thenReturn(mock(IWidget.class));
	}
	
	@Test
	public void wrapperReturnsChainableObject() throws Exception {
		when(widget.getName()).thenReturn("some widget");
		
		SQuery wrapper = $(control);
		SQuery result = wrapper.append(factory);
		
		assertSame(wrapper, result);
	}
	
	@Test
	public void widgetsCanBeWrappedByName() throws Exception {
		when(widget.getName()).thenReturn("myName");
		
		$(control).append(factory);
		$("myName").text("my name's text");
		
		verify(widget).setText("my name's text");
	}
	
	@Test
	public void clickRegistersCallback() throws Exception {
		final boolean[] answer = new boolean[] { false };
		ICallback callback = new ICallback() {
			@Override
			public void run(MouseEvent e) {
				answer[0] = true;
			}
		};
		
		$(control).click(callback);
		
		ArgumentCaptor<MouseListener> listenerCaptor = ArgumentCaptor.forClass(MouseListener.class);
		verify(control).addMouseListener(listenerCaptor.capture());
		listenerCaptor.getValue().mouseUp(null);
		
		assertTrue(answer[0]);
	}
}
