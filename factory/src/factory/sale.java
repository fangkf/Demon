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

public class sale {

	protected Shell shell;
	private Table table;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			sale window = new sale();
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
		shell.setSize(466, 300);
		shell.setText("\u8BA2\u5355\u7BA1\u7406");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 430, 117);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(80);
		tblclmnNewColumn.setText("\u987E\u5BA2\u59D3\u540D");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(74);
		tblclmnNewColumn_1.setText("\u4EA7\u54C1\u578B\u53F7");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("\u8D2D\u4E70\u65E5\u671F");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(70);
		tblclmnNewColumn_3.setText("\u6570\u91CF");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u7535\u8BDD\u53F7\u7801");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 133, 61, 17);
		label.setText("\u5220\u9664\u8BA2\u5355");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(10, 156, 80, 17);
		label_1.setText("\u8F93\u5165\u987E\u5BA2\u59D3\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(96, 150, 73, 23);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(208, 156, 38, 17);
		lblNewLabel.setText("\u578B\u53F7");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(252, 153, 73, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				Statement sql;
				con=Connect.Connetli();
				String sc="delete from sale where uName='"+text.getText()+"'";
				try {
					sql=con.createStatement();
					sql.executeUpdate(sc);
					JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");
					
				}
				catch (SQLException e1) {}
			}
		});
		button.setBounds(55, 199, 80, 27);
		button.setText("\u786E\u5B9A");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
			}
		});
		button_1.setBounds(183, 199, 80, 27);
		button_1.setText("\u91CD\u7F6E");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
			}
		});
		button_2.setBounds(298, 199, 80, 27);
		button_2.setText("\u9000\u51FA");
		
		Connection c;
		Statement s;
		ResultSet r;
		c=Connect.Connetli();
		String cs="SELECT * FROM sale";
		try {
			s=c.createStatement();
			r=s.executeQuery(cs);
			while (r.next()) {
				
				String [] record={r.getString("uName"),r.getString("pID"),r.getString("date"),r.getString("Num"),r.getString("Tal")};
				TableItem item=new TableItem(table,SWT.LEFT);
				item.setText(record);
			}
		}
		catch (SQLException ee) {}
	}

}
