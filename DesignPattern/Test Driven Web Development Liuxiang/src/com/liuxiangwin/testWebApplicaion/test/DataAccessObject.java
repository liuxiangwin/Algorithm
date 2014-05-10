package com.liuxiangwin.testWebApplicaion.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataAccessObject {

	private static final String integrateUrl = "jdbc:sqlserver://localhost:49156;databaseName=caslnk;integratedSecurity=true;";

	private static final String url = "jdbc:sqlserver://localhost:49156;DatabaseName=caslnk";
	private static final String username = "caslnk";
	private static final String password = "psw";

	Connection conn = null;
	PreparedStatement preStatement = null;
	ResultSet resultSet = null;
	private List<SlotDetailMeter> _slotDetailMeterList;

	private List<SlotDetail> _slotDetailList;

	private SlotDetailMeter _slotDetailMeter;

	private SlotDetail _slotDetail;

	public List<SlotDetailMeter> GetSlotDetailMeter() throws SQLException {
		String queryString = QueryCountInfo();
		ResultSet countResult = ConnectionDataBase(queryString);
		List<SlotDetailMeter> deatailMeterList = AdaptCountInfo(countResult);
		for (SlotDetailMeter slotDetailMeter : deatailMeterList) {

			System.out.println(slotDetailMeter.get_dropDate());
		}
		CloseConnection();
		return deatailMeterList;
	}

	public List<SlotDetail> GetSlotDetail() throws SQLException {
		String queryString = QueryTransactionInfo();
		ResultSet detailResult = ConnectionDataBase(queryString);
		List<SlotDetail> detailList = AdaptDetailInfo(detailResult);
		for (SlotDetail detail : detailList) {

			System.out.println(detail.get_dropDate());
			System.out.println(detail.get_tranAmount());
			System.out.println(detail.get_tranCode());
		}
		CloseConnection();
		return detailList;
	}

	private ResultSet ConnectionDataBase(String queryString) {

		try {
			// Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			conn = DriverManager.getConnection(url, username, password);
			//conn=DriverManager.getConnection(integrateUrl);

			String sql = queryString;
			preStatement = conn.prepareStatement(sql);
			resultSet = preStatement.executeQuery();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*
			 * try { //resultSet.close(); //preStatement.close();
			 * //conn.close();
			 * 
			 * } catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		}
		return resultSet;
	}

	private List<SlotDetailMeter> AdaptCountInfo(ResultSet resultSet)
			throws SQLException {
		_slotDetailMeterList = new ArrayList<SlotDetailMeter>();
		while (resultSet.next()) {

			_slotDetailMeter = new SlotDetailMeter();
			// resultSet.getTime(columnLabel)

			_slotDetailMeter.set_dropDate(resultSet.getDate("drop_date"));
			_slotDetailMeter.set_softCount(resultSet.getDouble("soft_count"));
			_slotDetailMeter.set_harCount(resultSet.getDouble("hard_count"));

			_slotDetailMeterList.add(_slotDetailMeter);

		}
		return _slotDetailMeterList;
	}

	private List<SlotDetail> AdaptDetailInfo(ResultSet resultSet)
			throws SQLException {
		_slotDetailList = new ArrayList<SlotDetail>();
		while (resultSet.next()) {

			_slotDetail = new SlotDetail();
			// resultSet.getTime(columnLabel)

			_slotDetail.set_dropDate(resultSet.getDate("drop_date"));
			_slotDetail.set_tranAmount(resultSet.getDouble("tran_amount"));
			_slotDetail.set_tranCode(resultSet.getString("tran_code"));

			_slotDetailList.add(_slotDetail);

		}
		return _slotDetailList;
	}

	private String QueryCountInfo() {
		String sql = "select soft_count,drop_date,hard_count "
				+ "from caslnk.caslnk.slot_detail_meter";
		return sql;
	}

	private String QueryTransactionInfo() {
		String sql = "select * from caslnk.slot_detail,caslnk.slot_detail_meter where"
				
				+ " caslnk.slot_detail.drop_date=caslnk.slot_detail_meter.drop_date "
				+ "and caslnk.slot_detail.tran_code='5225'";
		return sql;
	}

	private void CloseConnection() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preStatement != null) {
				preStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String args[]) {
		DataAccessObject dao = new DataAccessObject();
		try {
			//dao.GetSlotDetailMeter();
			dao.GetSlotDetail();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
