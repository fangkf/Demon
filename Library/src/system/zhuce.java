package system;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import mysql.Connect;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class zhuce {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			zhuce window = new zhuce();
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
		shell.setImage(SWTResourceManager.getImage(zhuce.class, "/image/\u56FE\u4E66\u9986.gif"));
		shell.setSize(450, 300);
		shell.setText("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 13, SWT.BOLD));
		label.setBounds(56, 23, 84, 24);
		label.setText("\u7528\u6237\u6CE8\u518C");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(121, 65, 41, 17);
		label_1.setText("\u7528\u6237\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(190, 62, 110, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(121, 110, 41, 17);
		label_2.setText("\u5BC6\u7801");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(190, 107, 110, 23);
		char echo='*';
		text_1.setEchoChar(echo);
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(121, 150, 57, 17);
		label_3.setText("\u786E\u8BA4\u5BC6\u7801");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(190, 147, 110, 23);
		char ec='*';
		text_2.setEchoChar(ec);
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage(zhuce.class, "/image/\u786E\u5B9A.ico"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String mm=text_1.getText();
				String newmm=text_2.getText();
				Connection con=null;
				Statement sql;
				con=Connect.Connetli();
				if (mm.equals(""+newmm+"")) {
					String tj="insert into user values(null,'"+text.getText()+"','"+text_1.getText()+"')";
					System.out.println(tj);
					try {
						sql=con.createStatement();
						sql.executeUpdate(tj);
						JOptionPane.showMessageDialog(null, "◊¢≤·≥…π¶");
						shell.setVisible(false);
					}
					catch (SQLException e1) {}
				}
				else {
					JOptionPane.showMessageDialog(null, "√‹¬Î¥ÌŒÛ£°«Î‘Ÿ¥Œ»∑»œ£°");
				}
			}
		});
		button.setBounds(172, 188, 50, 49);

	}
}
