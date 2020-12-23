package com.mingrisoft.model;
public class DepotModel extends javax.swing.table.DefaultTableModel {
	Class[] types = new Class[] { Object.class,
			String.class, String.class};
	boolean[] canEdit = new boolean[] { false, false, false};
	public DepotModel() {
		super(new Object[][] {}, new String[] { "编号", "库管","描述"});
	}
	public Class getColumnClass(int columnIndex) {
		return types[columnIndex];
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}
}