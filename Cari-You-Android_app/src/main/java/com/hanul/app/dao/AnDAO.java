package com.hanul.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hanul.app.dto.MemberDTO;

public class AnDAO {

	DataSource dataSource;

	public AnDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/Bteam");
			/* dataSource = (DataSource) context.lookup("java:/comp/env/CSS"); */
		} catch (NamingException e) {
			e.getMessage();
			System.out.println("AnDAO 오류");
		}

	}

	public MemberDTO anLogin(String id, String password) {

		MemberDTO adto = null;
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select * " + " from member" + " where member_id = '" + id + "' and password = '" + password + "' ";
			prepareStatement = connection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				String member_id = resultSet.getString("member_id");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");

				adto = new MemberDTO(member_id, name, phone, email);
			}

			System.out.println("MemberDTO id : " + adto.getMember_id());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return adto;

	}

	public int anJoin(String member_id, String password, String name, String phone, String email) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int state = -100;

		try {
			connection = dataSource.getConnection();
			String query = "insert into member(member_id, password, name, phone, email) " + "values('" + member_id + "', '"
					+ password + "', '" + name + "', '" + phone + "', '" + email + "' )";
			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println(state + "삽입성공");
			} else {
				System.out.println(state + "삽입실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return state;

	}

}
