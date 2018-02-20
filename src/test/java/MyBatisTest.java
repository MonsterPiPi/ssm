import com.example.bean.Course;
import com.example.bean.Position;
import com.example.bean.Specialty;
import com.example.bean.Stuuser;
import com.example.dao.ICourseDao;
import com.example.dao.IPositionDao;
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
    private IPositionDao positionDao;

    @Autowired
    private IStuuserDao stuuserDao;

    @Autowired
    private ICourseDao courseDao;

    @Resource
    private ISpecialtyDao specialtyDao;

    @Test
    public void getPositionById() {
        int id = 1;
        Position position = positionDao.getPositionById(id);
        System.out.println(position.getName());
    }
    @Test
    public void addUser(){
        Stuuser stuuser=new Stuuser();
        stuuser.setId("11");
        stuuser.setStuName("111");
        stuuser.setAddr("111");
        stuuser.setBirthday("111");
        stuuser.setHomeAddr("111");
        stuuser.setStuNo("111");
        stuuser.setStuSex("111");
        stuuser.setTel("111");
        stuuser.setSpecialtyId("1");

        boolean flag=stuuserDao.addStuuser(stuuser);
        logger.info("----------",flag);

    }
    @Test
    public void getAllCourse(){
        List<Course> list=courseDao.getAllCourse();
        for (Course course:list){
            logger.info("----------"+course.getId()) ;
        }
    }
    @Test
    public void getAllSpecialty(){
        List<Specialty> list=specialtyDao.getAllSpecialty();
        for (Specialty specialty:list){
            logger.info("----------"+specialty.getName());
        }
    }

    @Test
    public void getCoursesByName(){
        List<Course> list=courseDao.getCoursesByName("2");
        for (Course course:list){
            logger.info("----------"+course.getId()) ;
        }
    }

    @Test
    public void deleteCourseById(){
        courseDao.deleteCourseById("4");
    }
}
