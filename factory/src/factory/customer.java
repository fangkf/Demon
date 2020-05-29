package factory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class customer {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			customer window = new customer();
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
		shell.setText("\u8BA2\u5355");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 15, SWT.BOLD | SWT.ITALIC));
		label.setBounds(146, 10, 79, 27);
		label.setText("\u6B22\u8FCE\u60A8\uFF01");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(51, 54, 96, 17);
		label_1.setText("\u8BF7\u586B\u5199\u8BA2\u5355\u4FE1\u606F\uFF1A");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(51, 80, 33, 17);
		label_2.setText("\u59D3\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(90, 77, 73, 23);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(217, 80, 33, 17);
		label_3.setText("\u578B\u53F7");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(256, 77, 73, 23);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("\u65E5\u671F");
		label_4.setBounds(51, 116, 33, 17);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(90, 113, 96, 23);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(217, 116, 33, 17);
		label_5.setText("\u6570\u91CF");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(256, 113, 73, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con=null;
				Statement sql;
				con=Connect.Connetli();
				String tj="insert into sale values('"+text.getText()+"','"+text_1.getText()+"','"+text_2.getText()+"','"+text_3.getText()+"'"
						+ ",'"+text_4.getText()+"')";
				System.out.println(tj);
				try {
					sql=con.createStatement();
					sql.executeUpdate(tj);
					JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
					
				}
				catch (SQLException e1) {}
			}
		});
		button.setBounds(90, 188, 80, 27);
		button.setText("\u786E\u5B9A");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
				text_2.setText("");
				text_3.setText("");
			}
		});
		button_1.setBounds(217, 188, 80, 27);
		button_1.setText("\u91CD\u7F6E");
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(51, 145, 33, 17);
		label_6.setText("\u7535\u8BDD");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(90, 142, 135, 23);

	}
}
