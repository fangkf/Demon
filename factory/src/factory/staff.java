package factory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class staff {

	protected Shell shell;
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			staff window = new staff();
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
		shell.setText("\u4EBA\u5458\u7BA1\u7406");
		shell.setSize(450, 300);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(36, 0, 364, 92);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setText("\u7F16\u53F7");
		tblclmnNewColumn.setWidth(69);
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("\u59D3\u540D");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(90);
		tblclmnNewColumn_2.setText("\u6027\u522B");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("\u90E8\u95E8");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 98, 55, 17);
		label.setText("\u4EBA\u5458\u6DFB\u52A0");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(10, 121, 29, 17);
		label_1.setText("\u59D3\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(45, 121, 73, 23);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(136, 121, 29, 17);
		lblNewLabel.setText("\u6027\u522B");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(179, 121, 73, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(272, 121, 29, 17);
		label_2.setText("\u90E8\u95E8");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(332, 121, 73, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con=null;
				Statement sql;
				con=Connect.Connetli();
				String tj="insert into staff values(null,'"+text.getText()+"','"+text_1.getText()+"','"+text_2.getText()+"')";
				System.out.println(tj);
				try {
					sql=con.createStatement();
					sql.executeUpdate(tj);
					JOptionPane.showMessageDialog(null, "添加成功");
					
				}
				catch (SQLException e1) {}
			}
		});
		button.setBounds(221, 150, 80, 27);
		button.setText("\u6DFB\u52A0");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(10, 189, 61, 17);
		label_3.setText("\u4EBA\u5458\u5220\u9664");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(10, 212, 61, 17);
		label_4.setText("\u8F93\u5165\u7F16\u53F7");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(92, 212, 73, 23);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				Statement sql;
				con=Connect.Connetli();
				String sc="delete from staff where ID='"+text_3.getText()+"'";
				try {
					sql=con.createStatement();
					sql.executeUpdate(sc);
					JOptionPane.showMessageDialog(null, "删除成功");
					
				}
				catch (SQLException e1) {}
			}
		});
		button_1.setBounds(207, 208, 80, 27);
		button_1.setText("\u5220\u9664");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
			}
		});
		button_2.setBounds(332, 202, 73, 50);
		button_2.setText("\u9000\u51FA\u7CFB\u7EDF");
		
		Connection c;
		Statement s;
		ResultSet r;
		c=Connect.Connetli();
		String cs="SELECT * FROM staff";
		try {
			s=c.createStatement();
			r=s.executeQuery(cs);
			while (r.next()) {
				
				String [] record={r.getString("ID"),r.getString("name"),r.getString("sex"),r.getString("department")};
				TableItem item=new TableItem(table,SWT.LEFT);
				item.setText(record);
			}
		}
		catch (SQLException ee) {}
	}

}
