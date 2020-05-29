package system;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import mysql.Connect;

import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.TableCursor;

public class Xiugai {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Table table;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Xiugai window = new Xiugai();
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
		shell.setImage(SWTResourceManager.getImage(Xiugai.class, "/image/\u56FE\u4E66\u9986.gif"));
		shell.setSize(482, 359);
		shell.setText("\u67E5\u8BE2\u4FEE\u6539\u7C7B\u522B");
	
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(28, 20, 61, 17);
		label.setText("\u7C7B\u522B\u540D\u79F0");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(102, 17, 145, 23);
		/////
		Button check = new Button(shell, SWT.NONE);
		check.setFont(SWTResourceManager.getFont("微软雅黑", 11, SWT.BOLD));
		check.setImage(SWTResourceManager.getImage(Xiugai.class, "/image/\u67E5\u627E.ico"));
		check.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con=null;
				Statement sql;
				ResultSet rs;

				con=Connect.Connetli();
				String cx="SELECT * FROM booktype WHERE bookTypeName like '"+text.getText()+"'";
				try {
					sql=con.createStatement();
					rs=sql.executeQuery(cx);
		
					while(rs.next()) {
						 TableItem tableItems[] = table.getItems();//得到所有的tableItem
				            for(int i = 0; i<tableItems.length; i++)
				            {
				                tableItems[i].dispose();//释放
				            }

				         String[] record= {rs.getString("id"),rs.getString("bookTypeName"),rs.getString("bookTypeDesc")};
				         TableItem item=new TableItem(table,SWT.LEFT);
				         item.setText(record);
					}
					
				}
				catch (SQLException ee) {}
				
			}
		});
		check.setBounds(308, 0, 113, 54);
		check.setText("\u67E5\u8BE2");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(28, 168, 88, 17);
		label_1.setText("\u56FE\u4E66\u7C7B\u522B\u4FEE\u6539");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(55, 191, 61, 17);
		label_2.setText("\u4FEE\u6539\u540D\u79F0");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(134, 188, 113, 23);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(55, 219, 61, 17);
		label_3.setText("\u63CF\u8FF0");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(121, 216, 251, 55);
/////
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage(Xiugai.class, "/image/\u786E\u5B9A.ico"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con=null;
				con=Connect.Connetli();
				Statement sql;
				ResultSet rs;
				String cx="SELECT * FROM booktype WHERE bookTypeName like '"+text.getText()+"'";
				try {
					sql=con.createStatement();
					
					rs=sql.executeQuery(cx);
					rs.next();
					int s=rs.getInt("id");
					String xg="update booktype set bookTypeName='"+text_1.getText()+"' where id="+s;
					sql.executeUpdate(xg);
					String up="update booktype set bookTypeDesc='"+text_2.getText()+"' where id="+s;
					sql.executeUpdate(up);
					JOptionPane.showMessageDialog(null, "修改成功");
				}
				catch (SQLException ee) {
					System.out.println("异常！");
				}
				
			}
		});
		button.setBounds(69, 277, 88, 44);
		button.setText("\u786E\u5B9A");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage(Xiugai.class, "/image/\u91CD\u7F6E.ico"));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_1.setText("");
				text_2.setText("");
			}
		});
		btnNewButton_1.setBounds(212, 277, 88, 44);
		btnNewButton_1.setText("\u91CD\u7F6E");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(28, 60, 411, 106);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("id");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(120);
		tblclmnNewColumn_1.setText("bookTypeName");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(187);
		tblclmnNewColumn_2.setText("bookTypeDesc");
	//////初始化
				Connection c;
				Statement s;
				ResultSet r;
				c=Connect.Connetli();
				String cs="SELECT * FROM booktype";
				try {
					s=c.createStatement();
					r=s.executeQuery(cs);
					while (r.next()) {
						
						String [] record={r.getString("id"),r.getString("bookTypeName"),r.getString("bookTypeDesc")};
						TableItem item=new TableItem(table,SWT.LEFT);
						item.setText(record);
					}
				}
				catch (SQLException ee) {}
	}
}
