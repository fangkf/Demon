package system;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import mysql.Connect;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.sql.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.eclipse.ui.forms.widgets.FormToolkit;

public class Tianjia {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tianjia window = new Tianjia();
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
		shell.setImage(SWTResourceManager.getImage(Tianjia.class, "/image/\u56FE\u4E66\u9986.gif"));
		shell.setSize(450, 314);
		shell.setText("\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(48, 42, 63, 17);
		label.setText("\u7C7B\u522B\u540D\u79F0");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(127, 39, 163, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(48, 88, 61, 17);
		label_1.setText("\u7C7B\u522B\u63CF\u8FF0");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(126, 82, 229, 87);
		///tianjia 
		Button button = new Button(shell, SWT.NONE);
		button.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.BOLD));
		button.setImage(SWTResourceManager.getImage(Tianjia.class, "/image/\u6DFB\u52A01.ico"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con=null;
				Statement sql;
				con=Connect.Connetli();
				String tj="insert into booktype values(null,'"+text.getText()+"','"+text_1.getText()+"')";
				System.out.println(tj);
				try {
					sql=con.createStatement();
					sql.executeUpdate(tj);
					JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
					
				}
				catch (SQLException e1) {}
			}
		});
		button.setBounds(67, 189, 112, 52);
		button.setText("\u6DFB\u52A0");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.BOLD));
		button_1.setImage(SWTResourceManager.getImage(Tianjia.class, "/image/\u91CD\u7F6E.ico"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
			}
		});
		button_1.setBounds(242, 189, 113, 52);
		button_1.setText("\u91CD\u7F6E");

	}
}
