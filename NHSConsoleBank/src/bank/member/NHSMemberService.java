package bank.member;

import java.util.Iterator;
import java.util.List;

// 이 서비스는 남효성이 구현하였습니다.
public class NHSMemberService implements MemberService {

	final String ADMIN_ID = "admin";
	final String ADMIN_PWD = "1234";

	private MemberDao dao;
	private Member loggedMember;

	public NHSMemberService(MemberDao dao) {
		this.dao = dao;
		this.dao.save(new Member(ADMIN_ID, ADMIN_PWD, ADMIN_ID, null, null, Member.ADMIN));
	}

	@Override
	public boolean join(String id, String password, String name) {
		if (dao.findById(id) != null) {
			return false;
		}
		Member newMember = new Member(id, password, name, null, null, Member.USER);
		return dao.save(newMember);
	}

	@Override
	public boolean login(String id, String password) {
		Member m = dao.findById(id);
		if (m != null && m.getPassword().equals(password)) {
			loggedMember = m;
			return true;
		}
		return false;
	}

	@Override
	public Member getLoggedMember() {
		return loggedMember;
	}

	@Override
	public boolean logout() {
		loggedMember = null;
		return true;
	}

	@Override
	public List<Member> getAllMembers() {
		List<Member> mlist = dao.findAll();
		if (mlist == null) return null;

		Iterator<Member> iter = mlist.iterator();
		while (iter.hasNext()) {
			if (iter.next().getType() == Member.ADMIN) {
				iter.remove();
			}
		}

		return mlist.isEmpty() ? null : mlist;
	}

	@Override
	public Member getMemberInfo(String id) {
		if (loggedMember == null) return null;

		if (loggedMember.getType() == Member.ADMIN || loggedMember.getId().equals(id)) {
			return dao.findById(id);
		}
		return null;
	}

	@Override
	public boolean changePassword(String id, String curPassword, String newPassword) {
		if (loggedMember == null) return false;

		Member m = dao.findById(id);
		if (m == null) return false;

		if (loggedMember.getType() == Member.ADMIN) {
			m.setPassword(newPassword);
			return dao.update(m);
		}

		if (loggedMember.getId().equals(id) && m.getPassword().equals(curPassword)) {
			m.setPassword(newPassword);
			return dao.update(m);
		}

		return false;
	}

	@Override
	public boolean addMemberInfo(String id, String email, String mobile) {
		return false;
	}

	@Override
	public boolean withdrawMembership(String id, String password) {
		return false;
	}

}
