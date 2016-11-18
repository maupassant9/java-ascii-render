package com.indvd00m.ascii.render.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.Rectangle;
import com.indvd00m.ascii.render.elements.Text;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 5:15:07 PM
 *
 */
public class TestText {

	@Test
	public void test() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(10, 5);

		Text t = new Text("Test", 1, 1, 4, 1);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		String s = "";
		s += "          \n";
		s += " Test     \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Test", 1, 1, 3, 1);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Test", 1, 1, 3, 2);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Tes      \n";
		s += " t        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\nt", 1, 1, 3, 2);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Tes      \n";
		s += " t        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 3, 2);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 3, 1);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te…      \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 3, 3);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Tes      \n";
		s += "          \n";
		s += " t        \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 2, 4);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te       \n";
		s += " s        \n";
		s += "          \n";
		s += " t        ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 2, 3);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " Te       \n";
		s += " …        \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 2, 1);
		point = t.draw(canvas, context);
		assertEquals(new Point(1, 1), point);
		s = "";
		s += "          \n";
		s += " T…       \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 2, 0);
		point = t.draw(canvas, context);
		assertNull(point);
		s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("Tes\n\nt", 1, 1, 0, 1);
		point = t.draw(canvas, context);
		assertNull(point);
		s = "";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          \n";
		s += "          ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas.clear();
		t = new Text("This is long text in rectangle", 2, 1, 5, 3);
		point = t.draw(canvas, context);
		new Rectangle(1, 0, 7, 5).draw(canvas, context);
		assertEquals(point, new Point(2, 1));
		s = "";
		s += " ┌─────┐  \n";
		s += " │This │  \n";
		s += " │is lo│  \n";
		s += " │ng t…│  \n";
		s += " └─────┘  ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());

		canvas = new Canvas(30, 10);
		t = new Text(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
				5, 3, 20, 6);
		point = t.draw(canvas, context);
		new Rectangle(4, 2, 22, 8).draw(canvas, context);
		assertEquals(point, new Point(5, 3));
		s = "";
		s += "                              \n";
		s += "                              \n";
		s += "    ┌────────────────────┐    \n";
		s += "    │Lorem Ipsum is simpl│    \n";
		s += "    │y dummy text of the │    \n";
		s += "    │printing and typeset│    \n";
		s += "    │ting industry. Lorem│    \n";
		s += "    │ Ipsum has been the │    \n";
		s += "    │industry's standard…│    \n";
		s += "    └────────────────────┘    ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
