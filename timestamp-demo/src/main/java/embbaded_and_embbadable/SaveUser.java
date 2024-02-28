package embbaded_and_embbadable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {
	public static void main(String[] args) {
		UserId user=new UserId();
		user.setEmail("xyz@123");
		user.setPhone(666586);
		
		User u =new User();
		u.setUserId(user);
		u.setName("ABC");
		u.setPassword("abc123");
		
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=m.getTransaction();
		m.persist(u);
		t.begin();
		t.commit();
	}
}
