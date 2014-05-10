package com.liuxiangwin.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class SqlExecutor {

	private Connection connection;

	private char separator = ';';

	private Logger logger;

	/**
	 * @param connection
	 *            The JDBC connection to execute the SQL statements with.
	 */
	public SqlExecutor(Connection connection) {
		this.connection = connection;
		this.logger = Logger.getLogger(getClass().getName());
	}

	public void execute(InputStream source) throws SQLException, IOException {
		//Wrap up Reader method accept the Read type
		execute(new InputStreamReader(source));
	}

	public void execute(Reader source) throws SQLException, IOException {
		execute(new PushbackReader(source));
	}

	private void execute(PushbackReader reader) throws SQLException,
			IOException {
		Statement statement = connection.createStatement();
		String sql = null;
		while ((sql = readNextStatement(reader)) != null) {
			try {
				logger.fine("Executing SQL: " + sql);
				statement.execute(sql);
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		statement.close();
	}

	private String readNextStatement(PushbackReader reader) throws IOException {
		if (peek(reader) == -1) {
			return null;
		}
		StringBuffer sql = new StringBuffer();
		int c = -1;
		boolean insideQuotedString = false;
		while ((c = reader.read()) != -1) {
			if (c == separator && !insideQuotedString) {
				break;
			}
			if (c == '\'') {
				insideQuotedString = !insideQuotedString;
			}
			sql.append((char) c);
		}
		return sql.toString().trim();
	}
	
	
	private int peek(PushbackReader reader) throws IOException {
        int c = reader.read();
        reader.unread(c);
        return c;
    }
	
	private void stringUtil()
	{
		String.valueOf(true);
		
		
	}

}
