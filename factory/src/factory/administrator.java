package factory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class administrator {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			administrator window = new administrator();
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
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.BOLD | SWT.ITALIC));
		label.setBounds(151, 22, 91, 26);
		label.setText("\u7BA1\u7406\u7CFB\u7EDF");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new product().main(null);
			}
		});
		btnNewButton.setBounds(129, 77, 140, 27);
		btnNewButton.setText("\u4EA7\u54C1\u7BA1\u7406");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new staff().main(null);
			}
		});
		btnNewButton_1.setBounds(129, 127, 140, 27);
		btnNewButton_1.setText("\u4EBA\u5458\u7BA1\u7406");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new sale().main(null);
			}
		});
		btnNewButton_2.setBounds(129, 176, 140, 27);
		btnNewButton_2.setText("\u8BA2\u5355\u7BA1\u7406");
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(129, 225, 140, 27);
		btnNewButton_3.setText("\u9000\u51FA\u7CFB\u7EDF");

	}

}
