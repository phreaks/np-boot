package net.frischware.npboot.bean;

import java.beans.PropertyVetoException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0DataSource implements javax.sql.DataSource{

	private static C3P0DataSource dataSource;
	private ComboPooledDataSource comboPooledDataSource;

	private C3P0DataSource() {
		try {
			comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/xe");
			comboPooledDataSource.setUser("hr");
			comboPooledDataSource.setPassword("hr");

		} catch (PropertyVetoException ex1) {
			ex1.printStackTrace();
		}
	}

	public static C3P0DataSource getInstance() {
		if (dataSource == null)
			dataSource = new C3P0DataSource();
		return dataSource;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = comboPooledDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
