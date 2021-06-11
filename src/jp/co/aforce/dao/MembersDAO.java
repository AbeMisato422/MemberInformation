package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MembersBean;

public class MembersDAO extends DAO{

	public MembersBean search(String memberNo)throws Exception{//publicの後のmembersBeanがよくわかってない

		//検索
		MembersBean membersBean=null;
		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement("select * from members where member_no=?");//DBのカラム名
		st.setString(1, memberNo);
		ResultSet rs=st.executeQuery();

		while(rs.next()) {
			membersBean=new MembersBean();
			membersBean.setMemberNo(rs.getString("member_no"));//DBのカラム名
			membersBean.setName(rs.getString("name"));
			membersBean.setAge(rs.getInt("age"));
			membersBean.setBirthYear(rs.getInt("birth_year"));
			membersBean.setBirthMonth(rs.getInt("birth_month"));
			membersBean.setBirthDay(rs.getInt("birth_day"));

		}

		st.close();
		con.close();
		return membersBean;
	}

	public int update(MembersBean membersBean)throws Exception{

		//変更

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement("update members set name =?, age=?, birth_year=?, birth_month=?, birth_day=?  where member_no=?");//DBのカラム名
		st.setString(1, membersBean.getName());
		st.setInt(2, membersBean.getAge());
		st.setInt(3, membersBean.getBirthYear());
		st.setInt(4, membersBean.getBirthMonth());
		st.setInt(5, membersBean.getBirthDay());
		st.setString(6, membersBean.getMemberNo());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	public int delete(String memberNo)throws Exception{

		//削除

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement("delete from members where member_no=?");//DBのカラム名
		st.setString(1, memberNo);
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}
