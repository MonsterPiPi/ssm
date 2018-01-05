package com.example.dao.impl;

import com.example.dao.BlogDao;
import com.example.pojo.Blog;
import com.example.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 18:05
 * Talk is cheap. Show me the code.
 */
@Repository
public class BlogDaoImpl implements BlogDao {
    @Resource
    private SessionFactory sessionFactory;
    private HibernateTemplate ht;
    private Session session;
    private List<Blog> list;

    @Autowired
    public BlogDaoImpl(SessionFactory sessionFactory) {
        // TODO Auto-generated constructor stub
        this.sessionFactory=sessionFactory;
        this.ht = new HibernateTemplate(sessionFactory);
        this.session=sessionFactory.openSession();

    }

    public void save(Blog blog) {
        ht.save(blog);
    }

    public List<Blog> findBlogs(String searchText) {
        String queryString = "from Blog s where s.title like'%"+searchText+"%'";
        //注意这个HQL语句的拼接部分,不能写错！
        Query queryObject = session.createQuery(queryString);
        list=queryObject.list();
        if (list.size()>0){
            return list;
        }else {
            return null;
        }
    }
}
