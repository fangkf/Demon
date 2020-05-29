package system;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import mysql.Connect;

import org.eclipse.swt.widgets.Composite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Check {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Table table;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Check window = new Check();
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
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\Administrator.PC-20170809ZOZR\\Desktop\\\u5B9E\u9A8C\u62A5\u544A\\Java\\\u5927\u4F5C\u4E1A\\image\\\u56FE\u4E66\u9986.gif"));
		shell.setSize(566, 378);
		shell.setText("\u56FE\u4E66\u67E5\u8BE2\u4FEE\u6539");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 10, 530, 83);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBounds(10, 24, 36, 17);
		label_1.setText("\u540D\u79F0");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(52, 21, 93, 23);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(151, 24, 36, 17);
		lblNewLabel.setText("\u4F5C\u8005");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(193, 21, 73, 23);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBounds(272, 24, 74, 17);
		label_2.setText("\u56FE\u4E66\u7C7B\u522B\u7F16\u53F7");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(352, 21, 113, 23);
		
		Button button = new Button(composite, SWT.NONE);
		button.setImage(SWTResourceManager.getImage(Check.class, "/image/check.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				Statement sql;
				ResultSet rs;
				con=Connect.Connetli();
				String cx="SELECT * FROM book WHERE bookName like '"+text.getText()+"'";
				try {
					sql=con.createStatement();
					rs=sql.executeQuery(cx);
					while(rs.next()) {
						TableItem tableItems[] = table.getItems();//得到所有的tableItem
			            for(int i = 0; i<tableItems.length; i++)
			            {
			                tableItems[i].dispose();//释放
			            }
						String[] record= {rs.getString("id"),rs.getString("bookName"),rs.getString("author"),rs.getString("sex"),rs.getString("bookDesc"),rs.getString("bookTypeid")};
				         TableItem item=new TableItem(table,SWT.LEFT);
				         item.setText(record);
					}
				}
				catch (SQLException ee) {}
			}
		});
		button.setBounds(233, 50, 118, 33);
		button.setText("\u67E5\u8BE2");
		
		Label label_9 = new Label(composite, SWT.NONE);
		label_9.setBounds(10, 55, 30, 17);
		label_9.setText("\u6027\u522B");
		
		text_7 = new Text(composite, SWT.BORDER);
		text_7.setBounds(46, 50, 73, 23);
		
		Label label = new Label(composite, SWT.NONE);
		label.setBounds(10, 1, 61, 17);
		label.setText("\u56FE\u4E66\u67E5\u8BE2");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 99, 530, 115);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(44);
		tblclmnId.setText("id");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("bookName");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("author");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(46);
		tblclmnNewColumn_2.setText("sex");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(138);
		tblclmnNewColumn_3.setText("bookDesc");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(98);
		tblclmnNewColumn_4.setText("bookTypeid");
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setBounds(10, 220, 530, 120);
		
		Label label_3 = new Label(composite_1, SWT.NONE);
		label_3.setBounds(0, 0, 61, 17);
		label_3.setText("\u56FE\u4E66\u4FEE\u6539");
		
		Label label_5 = new Label(composite_1, SWT.NONE);
		label_5.setBounds(0, 23, 35, 17);
		label_5.setText("\u540D\u79F0");
		
		text_4 = new Text(composite_1, SWT.BORDER);
		text_4.setBounds(30, 20, 73, 23);
		
		Label label_6 = new Label(composite_1, SWT.NONE);
		label_6.setBounds(0, 47, 24, 17);
		label_6.setText("\u4F5C\u8005");
		
		text_5 = new Text(composite_1, SWT.BORDER);
		text_5.setBounds(30, 44, 73, 23);
		
		Label label_7 = new Label(composite_1, SWT.NONE);
		label_7.setBounds(120, 23, 35, 17);
		label_7.setText("\u7C7B\u522B");
		
		CCombo combo = new CCombo(composite_1, SWT.BORDER);
		combo.setBounds(161, 19, 94, 21);
//////////		
		Connection con;
		Statement sql;
		ResultSet rs;
		con=Connect.Connetli();
		String xz="SELECT bookTypeName FROM booktype";
		try {
			sql=con.createStatement();
			rs=sql.executeQuery(xz);
				while (rs.next())
				{
					String r=rs.getString(1);
					combo.add(r);
					
				}

		}
		catch(SQLException ee) {}
		
		Label label_8 = new Label(composite_1, SWT.NONE);
		label_8.setBounds(282, 23, 35, 17);
		label_8.setText("\u63CF\u8FF0");
		
		text_6 = new Text(composite_1, SWT.BORDER);
		text_6.setBounds(284, 44, 236, 66);
		
		Button button_1 = new Button(composite_1, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage(Check.class, "/image/\u786E\u5B9A.ico"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection con;
				Statement sql;
				ResultSet rs;
				con=Connect.Connetli();
				String cx="SELECT * FROM book WHERE bookName like '"+text.getText()+"'";
				try {
					sql=con.createStatement();
					
					rs=sql.executeQuery(cx);
					rs.next();
					int s=rs.getInt("id");
					String a="update book set bookName='"+text_4.getText()+"' where id="+s;
					sql.executeUpdate(a);
					String b="update book set author='"+text_5.getText()+"' where id="+s;
					sql.executeUpdate(b);
					String c="update book set sex='"+text_8.getText()+"' where id="+s;
					sql.executeUpdate(c);
					String d="update book set bookDesc='"+text_6.getText()+"' where id="+s;
					sql.executeUpdate(d);
					int aa=combo.getSelectionIndex()+1;
					String f="update book set bookTypeid='"+aa+"' where id="+s;
					sql.executeUpdate(f);
					JOptionPane.showMessageDialog(null, "修改成功");
				}
				catch (SQLException ee) {
					System.out.println("异常！");
				}
			}
		});
		button_1.setBounds(58, 73, 51, 46);
		
		Button button_2 = new Button(composite_1, SWT.NONE);
		button_2.setImage(SWTResourceManager.getImage(Check.class, "/image/\u91CD\u7F6E.ico"));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
				text_2.setText("");
				text_7.setText("");
				text_4.setText("");
				text_5.setText("");
				text_6.setText("");
				text_8.setText("");
			}
		});
		button_2.setBounds(169, 73, 51, 46);
		
		Label label_10 = new Label(composite_1, SWT.NONE);
		label_10.setBounds(120, 47, 35, 17);
		label_10.setText("\u6027\u522B");
		
		text_8 = new Text(composite_1, SWT.BORDER);
		text_8.setBounds(159, 44, 73, 23);
	///////初始化
		Connection c;
		Statement s;
		ResultSet r;
		c=Connect.Connetli();
		String cs="SELECT * FROM book ";
		try {
			s=c.createStatement();
			r=s.executeQuery(cs);
			while(r.next()) {

				String[] record= {r.getString("id"),r.getString("bookName"),r.getString("author"),r.getString("sex"),r.getString("bookDesc"),r.getString("bookTypeid")};
		         TableItem item=new TableItem(table,SWT.LEFT);
		         item.setText(record);
			}
		}
		catch (SQLException ee) {}

	}
}
