package com.mingrisoft.model;
public class DeptModel extends javax.swing.table.DefaultTableModel {


	Class[] types = new Class[] { Object.class, String.class, String.class, String.class,String.class};

	boolean[] canEdit = new boolean[] { false, false, false,false,false};

	public DeptModel() {
		super(new Object[][] {}, new String[] { "序号", "部门名称","负责人","描述","负责人编号"});
	}

	public Class getColumnClass(int columnIndex) {
		return types[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}
}