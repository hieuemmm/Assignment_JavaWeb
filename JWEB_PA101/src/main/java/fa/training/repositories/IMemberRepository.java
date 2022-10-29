package fa.training.repositories;


import fa.training.entities.Member;

public interface IMemberRepository {

	Member findByUserName(String username);

	boolean saveRegister(Member member);

	boolean saveEdit(Member member);

}
