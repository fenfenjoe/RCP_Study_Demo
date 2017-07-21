package com.ibm.demo.chat.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class P2PView extends ViewPart  {

	@Override
	public void createPartControl(Composite parent) {
		Composite panel=new Composite(parent,SWT.None);
		panel.setLayout(new GridLayout(3,false));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
}
