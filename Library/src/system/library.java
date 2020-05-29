package system;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mysql.Connect;
import javax.swing.*;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;

public class library {

	protected Shell shell;
	private Text text;
	private Text text_1;
	public static Connect con;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			library window = new library();
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
		shell.setImage(SWTResourceManager.getImage(library.class, "/image/\u56FE\u4E66\u9986.gif"));
		shell.setSize(450, 325);
		shell.setText("\u7CFB\u7EDF\u767B\u5F55");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				org.eclipse.swt.graphics.Image im=SWTResourceManager.getImage(getClass(), "/image/背景2.jpg");
				arg0.gc.setAdvanced(true);
				arg0.gc.setAntialias(SWT.ON);
				arg0.gc.drawImage(im, 0, 0, im.getBounds().width, im.getBounds().height, 0, 0, composite.getBounds().width, composite.getBounds().height);
			}
		});
		composite.setBounds(0, 0, 434, 287);
		
		text = new Text(composite, SWT.BORDER);
		text.setLocation(163, 89);
		text.setSize(120, 23);
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
		

		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLocation(162, 138);
		text_1.setSize(120, 23);
		///text_1
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
							rs=sql.executeQuery("SELECT * FROM user");
							rs.last();
							int f=rs.getRow();
							rs.beforeFirst();
							while (rs.next()) {
								//int  id=rs.getInt(1);
								String usern=rs.getString(2);
								String passw=rs.getString(3);
								if(e.keyCode==13) {					
									if(text.getText().equals(""+usern+"")&&text_1.getText().equals(""+passw+"")) {
										JOptionPane.showMessageDialog(null, "登录成功!");
										shell.setVisible(false);//隐藏窗口
										new Mainsys().main(null);
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

				char echo='*';
				text_1.setEchoChar(echo);
		///
		Button button = new Button(composite, SWT.NONE);
		button.setLocation(99, 206);
		button.setSize(80, 27);
		///button
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Statement sql;
				Connection con=null;
				ResultSet rs;
				con=Connect.Connetli();
				if(con==null) return;
				try {
					sql=con.createStatement();
					rs=sql.executeQuery("SELECT * FROM user");
					rs.last();
					int f=rs.getRow();
					rs.beforeFirst();
					while (rs.next()) {
						//int  id=rs.getInt(1);
						String usern=rs.getString(2);
						String passw=rs.getString(3);
			            if(text.getText().equals("")||text_1.getText().equals("")) {
			            	JOptionPane.showMessageDialog(null, "用户名和密码不能为空！","错误",JOptionPane.ERROR_MESSAGE); 
			            }
			            else {
			            	if(text.getText().equals(""+usern+"")&&text_1.getText().equals(""+passw+"")) {
			            		JOptionPane.showMessageDialog(null, "登录成功!");
			            		shell.setVisible(false);
			            		new Mainsys().main(null);
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
		button.setText("\u767B\u5F55");
		////
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setLocation(232, 208);
		button_1.setSize(80, 27);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
			}
		});
		button_1.setText("\u91CD\u7F6E");
		
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setLocation(132, 141);
		label_2.setSize(24, 17);
		label_2.setText("\u5BC6\u7801");
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setLocation(302, 93);
		label_3.setSize(61, 17);
		label_3.setFont(SWTResourceManager.getFont("微软雅黑", 9, SWT.ITALIC));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new zhuce().main(null);
			}
		});
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		label_3.setText("\u7528\u6237\u6CE8\u518C");
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setLocation(118, 90);
		label_1.setSize(39, 17);
		label_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label_1.setText("\u7528\u6237\u540D");


	}
}
