package embbaded_and_embbadable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FindUserByPrimaryKey {
	public static void main(String[] args) {
		UserId user=new UserId();
		user.setEmail("xyz@123");
		user.setPhone(666586);
		
		
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		User u=m.find(User.class, user);
		if(u!=null) {
			System.out.println("User Name: "+u.getName());
			System.out.println("User Phone No: "+u.getUserId().getPhone());
			System.out.println("User Email: "+u.getUserId().getEmail());
		}else {
			System.err.println("Invalid Phone OR Email ID");
		}
	}
}
