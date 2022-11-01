package login.dao.impl;

import login.dao.IUserDao;
import login.domain.User;
import util.JDBCUtil;

import java.sql.*;

public class IUserDaoImpl implements IUserDao {
    /**
     * 根据用户名和密码查询
     * @param user
     * @return
     */
    @Override
    public User selectByNamePwd(User user) {
        Connection conn = JDBCUtil.getConn();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql = "select * from t_user where name='"+user.getName()+"' and password='"+user.getPassword()+"'";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                return new User(id, name, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,st,conn);
        }
        return null;
    }

    /**
     * 根据用户名查询
     * @param user
     * @return
     */
    @Override
    public User selectByName(User user) {
        Connection conn = JDBCUtil.getConn();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql = "select * from t_user where name='"+user.getName()+"'";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                return new User(id, name, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,st,conn);
        }
        return null;
    }

    @Override
    public User getUserByPst(User user) {
        Connection conn = JDBCUtil.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from t_user where name = ? and password = ?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            while(rs.next()) {
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                System.out.println(new User(id, name, password));
                return new User(id, name, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return null;
    }
}
