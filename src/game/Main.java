package game;

import javafx.embed.swt.FXCanvas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Main {

	public static void main(String[] args) {

		final Display display = new Display();
		final Shell shell = new Shell(display);
		final RowLayout layout = new RowLayout();
		shell.setLayout(layout);

		/* Create the SWT button */
		final org.eclipse.swt.widgets.Button swtButton = new org.eclipse.swt.widgets.Button(shell, SWT.PUSH);
		swtButton.setText("SWT Button");

		/* Create an FXCanvas */
		final FXCanvas fxCanvas = new FXCanvas(shell, SWT.NONE) {
			@Override
			public Point computeSize(int wHint, int hHint, boolean changed) {
				getScene().getWindow().sizeToScene();
				int width = (int) getScene().getWidth();
				int height = (int) getScene().getHeight();
				return new Point(width, height);
			}
		};

		/* Create a JavaFX Group node */
		Group group = new Group();

		/* Create a JavaFX button */
		final Button jfxButton = new Button("JFX Button");

		/* Assign the CSS ID ipad-dark-grey */
		jfxButton.setId("ipad-dark-grey");

		/* Add the button as a child of the Group node */
		group.getChildren().add(jfxButton);

		/* Create the Scene instance and set the group node as root */
		Color color = Color.rgb( //
				shell.getBackground().getRed(), //
				shell.getBackground().getGreen(), //
				shell.getBackground().getBlue() //
		);
		Scene scene = new Scene(group, color);

		/* Attach an external stylesheet */
		scene.getStylesheets().add("twobuttons/Buttons.css");

		fxCanvas.setScene(scene);

		/* Add Listeners */
		swtButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				jfxButton.setText("JFX Button: Hello from SWT");
				shell.layout();
			}
		});

		jfxButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				swtButton.setText("SWT Button: Hello from JFX");
				shell.layout();
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();

	}

	public int add(int a, int b) {
		return a + b;
	}

}
