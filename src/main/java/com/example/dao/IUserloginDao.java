package com.example.dao;

import com.example.bean.Userlogin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 用户登陆Dao的接口
 */
public interface IUserloginDao {
    /**
     * 查询全部登陆用户
     */
    @Select("select * from tb_userlogin")
    List<Userlogin> findAll();

    /**
     * 添加一位用户
     */
    @Insert("insert into tb_userlogin (id,loginName,pwd,type,mail) " +
            "values (#{id},#{loginName},#{pwd},#{type},#{mail}) ")
    void add(Userlogin userlogin);

    /**
     * 根据id查询用户信息
     */
    @Select("select * from tb_userlogin where id = #{id}")
    Userlogin findById(String id);

    /**
     * 根据id删除用户
     */
    @Delete("delete from tb_userlogin where id = #{id}")
    void delete(String id);

    /**
     * 根据类型查询所有用户
     */
    @Select("select * from tb_userlogin where type = #{type}")
    List<Userlogin> findAllByType(String type);
    /**
     * 根据id查询用户类型
     */
    @Select("select type from tb_userlogin where id = #{id}")
    String getTypeById(String id);
    /**
     * 更新用户信息
     */
    @Update("update tb_userlogin set loginName = #{loginName}," +
            "pwd = #{pwd}, mail = #{mail} where id = #{id}")
    void update(Userlogin userlogin);
}
