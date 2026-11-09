package bank.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
import util.JDBCClose;

public class MemberOracleDao implements MemberDao {

	@Override
	public boolean save(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			String sql = "insert into nhs_member(id, password, name, email, mobile, type) values (?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getMobile());
			pstmt.setString(6, String.valueOf(m.getType()));
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	@Override
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			String sql = "select id, password, name, email, mobile, type from nhs_member";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				char type = rs.getString("type").charAt(0);

				members.add(new Member(id, password, name, email, mobile, type));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return members;
	}

	@Override
	public Member findById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			String sql = "select id, password, name, email, mobile, type from nhs_member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String memberId = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				char type = rs.getString("type").charAt(0);

				return new Member(memberId, password, name, email, mobile, type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return null;
	}

	@Override
	public boolean update(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			if (findById(m.getId()) == null) return false;

			conn = new ConnectionFactory().getConnection();
			String sql = "update nhs_member set password = ?, name = ?, email = ?, mobile = ?, type = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getMobile());
			pstmt.setString(5, String.valueOf(m.getType()));
			pstmt.setString(6, m.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean delete(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			if (findById(m.getId()) == null) return false;

			conn = new ConnectionFactory().getConnection();
			String sql = "delete from nhs_member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false;
	}
}

