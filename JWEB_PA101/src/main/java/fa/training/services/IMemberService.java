package fa.training.services;

import fa.training.entities.Member;

public interface IMemberService {

	Member findByUsername(String username);

	boolean login(String username, String password);

	boolean saveRegister(Member member);

	boolean save(Member member);
}
