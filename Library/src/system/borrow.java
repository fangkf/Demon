package system;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import mysql.Connect;

import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class borrow {

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
			borrow window = new borrow();
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
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shell.setImage(SWTResourceManager.getImage(borrow.class, "/image/\u56FE\u4E66\u9986.gif"));
		shell.setSize(450, 300);
		shell.setText("\u501F\u4E66\u67E5\u8BE2\u767B\u8BB0");
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 14, SWT.BOLD | SWT.ITALIC));
		label.setBounds(119, 28, 206, 26);
		label.setText("\u6B22\u8FCE\u4F7F\u7528\u501F\u4E66\u767B\u8BB0\u7CFB\u7EDF");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(64, 79, 35, 17);
		label_1.setText("\u4E66\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(105, 76, 104, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				Statement sql;
				ResultSet rs;
				con=Connect.Connetli();
				String cc="SELECT bandb FROM borrba WHERE bName like '"+text.getText()+"'";
				try {
					sql=con.createStatement();
					rs=sql.executeQuery(cc);
					rs.next();
					int c=rs.getInt("bandb");
					System.out.println(c);
					if(c==0)
						JOptionPane.showMessageDialog(null, "ªπŒ¥ΩË≥ˆ");
					else JOptionPane.showMessageDialog(null, "“—ΩË≥ˆ");
				}
				catch (SQLException ee) {
					System.out.println("“Ï≥££°");
				}
			}
		});
		button.setImage(SWTResourceManager.getImage(borrow.class, "/image/check.png"));
		button.setBounds(239, 68, 104, 38);
		button.setText("\u67E5\u8BE2");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 125, 434, 137);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		label_2.setBounds(10, 0, 55, 17);
		label_2.setText("\u767B\u8BB0\u4FE1\u606F");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblNewLabel.setBounds(88, 29, 32, 17);
		lblNewLabel.setText("\u59D3\u540D");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(126, 26, 91, 23);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblNewLabel_1.setBounds(64, 59, 61, 17);
		lblNewLabel_1.setText("\u501F\u4E66\u65E5\u671F");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(126, 56, 91, 23);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(borrow.class, "/image/\u786E\u5B9A.ico"));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				Statement sql;
				con=Connect.Connetli();
				
				
				try {
					sql=con.createStatement();
					String in="update borrba set uName='"+text_1.getText()+"' where bName='"+text.getText()+"'";
					sql.executeUpdate(in);
					String inn="update borrba set date='"+text_2.getText()+"' where bName='"+text.getText()+"'";
					sql.executeUpdate(inn);
					String zt="update borrba set bandb=1 where bName='"+text.getText()+"'";
					sql.executeUpdate(zt);
					JOptionPane.showMessageDialog(null, "“—ΩË”√Õº È");
				}
				catch (SQLException ee) {
					System.out.println("“Ï≥££°");
				}
			}
		});
		btnNewButton.setBounds(77, 90, 97, 37);
		btnNewButton.setText("\u786E\u5B9A");
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage(borrow.class, "/image/\u91CD\u7F6E.ico"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
				text_2.setText("");
			}
		});
		button_1.setBounds(209, 90, 91, 37);
		button_1.setText("\u91CD\u7F6E");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 9, SWT.BOLD | SWT.ITALIC));
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_2.setBounds(229, 59, 91, 17);
		lblNewLabel_2.setText("(XXXX-XX-XX)");

	}
}
