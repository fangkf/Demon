package factory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class pro {

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
			pro window = new pro();
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
		lblNewLabel.setBounds(23, 10, 61, 17);
		lblNewLabel.setText("\u4EA7\u54C1\u589E\u52A0");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(10, 46, 30, 17);
		lblNewLabel_1.setText("\u578B\u53F7");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(46, 40, 61, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(128, 46, 30, 17);
		label.setText("\u540D\u79F0");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(173, 40, 61, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(10, 72, 30, 17);
		label_1.setText("\u5355\u4EF7");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(46, 69, 61, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(128, 72, 30, 17);
		label_2.setText("\u5E93\u5B58");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(172, 69, 61, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con=null;
				Statement sql;
				con=Connect.Connetli();
				String tj="insert into product values('"+text.getText()+"','"+text_1.getText()+"','"+text_2.getText()+"','"+text_3.getText()+"')";
				System.out.println(tj);
				try {
					sql=con.createStatement();
					sql.executeUpdate(tj);
					JOptionPane.showMessageDialog(null, "添加成功");
					
				}
				catch (SQLException e1) {}
			}
		});
		button.setBounds(277, 62, 80, 27);
		button.setText("\u6DFB\u52A0");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(23, 135, 61, 17);
		label_3.setText("\u4EA7\u54C1\u5220\u9664");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(23, 178, 84, 17);
		label_4.setText("\u8F93\u5165\u4EA7\u54C1\u7F16\u53F7");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(128, 172, 73, 23);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				Statement sql;
				con=Connect.Connetli();
				String sc="delete from product where pID='"+text_4.getText()+"'";
				try {
					sql=con.createStatement();
					sql.executeUpdate(sc);
					JOptionPane.showMessageDialog(null, "删除成功");
					
				}
				catch (SQLException e1) {}
			}
		});
		button_1.setBounds(277, 172, 80, 27);
		button_1.setText("\u5220\u9664");

	}
}
