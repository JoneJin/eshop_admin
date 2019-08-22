package util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBManager {
	private static ComboPooledDataSource datasourse = 
			new ComboPooledDataSource("eshop");
	
	public static DataSource getDataSourse() {
		return datasourse;
	}
}
