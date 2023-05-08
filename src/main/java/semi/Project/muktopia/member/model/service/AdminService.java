package semi.Project.muktopia.member.model.service;

import static semi.Project.muktopia.common.JDBCTemplate.close;
import static semi.Project.muktopia.common.JDBCTemplate.commit;
import static semi.Project.muktopia.common.JDBCTemplate.getConnection;
import static semi.Project.muktopia.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import semi.Project.muktopia.member.model.dao.AdminDAO;

import semi.Project.muktopia.member.model.vo.Member;


public class AdminService {
	
	
	private AdminDAO dao = new AdminDAO();
	
	Connection conn = getConnection();

	public Member adminlogin(Member mem) throws Exception{
	     Connection conn = getConnection();
			
			// DAO 수행
			Member loginMember = dao.adminlogin(conn, mem);
			
			// Connection 반환
			close(conn);
			
			// 결과 반환
			return loginMember;
	}

	/** 회원전체 목록을 가져오는 service
	 * @return
	 */
	public List<Member> memberLoad() throws Exception {
		Connection conn= getConnection();
		List<Member> memberList =  dao.memberLoad(conn);
		
		return memberList;
	}

	/** 멤버를 탈퇴시키는 service
	 * @return
	 */
	public int DeleteMember(int memberNo) throws Exception{
		
		Connection conn= getConnection();
		int result = dao.DeleteMember(conn, memberNo);
		
		if(result  > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
		
	}

	
	
	
}
