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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class back {

	protected Shell shell;
	private Text text;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			back window = new back();
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
		shell.setImage(SWTResourceManager.getImage(back.class, "/image/\u56FE\u4E66\u9986.gif"));
		shell.setSize(450, 300);
		shell.setText("\u8FD8\u4E66\u5165\u53E3");
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label.setFont(SWTResourceManager.getFont("微软雅黑", 13, SWT.BOLD | SWT.ITALIC));
		label.setBounds(148, 0, 85, 24);
		label.setText("\u611F\u8C22\u4F7F\u7528\uFF01");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(98, 38, 31, 17);
		lblNewLabel.setText("\u4E66\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(148, 35, 85, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection c;
				Statement s;
				ResultSet r;
				c=Connect.Connetli();
				String cs="SELECT bName,uName,date FROM borrba WHERE bName='"+text.getText()+"'";
				try {
					s=c.createStatement();
					r=s.executeQuery(cs);
					while (r.next()) {
						
						String [] record={r.getString("bName"),r.getString("uName"),r.getString("")};
						TableItem item=new TableItem(table,SWT.LEFT);
						item.setText(record);
					}
				}
				catch (SQLException ee) {}
			}
		});
		button.setBounds(259, 33, 80, 27);
		button.setText("\u786E\u5B9A");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 77, 414, 99);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u4E66\u540D");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u501F\u4E66\u4EBA");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u501F\u4E66\u65E5\u671F");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u72B6\u6001");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection c;
				Statement s;
				ResultSet r;
				c=Connect.Connetli();
				String cs="SELECT * FROM borrba WHERE bName like '"+text.getText()+"'";
				try {
					s=c.createStatement();
					r=s.executeQuery(cs);
					while (r.next()) {
						 TableItem tableItems[] = table.getItems();//得到所有的tableItem
				            for(int i = 0; i<tableItems.length; i++)
				            {
				                tableItems[i].dispose();//释放
				            }
						String [] record={r.getString("bName"),r.getString("uName"),r.getString("date"),r.getString("bandb")};
						TableItem item=new TableItem(table,SWT.LEFT);
						item.setText(record);
					}
				}
				catch (SQLException ee) {
					System.out.println("异常！");
				}
			}
		});
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage(back.class, "/image/\u8FD8\u4E66\u786E\u8BA4.png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				Statement sql;
				con=Connect.Connetli();
				try {
					sql=con.createStatement();
					String zt="update borrba set bandb=0 where bName='"+text.getText()+"'";
					sql.executeUpdate(zt);
					String u="update borrba set uName=Null where bName='"+text.getText()+"'";
					sql.executeUpdate(u);
					String da="update borrba set date=Null where bName='"+text.getText()+"'";
					sql.executeUpdate(da);
					JOptionPane.showMessageDialog(null, "已归还图书");
					text.setText("");
				}
				catch (SQLException ee) {
					System.out.println("异常！");
				}
			}
		});
		button_1.setBounds(174, 194, 73, 58);

	}
}
