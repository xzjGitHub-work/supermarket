package com.mingrisoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mingrisoft.bean.Sell;
import com.mingrisoft.bean.Stock;

public class StockDao {

	GetConnection connection = new GetConnection();
	Connection conn = null;
	// ������Ӳɹ���������
public void insertStock(Stock stock) {
	conn = connection.getCon();			//��ȡ���ݿ�����
	try {
		PreparedStatement statement = conn
				.prepareStatement("insert into tb_stock (sName,orderId,consignmentDate,baleName,count,money) values(?,?,?,?,?,?)");
		statement.setString(1,stock.getsName());
		statement.setString(2,stock.getOrderId());			
		statement.setString(3,stock.getConsignmentDate());
		statement.setString(4,stock.getBaleName());
		statement.setString(5,stock.getCount());
		statement.setFloat(6,stock.getMoney());			
		statement.executeUpdate();							//ִ�в������
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

	// �����ѯ�ɹ���������ȫ�����ݷ���
	public List selectStock() {
		List list = new ArrayList<Sell>();
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from tb_stock");
			while (rest.next()) {
				Stock stock = new Stock();
				stock.setId(rest.getInt(1));
				stock.setsName(rest.getString(2));
				stock.setOrderId(rest.getString(3));
				stock.setConsignmentDate(rest.getString(4));
				stock.setBaleName(rest.getString(5));
				stock.setCount(rest.getString(6));
				stock.setMoney(rest.getFloat(7));			
				list.add(stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	// ���嶩���Ų�ѯ�ֿ��������ݷ���
	public int selectJoinStockByOid(String oid) {
		List list = new ArrayList<Sell>();
		conn = connection.getCon();
		int id = 0;
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select id from tb_joinDepot where oid ='"+oid+"'");
			while (rest.next()) {
				id = rest.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
	// ���尴��Ʒ����ѯ���������ݷ���
public List selectStockBySName(String sName) {
	List list = new ArrayList<Stock>();			//���屣���ѯ�����List����
	conn = connection.getCon();					//��ȡ���ݿ�����
	int id = 0;
	try {
		Statement statement = conn.createStatement();	//ʵ����Statement����
		ResultSet rest = statement.executeQuery("select * from tb_stock where sName ='"+sName+"'");	//�����ѯ��䣬��ȡ��ѯ�����
		while (rest.next()) {					//ѭ��������ѯ�����
			Stock stock = new Stock();			//���������ݱ�����JavaBean����
			stock.setId(rest.getInt(1));		//Ӧ�ò�ѯ�������JavaBean����
			stock.setsName(rest.getString(2));
			stock.setOrderId(rest.getString(3));
			stock.setConsignmentDate(rest.getString(4));
			stock.setBaleName(rest.getString(5));
			stock.setCount(rest.getString(6));
			stock.setMoney(rest.getFloat(7));
			list.add(stock);					//��JavaBean������ӵ�����
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;								//���ز�ѯ����
}
	// ���尴�����Ų�ѯ���������ݷ���
	public List selectStockByOid(String oId) {
		List list = new ArrayList<Stock>();
		conn = connection.getCon();
		int id = 0;
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from tb_stock where orderId = '"+oId+"'");
			while (rest.next()) {
				Stock stock = new Stock();
				stock.setId(rest.getInt(1));
				stock.setsName(rest.getString(2));
				stock.setOrderId(rest.getString(3));
				stock.setConsignmentDate(rest.getString(4));
				stock.setBaleName(rest.getString(5));
				stock.setCount(rest.getString(6));
				stock.setMoney(rest.getFloat(7));
				list.add(stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// ���尴�������ڲ�ѯ���������ݷ���
	public List selectStockByDate(String cDate) {
		List list = new ArrayList<Stock>();
		conn = connection.getCon();
		int id = 0;
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from tb_stock where consignmentDate = '"+cDate+"'");
			while (rest.next()) {
				Stock stock = new Stock();
				stock.setId(rest.getInt(1));
				stock.setsName(rest.getString(2));
				stock.setOrderId(rest.getString(3));
				stock.setConsignmentDate(rest.getString(4));
				stock.setBaleName(rest.getString(5));
				stock.setCount(rest.getString(6));
				stock.setMoney(rest.getFloat(7));
				list.add(stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// ��д����Ų�ѯ������Ϣ����
public Stock selectStockByid(int id) {
	Stock stock = new Stock();		//����������ݿ��Ӧ��JavaBean����
	conn = connection.getCon();		//��ȡ���ݿ�����
	try {
		Statement statement = conn.createStatement();
		String sql = "select * from tb_stock where id = " + id;		//�����ѯSQL���
		ResultSet rest = statement.executeQuery(sql);				//ִ�в�ѯ����ȡ��ѯ�����
		while (rest.next()) {		//ѭ��������ѯ�����
			stock.setId(id);									//Ӧ�ò�ѯ������ö�������
			stock.setsName(rest.getString(2));
			stock.setOrderId(rest.getString(3));
			stock.setConsignmentDate(rest.getString(4));
			stock.setBaleName(rest.getString(5));				
			stock.setCount(rest.getString(6));
			stock.setMoney(rest.getFloat(7));			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return stock;						//����Stock����
}

	
	// �����޸Ĺ�Ӧ����Ϣ����
public void updateStock(Stock stock) {
	conn = connection.getCon();					//��ȡ���ݿ�����
	try {
		String sql = "update tb_stock set sName=?,orderId=?,consignmentDate=?," +
				"baleName=?,count=?,money=? where id =?";			//�����޸����ݱ���
		PreparedStatement statement = conn.prepareStatement(sql);	//��ȡPreparedStatement����
		statement.setString(1, stock.getsName());					//����Ԥ����������ֵ
		statement.setString(2, stock.getOrderId());
		statement.setString(3, stock.getConsignmentDate());
		statement.setString(4, stock.getBaleName());
		statement.setString(5, stock.getCount());
		statement.setFloat(6, stock.getMoney());
		statement.setInt(7, stock.getId());
		statement.executeUpdate();									//ִ�и������
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

	// ����ɾ����Ӧ����Ϣ����
public void deleteStock(int id){
	conn = connection.getCon();							//��ȡ���ݿ�����
	String sql = "delete from tb_stock where id ="+id;	//����ɾ������SQL���
	try {
		Statement statement = conn.createStatement();	//ʵ����Statement����
		statement.executeUpdate(sql);					//ִ��SQL���
	} catch (SQLException e) {			
		e.printStackTrace();
	}		
}
}
