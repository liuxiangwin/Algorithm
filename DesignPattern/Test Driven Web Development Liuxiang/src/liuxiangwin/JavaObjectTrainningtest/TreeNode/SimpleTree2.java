package liuxiangwin.JavaObjectTrainningtest.TreeNode;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class SimpleTree2 extends JFrame {

	protected JTree _jtMain;
	protected DefaultTreeModel _dtmMain;

	public SimpleTree2() {
		super("Alan make Jtree Test");

		this.setSize(300, 300);
		Object[] nodes = new Object[4];
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(
				new SimpleNode("Home"));

		DefaultMutableTreeNode parent = top;
		nodes[0] = top;
	
		

		DefaultMutableTreeNode node = new DefaultMutableTreeNode(
				new SimpleNode("Google"));
		parent.add(node);
		

		DefaultMutableTreeNode node2= new DefaultMutableTreeNode(
				new SimpleNode("Microsoft"));
		//node= new DefaultMutableTreeNode(
				//new SimpleNode("Microsoft"));
		//parent.add(node);
		//parent = node;
		//parent.add(node2);
		//parent=node2;
		//nodes[1] = parent;
		
		parent.add(node2);
		parent=node2;
		nodes[1] = parent;
		

		DefaultMutableTreeNode node3= new DefaultMutableTreeNode(new SimpleNode("HardWare"));
		//new SimpleNode("HardWare"));
		//node= new DefaultMutableTreeNode(
		//		new SimpleNode("HardWare"));
		//parent.add(node);
		//parent = node;
		parent.add(node3);
		parent=node3;
		nodes[2] = parent;
		
		
		DefaultMutableTreeNode node4= new DefaultMutableTreeNode(new SimpleNode("CPU"));		
		parent.add(node4);
		//parent=node3;
		nodes[3] = parent;

		_dtmMain = new DefaultTreeModel(top);
		//_dtmMain = new DefaultTreeModel(parent);
		_jtMain = new JTree(_dtmMain);

		RenderTree();

		SetTreePath(nodes);

		SetListerner();

	}

	private void RenderTree() {
		DefaultTreeCellRenderer render = new DefaultTreeCellRenderer();
		render.setOpenIcon(new ImageIcon("open,gif"));
		render.setClosedIcon(new ImageIcon("open,gif"));
		render.setLeafIcon(new ImageIcon("open,gif"));
		_jtMain.setCellRenderer(render);
		_jtMain.setShowsRootHandles(true);
		_jtMain.setEditable(true);
	}

	private void SetListerner() {
		this.getContentPane().add(_jtMain, BorderLayout.CENTER);

		WindowListener closeListerner = new WindowAdapter() {
			public void windowsClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(closeListerner);
		this.setVisible(true);
	}

	private void SetTreePath(Object[] nodes) {
		TreePath path = new TreePath(nodes);
		_jtMain.setSelectionPath(path);
	}

	public static void main(String args[]) {

		new SimpleTree2();
	}
}
