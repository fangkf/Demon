package system;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Menu;

import java.awt.Image;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;

public class Mainsys {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Mainsys window = new Mainsys();
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
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		shell.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u56FE\u4E66\u9986.gif"));
		shell.setSize(999,576);
		shell.setText("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		shell.setLayout(null);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem menu1 = new MenuItem(menu, SWT.CASCADE);
		menu1.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406.ico"));
		menu1.setText("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		
		Menu menu_1 = new Menu(menu1);
		menu1.setMenu(menu_1);
		
		MenuItem menu11 = new MenuItem(menu_1, SWT.CASCADE);
		menu11.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406.png"));
		menu11.setText("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		
		Menu menu_2 = new Menu(menu11);
		menu11.setMenu(menu_2);
		///
		MenuItem menu111 = new MenuItem(menu_2, SWT.NONE);
		menu111.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B.png"));
		menu111.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new Tianjia().main(null);
			}
		});
		menu111.setText("\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B");
		///
		MenuItem menu112 = new MenuItem(menu_2, SWT.NONE);
		menu112.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u4FEE\u6539\u56FE\u7C7B.png"));
		menu112.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new Xiugai().main(null);
			}
		});
		menu112.setText("\u4FEE\u6539\u56FE\u4E66\u7C7B\u522B");
		
		MenuItem menu12 = new MenuItem(menu_1, SWT.CASCADE);
		menu12.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406.png"));
		menu12.setText("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		
		Menu menu_3 = new Menu(menu12);
		menu12.setMenu(menu_3);
		///
		MenuItem menu121 = new MenuItem(menu_3, SWT.NONE);
		menu121.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u6DFB\u52A0\u56FE\u4E66.png"));
		menu121.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new Xinzeng().main(null);
			}
		});
		menu121.setText("\u65B0\u589E\u56FE\u4E66");
		///
		MenuItem menu122 = new MenuItem(menu_3, SWT.NONE);
		menu122.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u4FEE\u6539\u56FE\u4E66.png"));
		menu122.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new Check().main(null);
			}
		});
		menu122.setText("\u56FE\u4E66\u67E5\u8BE2\u4FEE\u6539");
		
		MenuItem menu13 = new MenuItem(menu_1, SWT.NONE);
		menu13.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u9000\u51FA\u7CFB\u7EDF.png"));
		menu13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		menu13.setText("\u9000\u51FA\u7CFB\u7EDF");
		
		MenuItem menu3 = new MenuItem(menu, SWT.CASCADE);
		menu3.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u501F\u8FD8\u7CFB\u7EDF.png"));
		menu3.setText("\u501F\u4E66\u8FD8\u4E66\u7CFB\u7EDF");
		
		Menu menu_5 = new Menu(menu3);
		menu3.setMenu(menu_5);
		
		MenuItem mntmNewItem = new MenuItem(menu_5, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new borrow().main(null);
			}
		});
		mntmNewItem.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u501F\u4E66.png"));
		mntmNewItem.setText("\u501F\u4E66\u67E5\u8BE2");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu_5, SWT.NONE);
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new back().main(null);
			}
		});
		mntmNewItem_1.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u8FD8\u4E66.png"));
		mntmNewItem_1.setText("\u8FD8\u4E66\u5165\u53E3");
		
		MenuItem menu2 = new MenuItem(menu, SWT.CASCADE);
		menu2.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u95EE\u53F7.ico"));
		menu2.setText("\u5E2E\u52A9");
		
		Menu menu_4 = new Menu(menu2);
		menu2.setMenu(menu_4);
		
		MenuItem mntmNewSubmenu_4 = new MenuItem(menu_4, SWT.CASCADE);
		mntmNewSubmenu_4.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u7BA1\u7406\u5458.png"));
		///
		mntmNewSubmenu_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JOptionPane.showMessageDialog(null, "fangkf tel:131********");
			}
		});
		mntmNewSubmenu_4.setText("\u7BA1\u7406\u5458\u4FE1\u606F");
		
		MenuItem mntmNewItem_4 = new MenuItem(menu_4, SWT.NONE);
		mntmNewItem_4.setImage(SWTResourceManager.getImage(Mainsys.class, "/image/\u7CFB\u7EDF\u7B80\u4ECB.png"));
		mntmNewItem_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JOptionPane.showMessageDialog(null, "点击信息管理，选择相应的操作可以打开相应的页面，可以进行添加、修改、删除等操作");
			}
		});
		mntmNewItem_4.setText("\u7CFB\u7EDF\u64CD\u4F5C\u7B80\u4ECB");
		
		Composite composite = new Composite(shell, SWT.NO_BACKGROUND|SWT.DOUBLE_BUFFERED);
		composite.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				org.eclipse.swt.graphics.Image im=SWTResourceManager.getImage(getClass(), "/image/背景1.jpg");
				arg0.gc.setAdvanced(true);
				arg0.gc.setAntialias(SWT.ON);
				arg0.gc.drawImage(im, 0, 0, im.getBounds().width, im.getBounds().height, 0, 0, composite.getBounds().width, composite.getBounds().height);
			}
		});
		composite.setBounds(0, 0, 1000,519);

	}
}
