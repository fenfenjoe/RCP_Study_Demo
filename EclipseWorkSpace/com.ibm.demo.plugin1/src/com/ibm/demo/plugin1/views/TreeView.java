package com.ibm.demo.plugin1.views;


import java.net.URL;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ibm.demo.plugin1.datasource.Node;
import com.ibm.demo.plugin1.datasource.RootNode;
import com.ibm.demo.plugin1.resource.IResourceKey;


/**
 * 
 * @author Dong Yongzhao
 *  TreeViewer Demo
 *  description��
 *  ����Դ�е����ݱ���Ҫ��һ�����Ľṹ
 *  
 */

public class TreeView extends ViewPart {

	public static final String TREE_VIEW_ID="com.ibm.demo.plugin1.views.TreeView";
	public TreeViewer treeViewer;
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		treeViewer=new TreeViewer(parent,SWT.BORDER|SWT.MULTI|SWT.V_SCROLL);
		this.getSite().setSelectionProvider(treeViewer);
		//������ʾ�������������ʾ�ڵ���Ϣ���ڵ�����ͼ�꣩
		treeViewer.setLabelProvider(new ContentTreeLabelProvider());
		//�����ṩ�������������ʾ�ӽڵ�
			//����һ
//		treeViewer.setContentProvider(new ContentTreeContentProvider());
			//������
		treeViewer.setContentProvider(new BaseWorkbenchContentProvider());
		Platform.getAdapterManager().registerAdapters(new AdapterFactory(), Node.class);
		//����Դ��ע��ڵ���Ϣ �����ڵ㣩
		treeViewer.setInput(RootNode.getRootNode());
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	//
	public class ContentTreeLabelProvider implements ILabelProvider{
		@Override
		public String getText(Object element) {
			// TODO Auto-generated method stub
			return ((Node)element).getName();
		}

		@Override
		public Image getImage(Object element) {
			return PlatformUI.getWorkbench().
			getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}
	}
	//�����ṩ����һ��ֱ�Ӽ̳�IWorkbenchContentProvider�����ڵ���̳�ͬһ����ʱ���ã������Ƽ�
	public class ContentTreeContentProvider extends BaseWorkbenchContentProvider{
		@Override
		public Object[] getChildren(Object element) {
			// TODO Auto-generated method stub
			return ((Node)element).getChildren().toArray();
		}
		@Override
		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return ((Node)element).getParent();
		}
		@Override
		public boolean hasChildren(Object element) {
			// TODO Auto-generated method stub
			return (((Node) element).getChildren().size() > 0);
		}
		@Override
		public Object[] getElements(Object element) {
			// TODO Auto-generated method stub
			return ((Node) element).getChildren().toArray();
		}
	}
	//�����ṩ��������Ϊ��������ģ���½�һ������������
	public class AdapterFactory implements IAdapterFactory{
//		private IWorkbenchAdapter studentAdapter=new IWorkbenchAdapter(){...};
		private IWorkbenchAdapter nodeAdapter=new IWorkbenchAdapter(){

			@Override
			public Object[] getChildren(Object o) {
				// TODO Auto-generated method stub
				return ((Node)o).getChildren().toArray();
			}

			@Override
			public ImageDescriptor getImageDescriptor(Object object) {
				 ImageDescriptor imageDescriptor= AbstractUIPlugin.imageDescriptorFromPlugin("com.ibm.demo.plugin1", IResourceKey.headImg);
				 return imageDescriptor;
//				URL url=Platform.getBundle("com.ibm.demo.plugin1").getEntry(IResourceKey.headImg);
//				return ImageDescriptor.createFromURL(url);
			}

			@Override
			public String getLabel(Object o) {
				// TODO Auto-generated method stub
				return ((Node)o).getName();
			}

			@Override
			public Object getParent(Object o) {
				// TODO Auto-generated method stub
				return ((Node)o).getParent();
			}
			
		};
		@Override
		public Object getAdapter(Object adaptableObject, Class adapterType) {
			// TODO Auto-generated method stub
			if(adapterType==IWorkbenchAdapter.class&&adaptableObject instanceof Node){
				return nodeAdapter;
			}
//			else if(adapterType==IWorkbenchAdapter.class&&adaptableObject instanceof Student){
//				return studentAdapter;
//			}
			else{
				return null;
			}
		}

		@Override
		public Class[] getAdapterList() {
			// TODO Auto-generated method stub
			return new Class[]{IWorkbenchAdapter.class};
		}
		
	}
}