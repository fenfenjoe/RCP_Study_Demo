package com.ibm.demo.plugin1.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class Editor extends EditorPart {
	private Text textItem;
	private Label labelItem;
	public static final String EDITOR_ID="com.ibm.demo.plugin1.editors.Editor";

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		// TODO Auto-generated method stub
		if(labelItem==null){
			labelItem=new Label(parent,SWT.NONE);
			labelItem.setText("Label");
			
		}
		if(textItem==null){
			textItem=new Text(parent,SWT.NONE);
			textItem.setText("text");
			
		}
	}


	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub
		setSite(site);
		setInput(input);
		setPartName("Content");
	}


	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	
}
