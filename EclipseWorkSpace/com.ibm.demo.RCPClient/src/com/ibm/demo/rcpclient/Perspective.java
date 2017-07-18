package com.ibm.demo.rcpclient;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.ibm.demo.plugin1.views.TreeView;
import com.ibm.demo.plugin1.views.NavView;
//͸��ͼ
public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setEditorAreaVisible(true);
		//�ޱ��⡢����С����View
		layout.addStandaloneView(TreeView.TREE_VIEW_ID, false,IPageLayout.RIGHT, 0.3f, layout.getEditorArea());
		//��ͨView
		layout.addView(NavView.NAV_VIEW_ID, IPageLayout.LEFT, 0.5f, layout.getEditorArea());
	}
}
