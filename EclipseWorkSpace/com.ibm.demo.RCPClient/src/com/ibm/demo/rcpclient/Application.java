package com.ibm.demo.rcpclient;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.ibm.demo.rcpclient.views.LoginComposite;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		Shell loginDialog = new Shell(display,SWT.DIALOG_TRIM );
		loginDialog.setSize(300, 300);
		loginDialog.setLocation(Display.getCurrent().getClientArea().width / 2 - loginDialog.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - loginDialog.getSize().y/2); 
		loginDialog.setText("��½����");
		loginDialog.setLayout(new FillLayout());
		LoginComposite composite=new LoginComposite(loginDialog,SWT.EMBEDDED);
		loginDialog.open();
		while(!loginDialog.isDisposed()){
			 if(!display.readAndDispatch()) {
			       display.sleep();
			   }
		}
		if(!composite.isLogin()){
			return null;
		}
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART)
				return IApplication.EXIT_RESTART;
			else
				return IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
