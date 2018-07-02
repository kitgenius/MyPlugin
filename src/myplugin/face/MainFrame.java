package myplugin.face;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Composite;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.io.UnsupportedEncodingException;
import java.awt.BorderLayout;
import javax.swing.JRootPane;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Text;

public class MainFrame {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainFrame window = new MainFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("MyPlugin");
		
		//屏幕中间显示
		Rectangle displayBounds = shell.getDisplay().getPrimaryMonitor().getBounds();
		Rectangle shellBounds = shell.getBounds();
		int x = displayBounds.x + (displayBounds.width - shellBounds.width) >> 1;
		int y = displayBounds.y + (displayBounds.height - shellBounds.height) >> 1;
		shell.setLocation(x, y);

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmReadPath = new MenuItem(menu, SWT.NONE);
		mntmReadPath.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileselect = new FileDialog(shell, SWT.SINGLE);
				fileselect.setFilterNames(new String[] { "*.txt", "所有文件" });
				fileselect.setFilterExtensions(new String[] { "*.txt", "*.*" });
				String filePath = "";
				filePath = fileselect.open();
					text.setText("选择：" + filePath);
				
			}
		});
		mntmReadPath.setText("read path");

		text = new Text(shell, SWT.BORDER | SWT.MULTI);
		text.setBounds(0, 0, 434, 242);

	}
}
