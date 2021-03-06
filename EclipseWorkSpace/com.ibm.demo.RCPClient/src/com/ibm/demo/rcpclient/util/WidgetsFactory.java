package com.ibm.demo.rcpclient.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
/**
 * SWT���ѧϰ
 * @author Dong Yongzhao
 *
 */
public class WidgetsFactory {
	public static Text createText(Composite parent,int style,String labelname){
		Text text=null;
		Label label=new Label(parent,SWT.RIGHT);
		label.setText(labelname+":");
		GridData layoutData = new GridData(SWT.END,
				SWT.CENTER,true,false);
		label.setLayoutData(layoutData);
		text=new Text(parent,SWT.FILL);	
		layoutData = new GridData(SWT.CENTER,
					SWT.CENTER,true,false);
		text.setLayoutData(layoutData);	
		return text;
	}
	public static Menu createMenu(Decorations parent,int style,MenuItem parentMenuItem){
		Menu subMenu;	
		if(parentMenuItem!=null){
			subMenu=new Menu(parent,SWT.DROP_DOWN |style);
			parentMenuItem.setMenu(subMenu);
		}else{
			subMenu=new Menu(parent,SWT.BAR|style);
			parent.setMenuBar(subMenu);
		}
		return subMenu;
	}
	public static MenuItem createPushMenuItem(Menu parent,String text,Image image,SelectionListener listener){
		MenuItem menuItem=new MenuItem(parent,SWT.PUSH);
		menuItem.setText(text);
		if(image!=null){
			menuItem.setImage(image);
		}
		if(listener!=null){
			menuItem.addSelectionListener(listener);
		}
		return menuItem;
	}
	public static MenuItem createCascadeMenuItem(Decorations composite,Menu parent,String text,Image image){
		MenuItem menuItem=new MenuItem(parent,SWT.CASCADE);
		menuItem.setText(text);
		if(image!=null){
			menuItem.setImage(image);
		}
		menuItem.setMenu(new Menu(composite,SWT.DROP_DOWN));
		return menuItem;
	}
}
