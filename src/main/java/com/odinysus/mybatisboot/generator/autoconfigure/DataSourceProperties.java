package com.odinysus.mybatisboot.generator.autoconfigure;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.PostgreSqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqlServerTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ConfigurationProperties(
		prefix = "mybatis.gen.datasource"
)

public class DataSourceProperties {
	/**
	 * 数据库类型
	 */
	private DbType dbType = DbType.MYSQL;
	/**
	 * PostgreSQL schemaname
	 */
	private String schemaname = "public";
	/**
	 * 类型转换
	 */
	private ITypeConvert typeConvert;
	/**
	 * 驱动连接的URL
	 */
	private String url;
	/**
	 * 驱动名称
	 */
	private String driverName = "com.mysql.jdbc.Driver" ;
	/**
	 * 数据库连接用户名
	 */
	private String username;
	/**
	 * 数据库连接密码
	 */
	private String password;

	/**
	 * 判断数据库类型
	 *
	 * @return 类型枚举值
	 */
	public DbType getDbType() {
		if (null == dbType) {
			if (driverName.contains("mysql")) {
				dbType = DbType.MYSQL;
			} else if (driverName.contains("oracle")) {
				dbType = DbType.ORACLE;
			} else if (driverName.contains("postgresql")) {
				dbType = DbType.POSTGRE_SQL;
			}
		} else
			dbType = DbType.MYSQL;
		return dbType;
	}
	public void setDbType(DbType dbType) {
		this.dbType = dbType;
	}

	public String getSchemaname() {
		return schemaname;
	}

	public void setSchemaname(String schemaname) {
		this.schemaname = schemaname;
	}

	public ITypeConvert getTypeConvert() {
		if (null == typeConvert) {
			switch (getDbType()) {
				case ORACLE:
					typeConvert = new OracleTypeConvert();
					break;
				case SQL_SERVER:
					typeConvert = new SqlServerTypeConvert();
					break;
				case POSTGRE_SQL:
					typeConvert = new PostgreSqlTypeConvert();
					break;
				default:
					// 默认 MYSQL
					typeConvert = new MySqlTypeConvert();
					break;
			}
		}
		return typeConvert;
	}

	public void setTypeConvert(ITypeConvert typeConvert) {
		this.typeConvert = typeConvert;
	}

	/**
	 * 创建数据库连接对象
	 *
	 * @return Connection
	 */
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DataSourceConfig createBulider() {
		return new DataSourceConfig()
				.setDbType(getDbType())
				.setDriverName(getDriverName())
				.setPassword(getPassword())
				.setTypeConvert(getTypeConvert())
				.setUrl(getUrl())
				.setUsername(getUsername());
	}
}
