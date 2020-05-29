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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class check {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			check window = new check();
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
		shell.setText("\u4EA7\u54C1");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 14, SWT.NORMAL));
		label.setBounds(174, 10, 84, 25);
		label.setText("\u4EA7\u54C1\u5217\u8868");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(31, 56, 370, 130);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(76);
		tblclmnNewColumn.setText("\u578B\u53F7");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(90);
		tableColumn.setText("\u540D\u79F0");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(93);
		tableColumn_1.setText("\u5355\u4EF7");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u5E93\u5B58");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new customer().main(null);
			}
		});
		button.setBounds(77, 209, 80, 27);
		button.setText("\u8BA2\u5355");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
			}
		});
		button_1.setBounds(237, 209, 80, 27);
		button_1.setText("\u9000\u51FA");
		
	//////≥ı ºªØ
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
