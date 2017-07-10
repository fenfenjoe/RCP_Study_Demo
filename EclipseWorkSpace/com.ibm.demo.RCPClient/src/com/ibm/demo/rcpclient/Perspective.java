package com.ibm.demo.rcpclient;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.ibm.demo.plugin1.views.TreeView;
import com.ibm.demo.plugin1.views.NavView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.addStandaloneView(TreeView.TREE_VIEW_ID, false,IPageLayout.RIGHT, 0.3f, layout.getEditorArea());
		layout.addView(NavView.NAV_VIEW_ID, IPageLayout.LEFT, 0.7f, layout.getEditorArea());
	}
}