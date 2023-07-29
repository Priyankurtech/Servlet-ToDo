package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Task;
import dto.User;

public class UserDao {
    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    public void save(User user)
    {
    	entityTransaction.begin();
    	entityManager.persist(user);
    	entityTransaction.commit();
    }
    public void save(Task task)
    {
    	entityTransaction.begin();
    	entityManager.persist(task);
    	entityTransaction.commit();
    }
    public User fetchByEmail(String mail)
    {
    	List<User> list=entityManager.createQuery("select x from User x where mail=?12").setParameter(12, mail).getResultList();
    	if(list.isEmpty())
    	{
    		return null;
    	}
    	else {
			return list.get(0);
		}
    }
//    public Task fetchbyname(String Task_Name)
//    {
//    	List<Task> list=entityManager.createQuery("select x from Task x where Task_Name=?13").setParameter(13, Task_Name).getResultList();
//    	if(list.isEmpty())
//    	{
//    		return null;
//    	}
//    	else {
//			return list.get(0);
//		}
//    }
	public List<Task> fetchAlltask(){
    	return entityManager.createQuery("select x from Task x").getResultList();
    }
   
    
}
