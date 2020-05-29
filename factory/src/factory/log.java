package factory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;


import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class log {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			log window = new log();
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
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 14, SWT.BOLD | SWT.ITALIC));
		lblNewLabel.setBounds(140, 24, 132, 30);
		lblNewLabel.setText("\u4EA7\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(88, 79, 36, 17);
		label.setText("\u7528\u6237\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode==13) {
					if(text.getText().equals("")||text_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "用户名和密码不能为空！");
					}
				}
			}
		});
		text.setBounds(140, 73, 132, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(88, 115, 36, 17);
		label_1.setText("\u5BC6\u7801");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Statement sql;
				Connection con=null;
				ResultSet rs;
				con=Connect.Connetli();
				if(con==null) return;
				try {
					sql=con.createStatement();
					rs=sql.executeQuery("SELECT * FROM admini");
					rs.last();
					int f=rs.getRow();
					rs.beforeFirst();
					while (rs.next()) {
						//int  id=rs.getInt(1);
						String usern=rs.getString(1);
						String passw=rs.getString(2);
						if(e.keyCode==13) {					
							if(text.getText().equals(""+usern+"")&&text_1.getText().equals(""+passw+"")) {
								JOptionPane.showMessageDialog(null, "登录成功!");
								shell.setVisible(false);//隐藏窗口
								new administrator().main(null);
							}
							else {
								if(f==rs.getRow())
									JOptionPane.showMessageDialog(null, "用户名或者密码输入错误！","错误",JOptionPane.ERROR_MESSAGE);
							}					
						}
					}
				}
				catch(SQLException ee) {}
				
			}
		});
		text_1.setBounds(140, 112, 132, 23);
		char echo='*';
		text_1.setEchoChar(echo);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Statement sql;
				Connection con=null;
				ResultSet rs;
				con=Connect.Connetli();
				if(con==null) return;
				try {
					sql=con.createStatement();
					rs=sql.executeQuery("SELECT * FROM admini");
					rs.last();
					int f=rs.getRow();
					rs.beforeFirst();
					while (rs.next()) {
						//int  id=rs.getInt(1);
						String usern=rs.getString(1);
						String passw=rs.getString(2);
			            if(text.getText().equals("")||text_1.getText().equals("")) {
			            	JOptionPane.showMessageDialog(null, "用户名和密码不能为空！","错误",JOptionPane.ERROR_MESSAGE); 
			            }
			            else {
			            	if(text.getText().equals(""+usern+"")&&text_1.getText().equals(""+passw+"")) {
			            		JOptionPane.showMessageDialog(null, "登录成功!");
			            		shell.setVisible(false);
			            		new administrator().main(null);
			            	}
			            	else {
			            		if(f==rs.getRow())
			            			JOptionPane.showMessageDialog(null, "用户名或者密码输入错误！","错误",JOptionPane.ERROR_MESSAGE);
			            	}
			            }
					}
				}
				catch(SQLException ee) {}
			}
		});
		btnNewButton.setBounds(78, 166, 80, 27);
		btnNewButton.setText("\u767B\u5F55");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
			}
		});
		btnNewButton_1.setBounds(188, 166, 80, 27);
		btnNewButton_1.setText("\u91CD\u7F6E");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new check().main(null);
			}
		});
		btnNewButton_2.setBounds(316, 166, 80, 27);
		btnNewButton_2.setText("\u987E\u5BA2\u8BA2\u8D2D\u5165\u53E3");

	}
}
