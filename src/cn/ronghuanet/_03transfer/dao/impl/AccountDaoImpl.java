package cn.ronghuanet._03transfer.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ronghuanet._00util.JDBCUtil;
import cn.ronghuanet._03transfer.dao.IAccountDao;
import cn.ronghuanet._03transfer.domain.Account;

public class AccountDaoImpl implements IAccountDao {

	@Override
	public boolean transfer(Account out, Account in, BigDecimal money) {
		// 判断 in 和out 是否为null
		if(out == null || in == null) {
			return false;
		}
		// 获取连接
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = null;
		try {
			// 关闭事务的自动提交
			conn.setAutoCommit(false);
			// 减掉源账户的钱
			out.setMoney(out.getMoney().subtract(money));
			ps = conn.prepareStatement("update t_account set money = ? where id = ?");
			ps.setLong(2, out.getId());
			ps.setBigDecimal(1, out.getMoney());
			ps.executeUpdate();
			System.out.println(1/0);
			// 给收钱账户加钱
			in.setMoney(in.getMoney().add(money));
			ps.setLong(2, in.getId());
			ps.setBigDecimal(1, in.getMoney());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("错了错了 事务回滚了");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}finally {
			// 提交事务
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtil.close(null, ps, conn);
		}
		return true;
	}

	@Override
	public Account queryById(Long id) {
		// 获取连接对象
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 创建预编译对象
			ps = conn.prepareStatement("select * from t_account where id = ?");
			// 填充参数
			ps.setLong(1, id);
			// 执行sql
			rs = ps.executeQuery();
			while(rs.next()) {
				Long id1 = rs.getLong(1);
				String name = rs.getString(2);
				BigDecimal money = rs.getBigDecimal(4);
				return new Account(id1, name, money);
			}
		} catch (SQLException e) {
		//	e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		return null;
	}

}
