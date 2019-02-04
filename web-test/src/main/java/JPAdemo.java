import com.test.entity.Comment;
import com.test.entity.Role;
import com.test.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class JPAdemo {

    private  EntityManagerFactory factory;

    private EntityManager entity;

    private EntityTransaction transaction;
    @Before
    public void init() {
        factory = Persistence.createEntityManagerFactory("jpa");
        entity=factory.createEntityManager();
        transaction = entity.getTransaction();
        transaction.begin();

    }


    @Test
    public void findOneUser() {
        User user = entity.find(User.class, 2);
        System.out.println(user);

    }
    @Test
    public void findUser() {
        Query q = entity.createQuery("select u from User u ");
        List<User> list = q.getResultList();
        for (User user : list) {
            for (Comment c : user.getComments()) {
                System.out.println(c);
            }
        }
    }

    @Test
    public void findComm() {
        Query q = entity.createQuery("select c from Comment c ");
        List<Comment> list = q.getResultList();
        for (Comment c : list) {
            System.out.println(c.getUser());
        }

    }

    @Test
    public void insert() {
        User user=new User("yjy",new Date());
        entity.persist(user);

    }

    @Test
    public void update() {
        User user = new User();

        user.setId(2);
        user.setName("DSD");
        user.setBirthday(new Date());

        entity.merge(user);


    }

    @Test
    public void delete() {
        User user = new User();

        user.setId(2);

        entity.remove(user);


    }


    @Test
    public void oneToMany() {
        User user = entity.find(User.class, 2);
        for (Comment c : user.getComments()) {
            System.out.println(c);
        }
    }

    @Test
    public void manyToManyRoles() {
        User user = entity.find(User.class, 3);
        for (Role r : user.getRoles()) {
            System.out.println(r);
        }
    }

    @Test
    public void manyToManyRoles1() {
        Role role = entity.find(Role.class, 2);
        for (User r : role.getUsers()) {
            System.out.println(r);
        }
    }

    @Test
    public void JoinSql() {
        Query nativeQuery = entity.createNativeQuery("select u.* from User u inner join Comment c on u.id = c.user_id  ",User.class);
        //Query nativeQuery = entity.createQuery("select u from User u left join Comment c on u.id = c.user  ");

        List<User> list = nativeQuery.getResultList();

        for (User u : list) {
            System.out.println(u.getComments());
        }


    }

    @Test
    public void JoinSql2() {
        Query query = entity.createQuery("select u from User u  join Comment c on u.id = c.userId where  c.spoken = :spk",User.class);
        //Query nativeQuery = entity.createQuery("select u from User u left join Comment c on u.id = c.user  ");
        query.setParameter("spk","sadasdasd");
        List<User> list = query.getResultList();

        for (User u : list) {
            System.out.println(u);
        }


    }

    @Test
    public void JoinSql3() {
        Query query = entity.createQuery("select u from User u  join u.comments c where c.spoken = :spk",User.class);
        //Query nativeQuery = entity.createQuery("select u from User u left join Comment c on u.id = c.user  ");
        query.setParameter("spk","sadasdasd");
        List<User> list = query.getResultList();

        for (User u : list) {
            System.out.println(u);
        }


    }



    @After
    public void postdo() {
        transaction.commit();
        entity.close();
        factory.close();
    }
}
