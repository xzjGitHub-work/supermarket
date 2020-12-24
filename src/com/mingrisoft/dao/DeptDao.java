package com.mingrisoft.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mingrisoft.bean.Depot;
import com.mingrisoft.bean.Dept;
import com.mingrisoft.bean.Provide;
import com.mingrisoft.model.DepotModel;

public class DeptDao {

	//创建对象的时候 已经注册驱动了
	static GetConnection connection = new GetConnection();

	public static void main(String[] args) throws Exception {

		//查询的
		Connection select = connection.getCon();//获取链接
		ResultSet rest = select.createStatement().executeQuery("select * from tb_dept");//执行sql语句
		while (rest.next()) {
			//根据字段名获取
			System.out.println(rest.getObject("id"));
			System.out.println(rest.getObject("dName"));
			System.out.println(rest.getObject("principal"));
			System.out.println(rest.getObject("bewrite"));
			//根据列索引获取
			System.out.println(rest.getInt(1));
			System.out.println(rest.getString(2));
			System.out.println(rest.getString(3));
			System.out.println(rest.getString(4));
		}
		//添加
		Connection add = connection.getCon();//获取链接
		PreparedStatement statement = add.prepareStatement("insert into tb_dept (dName,principal,bewrite) values(?,?,?)");
		statement.setString(1,"1");
		statement.setString(2,"2");
		statement.setString(3,"3");
		statement.executeUpdate();

		//修改
		Connection update = connection.getCon();//获取链接
		PreparedStatement statementUpdate = update.prepareStatement("update tb_dept set dName = ?,principal = ?,bewrite=? where id =?");
		statementUpdate.setString(1,"111");
		statementUpdate.setString(2,"222");
		statementUpdate.setString(3,"333");
		statementUpdate.setString(4,"4");

		//update tb_dept set dName = 111,principal = 222,bewrite=333 where id =4
		statementUpdate.executeUpdate();

	}
	// ������Ӳ�����Ϣ����
	Connection conn = null;
	public void insertDept(Dept dept) {
		conn = connection.getCon();
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into tb_dept (dName,principal,bewrite) values(?,?,?)");
			statement.setString(1,dept.getdName());
			statement.setString(2, dept.getPrincipal());
			statement.setString(3, dept.getBewrite());		
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// �����ѯ���ű���ȫ�����ݷ���
public List selectDept() {
	List list = new ArrayList<Dept>();				//����List���϶���
	conn = connection.getCon();						//��ȡ���ݿ�����
	try {
		Statement statement = conn.createStatement();		//��ȡStatement����
		ResultSet rest = statement.executeQuery("select * from tb_dept");	//ִ�в�ѯ����ȡ��ѯ�����
		int i = 1;
		while (rest.next()) {						//ѭ��������ѯ�����
			Dept dept = new Dept();
			dept.setId(rest.getInt(1));				//Ӧ�ò�ѯ������ö�������
			dept.setdName(rest.getString(2));
			dept.setPrincipal(rest.getString(3));
			dept.setBewrite(rest.getString(4));
			dept.setIndexNumber(i++);
			list.add(dept);							//��������ӵ�������
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}

	// ��д����Ų�ѯ������Ϣ����
	public Dept selectDeptByid(int id) {
		Dept dept = new Dept();
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from tb_dept where id = " + id;
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				dept.setId(rest.getInt(1));
				dept.setdName(rest.getString(2));
				dept.setPrincipal(rest.getString(3));
				dept.setBewrite(rest.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}
	//��д���ղ������Ʋ�ѯ���ű�ŷ���
	public int selectDeptIdByName(String name) {
		int id = 0;
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			String sql = "select id from tb_dept where dName = '" + name+"'";
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				id = rest.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	// ���尴�������Ʋ�ѯ������Ϣ����
public Dept selectDeptByName(String name) {		
	conn = connection.getCon();			//��ȡ���ݿ�����
	Dept dept = null;
	try {
		Statement statement = conn.createStatement();		//ʵ����Statement����
		String sql = "select * from tb_dept where dName = '" + name +"'";	//���尴�������Ʋ�ѯ������ϢSQL���
		ResultSet rest = statement.executeQuery(sql);		//ִ�в�ѯ����ȡ��ѯ�����	
		while (rest.next()) {		//ѭ��������ѯ�����
			dept = new Dept();					//�����벿�ű��Ӧ��JavaBean����
			dept.setId(rest.getInt(1));			//Ӧ�ò�ѯ������ö�������
			dept.setdName(rest.getString(2));
			dept.setPrincipal(rest.getString(3));
			dept.setBewrite(rest.getString(4));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return dept;					//����JavaBean����
}
	// ���尴�����˲�ѯ������Ϣ����
	public Dept selectDeptByPrincipal(String manage) {		
		conn = connection.getCon();
		Dept dept =null ;
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from tb_dept where principal = '" + manage +"'";
			ResultSet rest = statement.executeQuery(sql);			
			while (rest.next()) {
			    dept = new Dept();
				dept.setId(rest.getInt(1));
				dept.setdName(rest.getString(2));
				dept.setPrincipal(rest.getString(3));
				dept.setBewrite(rest.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

	// ���尴���ű�Ų�ѯ������Ϣ����
	public Dept selectDepotById(int id) {		
		conn = connection.getCon();
		Dept dept = new Dept();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from tb_dept where id = '" + id +"'";
			ResultSet rest = statement.executeQuery(sql);			
			while (rest.next()) {			
				dept.setId(rest.getInt(1));
				dept.setdName(rest.getString(2));
				dept.setPrincipal(rest.getString(3));
				dept.setBewrite(rest.getString(4));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

	// �����޸Ĳ�����Ϣ����
	public void updateDept(Dept dept) {
		conn = connection.getCon();
		try {
			String sql = "update tb_dept set dName = ?,principal = ?,bewrite=? where id =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, dept.getdName());
			statement.setString(2, dept.getPrincipal());
			statement.setString(3, dept.getBewrite());
			statement.setInt(4, dept.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ����ɾ��������Ϣ����
	public void deleteDept(int id){
		conn = connection.getCon();
		String sql = "delete from tb_dept where id = "+id;
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}
}
