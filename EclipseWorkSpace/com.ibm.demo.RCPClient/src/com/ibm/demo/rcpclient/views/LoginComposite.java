package com.ibm.demo.rcpclient.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ibm.demo.plugin1.resource.IResourceKey;
import com.ibm.demo.rcpclient.Activator;
import com.ibm.demo.rcpclient.util.TestComposite;
/**
 * 
 * @author Dong Yongzhao
 *
 */
public class LoginComposite extends Composite {
	public LoginComposite(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		init();
	}
	private Composite contentPanel;
	private Composite buttonPanel;
	private Button loginButton,registerButton,exitButton,nextButton,testButton;
	private Text accountText,passwordText;
	private boolean isLogin,isRegister=false;
	private static final String plugin1ID="com.ibm.demo.plugin1";
	public void init(){
		GridLayout layout=new GridLayout(1,false);
		this.setLayout(layout);		
		this.setSize(this.getParent().getSize());
		createControl(this);
		this.pack();
	}

	public void createControl(Composite parent) {
		GridData layoutData;
		insertImage(parent);
		
		if(this.contentPanel==null){
			this.contentPanel=new Composite(parent,SWT.BORDER);	
			GridLayout layout=new GridLayout(2,false);
			contentPanel.setLayout(layout);
			layoutData = new GridData(SWT.FILL,
					SWT.FILL,true,false);
			contentPanel.setLayoutData(layoutData);
		}
			
		if(this.buttonPanel==null){
			this.buttonPanel=new Composite(parent,SWT.BORDER);
			GridLayout layout=new GridLayout(3,false);
			buttonPanel.setLayout(layout);
			layoutData = new GridData(SWT.FILL,
					SWT.FILL,true,false);
			buttonPanel.setLayoutData(layoutData);
		}
		Label accountLabel=new Label(contentPanel,SWT.RIGHT);
		accountLabel.setText("�˺�:");
		layoutData = new GridData(SWT.END,
				SWT.CENTER,true,false);
		accountLabel.setLayoutData(layoutData);
		//
		if(this.accountText==null){
			this.accountText=new Text(contentPanel,SWT.FILL);	
			layoutData = new GridData(SWT.CENTER,
					SWT.CENTER,true,false);
			this.accountText.setLayoutData(layoutData);
		}
		//		
		Label passwordLabel=new Label(contentPanel,SWT.RIGHT);
		passwordLabel.setText("����:");
		passwordLabel.setAlignment(SWT.RIGHT);
		layoutData = new GridData(SWT.END,
				SWT.CENTER,true,false);
//		layoutData.horizontalSpan=2;
		passwordLabel.setLayoutData(layoutData);		
		//
		if(this.passwordText==null){
			this.passwordText=new Text(contentPanel,SWT.NONE);
			layoutData = new GridData(SWT.CENTER,
					SWT.CENTER,true,false);
//			layoutData.horizontalSpan=3;
			passwordText.setLayoutData(layoutData);
		}
		//
		if(this.loginButton==null){
			this.loginButton=new Button(buttonPanel,SWT.PUSH);
			this.loginButton.setText("��¼");
			layoutData = new GridData(SWT.CENTER,
					SWT.CENTER,true,false);
			layoutData.horizontalSpan=1;
			loginButton.setLayoutData(layoutData);
			loginButton.addSelectionListener(new SelectionListener(){

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					__loginButtonSelect();
				}
				
			});
		}
		
