package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/2
 * Time : 8:28
 * Talk is cheap. Show me the code.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;
    private HibernateTemplate ht;
    private Session session;
    private List<User> list;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        // TODO Auto-generated constructor stub
        this.sessionFactory=sessionFactory;
        this.ht = new HibernateTemplate(sessionFactory);
        this.session=sessionFactory.openSession();

    }
    @SuppressWarnings("unchecked")
    public boolean save(User user) {
        if (user!=null){
            session.save(user);
            return true;
        }else {
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    public boolean findByEmailAndPassword(String email, String password) {
        Criteria ctr=session.createCriteria(User.class);
        ctr.add(Restrictions.eq("email", email));
        ctr.add(Restrictions.eq("password",password));
        list= ctr.list();
        if(list.size() > 0) {
            return true;
        }else{
            return false;
        }
    }

    public boolean findByEmail(String email) {
        Criteria ctr=session.createCriteria(User.class);
        ctr.add(Restrictions.eq("email", email));
        list= ctr.list();
        if(list.size() > 0) {
            System.out.println(list.get(0).getNickName());
            return true;
        }else{
            return false;
        }
    }


}
