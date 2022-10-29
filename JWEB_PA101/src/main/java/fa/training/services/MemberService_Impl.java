package fa.training.services;


import fa.training.entities.Member;
import fa.training.repositories.IMemberRepository;
import fa.training.repositories.MemberRepository_Impl;

public class MemberService_Impl implements IMemberService {
	private IMemberRepository memberRepository = new MemberRepository_Impl();

	@Override
	public boolean login(String username, String password) {
		username = username.trim();
		password = password.trim();
		if (!username.equals("") && !password.equals("")) {
			Member member = memberRepository.findByUserName(username);
			if(member != null) {
				if (member.getUserName().equals(username) && member.getPassWord().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Member findByUsername(String username) {
		return memberRepository.findByUserName(username);
	}

	@Override
	public boolean saveRegister(Member member) {
		return memberRepository.saveRegister(member);
	}

	@Override
	public boolean saveEdit(Member member) {
		return memberRepository.saveEdit(member);
	}
}
