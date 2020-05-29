package system;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.wb.swt.SWTResourceManager;

import mysql.Connect;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.TouchEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Xinzeng {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_3;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Xinzeng window = new Xinzeng();
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
		shell.setImage(SWTResourceManager.getImage(Xinzeng.class, "/image/\u56FE\u4E66\u9986.gif"));
		shell.setSize(450, 300);
		shell.setText("\u65B0\u589E\u56FE\u4E66");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(26, 10, 61, 17);
		label.setText("\u56FE\u4E66\u540D\u79F0");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(93, 7, 88, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(253, 10, 24, 17);
		label_1.setText("\u4F5C\u8005");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(294, 7, 73, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(253, 49, 33, 17);
		label_2.setText("\u6027\u522B");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(26, 49, 61, 17);
		label_3.setText("\u56FE\u4E66\u7C7B\u522B");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(26, 88, 61, 17);
		label_4.setText("\u63CF\u8FF0");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(26, 114, 341, 70);
		
		Button button = new Button(shell, SWT.NONE);
		
		
		button.setImage(SWTResourceManager.getImage(Xinzeng.class, "/image/\u6DFB\u52A01.ico"));
		button.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.BOLD));
		button.setBounds(26, 206, 119, 46);
		button.setText("\u6DFB\u52A0");
///		
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
		button_1.setImage(SWTResourceManager.getImage(Xinzeng.class, "/image/\u91CD\u7F6E.ico"));
		button_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.BOLD));
		button_1.setBounds(172, 206, 114, 46);
		button_1.setText("\u91CD\u7F6E");
//////		
		CCombo combo = new CCombo(shell, SWT.DROP_DOWN);

				Connection con;
				Statement sql;
				ResultSet rs;
				con=Connect.Connetli();
				String xz="SELECT bookTypeName FROM booktype";
				try {
					sql=con.createStatement();
					rs=sql.executeQuery(xz);
						while (rs.next())
						{
							String r=rs.getString(1);
							combo.add(r);
							
						}

				}
				catch(SQLException ee) {}
		combo.setBounds(93, 49, 125, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(294, 43, 73, 23);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				con=Connect.Connetli();
				Statement sql;
				int s=combo.getSelectionIndex()+1;

				try {
				
					sql=con.createStatement();
					String tj="insert into book values(null,'"+text.getText()+"','"+text_1.getText()+"','"+text_2.getText()+"','"+text_3.getText()+"','"+s+"')";
					sql.executeUpdate(tj);
					String b="insert into borrba values('"+text.getText()+"',Null,Null,0)";
					sql.executeUpdate(b);
					JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
				}
				catch (SQLException ee) {
					System.out.println("error!");
				}
				
			}
		});
	}
}
