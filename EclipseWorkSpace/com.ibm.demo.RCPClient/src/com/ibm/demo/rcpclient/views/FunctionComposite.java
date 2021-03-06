package com.ibm.demo.rcpclient.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.ibm.demo.rcpclient.util.WidgetsFactory;

public class FunctionComposite extends Composite {
	private Menu mainMenu;
	private Label contentLabel;
	private Composite contentComposite;
	private Button button;
	public FunctionComposite(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		init();
	}
	public void init(){
		GridLayout layout=new GridLayout(1,false);
		this.setLayout(layout);		
		this.setSize(this.getParent().getSize());
		createControl(this);
//		this.pack();
	}
	public void createControl(Composite parent) {

		if(contentLabel==null){
			contentLabel=new Label(this.getShell(),SWT.BORDER);
			GridData layoutdata=new GridData(SWT.FILL,SWT.FILL,true,true);
			contentLabel.setLayoutData(layoutdata);
		}
		if(contentComposite==null){
			contentComposite=new Composite(this.getShell(),SWT.BORDER);
			FillLayout layout=new FillLayout();
			contentComposite.setLayout(layout);
			GridData layoutdata=new GridData(SWT.FILL,SWT.FILL,true,true);
			contentComposite.setLayoutData(layoutdata);
		}
		if(mainMenu==null){
			mainMenu=WidgetsFactory.createMenu(this.getShell(),SWT.None, null);
			createMenu();
		}
	}
	public void createMenu(){
		MenuItem item1=WidgetsFactory.createCascadeMenuItem(this.getShell(),mainMenu,"&Button",null);
		try {
			WidgetsFactory.createPushMenuItem(item1.getMenu(),"&ArrowButton",null,arrowListener);
			WidgetsFactory.createPushMenuItem(item1.getMenu(), "&CheckButton",null,checkListener);
			WidgetsFactory.createPushMenuItem(item1.getMenu(), "&RadioButton",null,radioListener);
			WidgetsFactory.createPushMenuItem(item1.getMenu(), "&ToggleButton",null,toggleListener);
			WidgetsFactory.createPushMenuItem(item1.getMenu(), "&WrapButton",null,wrapListener);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		MenuItem item2=WidgetsFactory.createCascadeMenuItem(this.getShell(),mainMenu ,"&List",null);
	}

	private SelectionListener arrowListener=new SelectionListener(){
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			if(button!=null&&!button.isDisposed()){
				button.dispose();
			}
			if(contentComposite!=null){
				button=new Button(contentComposite,SWT.ARROW|SWT.RIGHT);
				button.setText("Arrow Button");
				contentLabel.setText("Arrow Button");
				contentComposite.pack();
			}
			
			
		}
		
	};
	private SelectionListener checkListener=new SelectionListener(){
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			if(button!=null&&!button.isDisposed()){
				button.dispose();
			}
			if(contentComposite!=null){
				button=new Button(contentComposite,SWT.CHECK);
				button.setText("Check Button");
				contentLabel.setText("Check Button");
				contentComposite.pack();
			}
			
			
			
		}
		
	};
	private SelectionListener radioListener=new SelectionListener(){
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			if(button!=null&&!button.isDisposed()){
				button.dispose();
			}
			if(contentComposite!=null){
				button=new Button(contentComposite,SWT.RADIO);
				button.setText("Radio Button");
				contentLabel.setText("Radio Button");
				contentComposite.pack();
			}
			
			
		}
		
	};
	private SelectionListener toggleListener=new SelectionListener(){
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			if(button!=null&&!button.isDisposed()){
				button.dispose();
			}
			if(contentComposite!=null){
				button=new Button(contentComposite,SWT.TOGGLE);
				button.setText("Toggle Button");
				contentLabel.setText("Toggle Button");
				contentComposite.pack();
			}
			
			
		}
		
	};
	private SelectionListener wrapListener=new SelectionListener(){
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			if(button!=null&&!button.isDisposed()){
				button.dispose();
			}
			if(contentComposite!=null){
				button=new Button(contentComposite,SWT.WRAP);
				button.setText("Wrap Button");
				contentLabel.setText("Wrap Button");
				contentComposite.pack();
			}
			
			
		}
		
	};

}