		if(this.registerButton==null){
			this.registerButton=new Button(buttonPanel,SWT.PUSH);
			registerButton.setText("ע��");
			layoutData = new GridData(SWT.CENTER,
					SWT.CENTER,true,false);
			layoutData.horizontalSpan=1;
			registerButton.setLayoutData(layoutData);
			registerButton.addSelectionListener(new SelectionListener(){

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		if(this.exitButton==null){
			this.exitButton=new Button(buttonPanel,SWT.PUSH);
			exitButton.setText("�˳�");
			layoutData = new GridData(SWT.CENTER,
					SWT.CENTER,true,false);
			layoutData.horizontalSpan=1;
			exitButton.setLayoutData(layoutData);
			exitButton.addSelectionListener(new SelectionListener(){

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		if(this.testButton==null){
			this.testButton=new Button(buttonPanel,SWT.PUSH);
			testButton.setText("����");
			layoutData = new GridData(SWT.CENTER,
					SWT.CENTER,true,false);
			layoutData.horizontalSpan=1;
			testButton.setLayoutData(layoutData);
			testButton.addSelectionListener(new SelectionListener(){

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					__testButtonSelect();
				}
				
			});
		}
		if(this.nextButton==null){
			this.nextButton=new Button(buttonPanel,SWT.PUSH);
			nextButton.setText("SWT���ܼ�");
			layoutData = new GridData(SWT.CENTER,
					SWT.CENTER,true,false);
			layoutData.horizontalSpan=2;
			nextButton.setLayoutData(layoutData);
			nextButton.addSelectionListener(new SelectionListener(){

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					__nextButtonSelect();
				}
				
			});
		}
		
	}
	//Listener
	private void __loginButtonSelect(){
			isLogin=true;
			this.getShell().dispose();
	}
	private void __registerButtonSelect(){
		
	}
	private void __exitButtonSelect(){
		
	}
	private void __nextButtonSelect(){
		Shell window1=new Shell(this.getDisplay(),SWT.SHELL_TRIM);
		window1.setSize(300, 300);
		window1.setLocation(Display.getCurrent().getClientArea().width / 2 - window1.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - window1.getSize().y/2); 
		window1.setText("����");
		window1.setLayout(new FillLayout(SWT.VERTICAL));
		FunctionComposite fc=new FunctionComposite(window1,SWT.None);
		window1.open();
		while(!window1.isDisposed()){
			 if(!window1.getDisplay().readAndDispatch()) {
				 window1.getDisplay().sleep();
			   }
		}
	}
	private void __testButtonSelect(){
		Shell window1=new Shell(this.getDisplay(),SWT.SHELL_TRIM);
		window1.setSize(300, 300);
		window1.setLocation(Display.getCurrent().getClientArea().width / 2 - window1.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - window1.getSize().y/2); 
		window1.setText("���ܼ�");
		window1.setLayout(new FillLayout(SWT.VERTICAL));
		TestComposite fc=new TestComposite(window1,SWT.None);
		window1.open();
		while(!window1.isDisposed()){
			 if(!window1.getDisplay().readAndDispatch()) {
				 window1.getDisplay().sleep();
			   }
		}
	}
	public boolean isLogin() {
		return isLogin;
	}
	public boolean isRegister() {
		return isRegister;
	}
	/**
	 * ����ͼƬ
	 * @param parent
	 */
	public void insertImage(Composite parent){
		GridData layoutData;
		CLabel imgLabel=new CLabel(parent,SWT.NONE);
		ImageDescriptor idor=Activator.imageDescriptorFromPlugin(this.plugin1ID, IResourceKey.indexImg);
		final Image img=idor.createImage();
		final int imgWidth = img.getBounds().width;
		final int imgHeight = img.getBounds().height;
		Canvas canvas = new Canvas(parent, SWT.DOUBLE_BUFFERED);
		canvas.addPaintListener(new PaintListener() {
		      @Override
		      public void paintControl(PaintEvent event) {
		          // TODO Auto-generated method stub
		          event.gc.drawImage(img, 0, 0, imgWidth, imgHeight, 0, 0, event.width, event.height);
		     }
		});
		layoutData = new GridData(SWT.FILL,
				SWT.FILL,true,true);
		layoutData.horizontalSpan=5;
		imgLabel.setLayoutData(layoutData);
	}
}
