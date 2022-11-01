package key.dao.impl;

import hikaricp.HiKariUtil;
import key.dao.IUserDao;
import key.domain.User;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImpl implements IUserDao {

	@Override
	public Long saveUser(User u) throws Exception{
		Connection conn = HiKariUtil.getConn();
		Statement st = conn.createStatement();
		String sql = "insert into t_user(name,password,permissions_id)value("
				+ "'"+u.getName()+"',"
				+ "'"+u.getPassword()+"',"
				+ u.getPermId()+")";
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
				conn.prepareStatement("insert into t_user(name,password,permissions_id)value(?,?,?)"
						,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,u.getName());
		ps.setString(2, u.getPassword());
		ps.setInt(3, u.getPermId());
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
