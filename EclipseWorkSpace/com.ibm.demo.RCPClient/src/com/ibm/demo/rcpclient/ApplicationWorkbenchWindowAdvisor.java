package com.ibm.demo.rcpclient;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ibm.demo.plugin1.resource.IResourceKey;
/**
 * 
 * @author Dong Yongzhao
 *
 */
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	private TrayItem trayItem;
	private Image trayImage;
	private ApplicationActionBarAdvisor actionBarAdvisor;
    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }
    //负责初始化菜单栏、工具栏
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
    	actionBarAdvisor= new ApplicationActionBarAdvisor(configurer);
        return actionBarAdvisor;
    }
    //在窗口打开前，声明哪些部件显示出来
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(800, 600));
        //菜单栏
        configurer.setShowMenuBar(true);
        //工具栏
        configurer.setShowCoolBar(true);
        //状态栏
        configurer.setShowStatusLine(true);
        //标题
//        configurer.setTitle("Client");
    }
    //窗口打开后初始化
    @Override
    public void postWindowOpen() {
    	// TODO Auto-generated method stub
    	super.postWindowOpen();
    	//添加状态栏:需要在ApplicationWorkbenchWindowAdvisor处声明 需要显示
    	getWindowConfigurer().getActionBarConfigurer().getStatusLineManager().setMessage("Test Status");
    	//添加系统托盘
    	final IWorkbenchWindow window=getWindowConfigurer().getWindow();
    	//新建一个项，并添加到系统的任务栏当中
    	trayItem = initTaskItem(window);
    	//若新建成功，为该项添加一些监听方法
    	if(trayItem!=null){
    		hookPopupMenu(window);
    		hookMinimize(window);
    	}
    }
    /********************设置程序可以系统托盘**********************/
    private TrayItem initTaskItem(IWorkbenchWindow window){
    	
    	final Tray tray = window.getShell().getDisplay().getSystemTray();
    	if(tray==null){
    		return null;
    	}
    	TrayItem trayItem = new TrayItem(tray,SWT.NONE);
    	trayImage = AbstractUIPlugin.imageDescriptorFromPlugin("com.ibm.demo.plugin1", 
    			IResourceKey.indexImg).createImage();
    	trayItem.setImage(trayImage);
    	trayItem.setToolTipText("Demo.");
    	return trayItem;
    }
    //最小化时隐藏窗口，任务栏选中时重新显示
    private void hookMinimize(final IWorkbenchWindow window){
    	window.getShell().addShellListener(new ShellAdapter(){
    		@Override
    		public void shellIconified(ShellEvent e) {
    			window.getShell().setVisible(false);
    		}
    	});
    	trayItem.addListener(SWT.DefaultSelection,new Listener(){

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				Shell shell = window.getShell();
				if(!shell.isVisible()){
					shell.setVisible(true);
					window.getShell().setMinimized(false);
				}
			}
    		
    	});
    }
    //为最小化时的任务添加一个Menu，右键时显示
    private void hookPopupMenu(final IWorkbenchWindow window){
    	trayItem.addListener(SWT.MenuDetect, new Listener(){

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				MenuManager trayMenu = new MenuManager();
				Menu menu = trayMenu.createContextMenu(window.getShell());
				actionBarAdvisor.fillTrayItem(trayMenu);
				menu.setVisible(true);
			}
    		
    	});
    }

    public void dispose(){
    	if(trayImage !=null){
    		trayImage.dispose();
    		trayItem.dispose();
    	}
    }
}

