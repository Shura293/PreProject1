package dao;

import model.User;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.*;

import java.util.List;

public class UserHibernateDAO implements UserDAOInterface {

    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(User user) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void editUser(User user) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(User user) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public boolean isExistUser(User user) {
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM User AS U WHERE U.userName = :userName and U.firstName= :firstName and U.secondName= :secondName and U.age= :age");
            query.setParameter("userName", user.getUserName());
            query.setParameter("firstName", user.getFirstName());
            query.setParameter("secondName", user.getSecondName());
            query.setParameter("age", user.getAge());
            result = query.list().size() > 0;

            transaction.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> userList = null;
        try {
            transaction = session.beginTransaction();
            userList = session.createQuery("FROM User").list();
            transaction.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return userList;
    }
}