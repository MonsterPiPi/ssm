import com.example.bean.Course;
import com.example.bean.Specialty;
import com.example.bean.Stuuser;
import com.example.dao.ICourseDao;
import com.example.dao.ISpecialtyDao;
import com.example.dao.IStuuserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by LiQian_Nice on 2018/2/10
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/SpringApplicationContext.xml"})
public class MyBatisTest {

    private static Logger logger= LoggerFactory.getLogger(MyBatisTest.class);

    @Autowired
    private IStuuserDao stuuserDao;

    @Autowired
    private ICourseDao courseDao;

    @Resource
    private ISpecialtyDao specialtyDao;


    @Test
    public void addUser(){
        Stuuser stuuser=new Stuuser();
        stuuser.setId("33");
        stuuser.setStuName("222");
        stuuser.setAddr("222");
        stuuser.setBirthday("222");
        stuuser.setHomeAddr("222");
        stuuser.setStuNo("222");
        stuuser.setStuSex("222");
        stuuser.setTel("222");
        stuuser.setSpecialtyId("2");

        stuuserDao.add(stuuser);
        logger.info("----------");

    }
    @Test
    public void findSameSpecialtyStuuser(){
        List<String> strings=new ArrayList<>();
        strings=stuuserDao.findSameSpecialtyStuuser("1");
        for(String string:strings){
            logger.info("----------"+string.toString()) ;
        }
    }
    @Test
    public void getAllCourse(){
        List<Course> list=courseDao.findAll();
        for (Course course:list){
            logger.info("----------"+course.getId()) ;
        }
    }
    @Test
    public void getAllSpecialty(){
        List<Specialty> list=specialtyDao.findAll();
        for (Specialty specialty:list){
            logger.info("----------"+specialty.getName());
        }
    }
    @Test
    public void addSpecialty(){
        Specialty specialty=new Specialty();
        specialty.setName("测试");
        specialty.setEnterYear("none");
        specialty.setIsFinish(1);
        specialty.setLangthYear("4");
        specialtyDao.add(specialty);
    }

    @Test
    public void getCoursesByName(){
        List<Course> list=courseDao.findAllByName("2");
        for (Course course:list){
            logger.info("----------"+course.getId()) ;
        }
    }

    @Test
    public void deleteCourseById(){
        courseDao.delete("4");
    }
}
