package com.ibm.demo.rcpclient;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.ibm.demo.plugin1.views.TreeView;
import com.ibm.demo.plugin1.views.NavView;
//透视图
public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setEditorAreaVisible(true);
		//无标题、无最小化的View
		layout.addStandaloneView(TreeView.TREE_VIEW_ID, false,IPageLayout.RIGHT, 0.3f, layout.getEditorArea());
		//普通View
		layout.addView(NavView.NAV_VIEW_ID, IPageLayout.LEFT, 0.5f, layout.getEditorArea());
	}
}
