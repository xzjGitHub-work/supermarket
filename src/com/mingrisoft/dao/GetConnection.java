package com.mingrisoft.dao;
import java.sql.*;
public class GetConnection {	
private Connection con;			//定义数据库连接类对象
private PreparedStatement pstm;	
private String user="root";		//连接数据库用户名
private String password="root";		//连接数据库密码
private String className="com.mysql.jdbc.Driver";//数据库驱动
private String url="jdbc:mysql://localhost:3306/db_supermarket?useSSL=false&serverTimezone=UTC";		//URL
public GetConnection(){
	try{
		Class.forName(className);
	}catch(ClassNotFoundException e){
		System.out.println("数据库驱动异常");
		e.printStackTrace();
	}
}
	/**创建数据库连接*/
public Connection getCon(){
	try {
		con=DriverManager.getConnection(url,user,password);		//获取数据库连接
	} catch (SQLException e) {
		System.out.println("创建数据库连接失败！");
		con=null;
		e.printStackTrace();
	}
	return con;					//返回数据库连接对象
}	
	public void doPstm(String sql,Object[] params){
		if(sql!=null&&!sql.equals("")){
			if(params==null)
				params=new Object[0];			
			getCon();
			if(con!=null){
				try{		
					System.out.println(sql);
					pstm=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					for(int i=0;i<params.length;i++){
						pstm.setObject(i+1,params[i]);
					}
					pstm.execute();
				}catch(SQLException e){
					System.out.println("doPstm()方法出错！");
					e.printStackTrace();
				}				
			}			
		}
	}	
	public ResultSet getRs() throws SQLException{
		return pstm.getResultSet();		
	}
	public int getCount() throws SQLException{
		return pstm.getUpdateCount();		
	}
	public void closed(){
		try{
			if(pstm!=null)
				pstm.close();			
		}catch(SQLException e){
			System.out.println("关闭pstm对象失败！");
			e.printStackTrace();
		}
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			System.out.println("关闭con对象失败！");
			e.printStackTrace();
		}
	}
}
