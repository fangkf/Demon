package factory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class product {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			product window = new product();
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
		shell.setText("\u4EA7\u54C1\u7BA1\u7406");
		shell.setSize(450, 300);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 14, SWT.BOLD | SWT.ITALIC));
		lblNewLabel.setBounds(168, 10, 87, 26);
		lblNewLabel.setText("\u4EA7\u54C1\u5217\u8868");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new pro().main(null);
			}
		});
		btnNewButton_1.setBounds(82, 213, 80, 27);
		btnNewButton_1.setText("\u4EA7\u54C1\u589E\u5220");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(241, 213, 80, 27);
		btnNewButton_2.setText("\u9000\u51FA");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(38, 65, 339, 142);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(89);
		tblclmnNewColumn.setText("\u578B\u53F7");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(87);
		tblclmnNewColumn_1.setText("\u540D\u79F0");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(79);
		tblclmnNewColumn_2.setText("\u5355\u4EF7");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(76);
		tblclmnNewColumn_3.setText("\u5E93\u5B58");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection c;
				Statement s;
				ResultSet r;
				c=Connect.Connetli();
				String cs="SELECT * FROM product";
				try {
					s=c.createStatement();
					r=s.executeQuery(cs);
					TableItem tableItems[] = table.getItems();//得到所有的tableItem
			            for(int i = 0; i<tableItems.length; i++)
			            {
			                tableItems[i].dispose();//释放
			            }
					while (r.next()) {
						
						String [] record={r.getString("pID"),r.getString("pName"),r.getString("price"),r.getString("num")};
						TableItem item=new TableItem(table,SWT.LEFT);
						item.setText(record);
					}
				}
				catch (SQLException ee) {}
			}
		});
		btnNewButton.setBounds(295, 38, 80, 27);
		btnNewButton.setText("\u5237\u65B0");
	//////初始化
					Connection c;
					Statement s;
					ResultSet r;
					c=Connect.Connetli();
					String cs="SELECT * FROM product";
					try {
						s=c.createStatement();
						r=s.executeQuery(cs);
						while (r.next()) {
							
							String [] record={r.getString("pID"),r.getString("pName"),r.getString("price"),r.getString("num")};
							TableItem item=new TableItem(table,SWT.LEFT);
							item.setText(record);
						}
					}
					catch (SQLException ee) {}
	}
}
