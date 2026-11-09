package test;

import bank.member.Member;
import bank.member.MemberDao;
import bank.member.MemberOracleDao;
import bank.member.MemberService;
import bank.member.NHSMemberService;
import java.util.List;

public class TestMember {

    public static void main(String[] args) {
        testMemberOracleDao();
    }

    public static void testMemberService() {
        MemberService ms = new NHSMemberService(new MemberOracleDao());

        System.out.println(">> 회원가입 및 목록조회");
        ms.join("nhs", "1111", "남효성");
        ms.join("nhs", "1111", "남효성");
        ms.join("user1", "1111", "남성효");

        printMemberList(ms.getAllMembers());

        System.out.println(">> 로그인, 로그아웃");
        if (ms.login("nhs", "1111")) {
            System.out.println(ms.getLoggedMember());
        }
        ms.logout();
        System.out.println(ms.getLoggedMember());

        System.out.println(">> 회원정보 보기");
        ms.login("nhs", "1111");
        System.out.println(ms.getMemberInfo("user1"));
        System.out.println(ms.getMemberInfo("nhs"));

        System.out.println(">> 비밀번호 변경");
        ms.changePassword("nhs", "1111", "3333");
        printMemberList(ms.getAllMembers());
    }

    public static void testMemberDao() {
        MemberDao mdao = new MemberOracleDao();

        System.out.println("회원 추가");
        mdao.save(new Member("admin", "1234", "admin", null, null, Member.ADMIN));
        mdao.save(new Member("nhs", "1111", "남효성", null, null, Member.USER));
        mdao.save(new Member("user1", "1111", "남성효", null, null, Member.USER));

        System.out.println("회원 목록");
        List<Member> mlist = mdao.findAll();
        printMemberList(mlist);

        System.out.println("id로 회원 조회");
        Member m = mdao.findById("user1");
        System.out.println(m);

        System.out.println("비밀번호 변경");
        m.setPassword("1234");
        mdao.update(m);
        printMemberList(mdao.findAll());

        System.out.println("회원 삭제");
        mdao.delete(mdao.findById("user1"));
        printMemberList(mdao.findAll());
    }

    public static void testMemberOracleDao() {
        MemberDao mdao = new MemberOracleDao();

        System.out.println("회원 추가");
        mdao.save(new Member("nhs", "1111", "남효성", null, null, Member.USER));
        mdao.save(new Member("user1", "1111", "남성효", null, null, Member.USER));
        mdao.save(new Member("user2", "1111", "효성킴", null, null, Member.USER));

        System.out.println("회원 목록");
        printMemberList(mdao.findAll());

        System.out.println("id로 회원 조회");
        Member member = mdao.findById("nhs");
        System.out.println(member);

        System.out.println("비밀번호 변경");
        if (member != null) {
            member.setPassword("1234");
            mdao.update(member);
        }
        printMemberList(mdao.findAll());

        System.out.println("회원 삭제");
        mdao.delete(mdao.findById("user1"));
        printMemberList(mdao.findAll());
    }

    public static void printMemberList(List<Member> mlist) {
        if (mlist == null) {
            return;
        }
        for (Member m : mlist) {
            System.out.println(m);
        }
    }
}
