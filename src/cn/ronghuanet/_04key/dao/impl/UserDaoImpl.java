package cn.ronghuanet._04key.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.ronghuanet._00util.JDBCUtil;
import cn.ronghuanet._04key.dao.IUserDao;
import cn.ronghuanet._04key.domain.User;
import cn.ronghuanet._05hikaricp.HiKariUtil;

public class UserDaoImpl implements IUserDao{

	@Override
	public Long saveUser(User u) throws Exception{
		Connection conn = HiKariUtil.getConn();
		Statement st = conn.createStatement();
		String sql = "insert into t_user(name,password,gender,age)value("
				+ "'"+u.getName()+"',"
				+ "'"+u.getPassword()+"',"
				+ u.getGender()+","
				+ u.getAge()+")";
		System.out.println(sql);
		st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		ResultSet key = st.getGeneratedKeys();
		Long id = null;
		while(key.next()) {
			id = key.getLong(1);
		}
		JDBCUtil.close(null, st, conn);
		return id;
	}

	@Override
	public Long saveUserPS(User u) throws Exception {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = 
				conn.prepareStatement("insert into t_user(name,password,gender,age)value(?,?,?,?)"
						,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,u.getName());
		ps.setString(2, u.getPassword());
		ps.setInt(3, u.getGender());
		ps.setInt(4, u.getAge());
		ps.executeUpdate();
		ResultSet key = ps.getGeneratedKeys();
		Long id = null;
		while(key.next()) {
			id = key.getLong(1);
		}
		JDBCUtil.close(null, ps, conn);
		return id;
	}

}
