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

    @Select("select * from tb_userlogin")
    List<Userlogin> findAll();

    @Insert("insert into tb_userlogin (id,loginName,pwd,type,mail) " +
            "values (#{id},#{loginName},#{pwd},#{type},#{mail}) ")
    void add(Userlogin userlogin);

    @Select("select * from tb_userlogin where id = #{id}")
    Userlogin findById(String id);

    @Delete("delete from tb_userlogin where id = #{id}")
    void delete(String id);

    @Select("select * from tb_userlogin where type = #{type}")
    List<Userlogin> getAllByType(String type);

    @Select("select type from tb_userlogin where id = #{id}")
    String getTypeById(String id);

    @Update("update tb_userlogin set loginName = #{loginName}," +
            "pwd = #{pwd}, mail = #{mail} where id = #{id}")
    void update(Userlogin userlogin);
}
