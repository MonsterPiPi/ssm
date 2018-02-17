import com.example.bean.Position;
import com.example.bean.Stuuser;
import com.example.dao.IPositionDao;
import com.example.dao.IStuuserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by LiQian_Nice on 2018/2/10
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/SpringApplicationContext.xml"})
public class IPositionDaoTest {

    private static Logger logger= LoggerFactory.getLogger(IPositionDaoTest.class);
    @Autowired
    private IPositionDao dao;

    @Autowired
    private IStuuserDao iStuuserDao;
    @Test
    public void testgetPositionById() {
        int id = 1;
        Position position = dao.getPositionById(id);
        System.out.println(position.getName());
    }
    @Test
    public void addUser(){
        Stuuser stuuser=new Stuuser();
        stuuser.setId(11);
        stuuser.setStuName("111");
        stuuser.setAddr("111");
        stuuser.setBirthday("111");
        stuuser.setHomeAddr("111");
        stuuser.setStuNo("111");
        stuuser.setStuSex("111");
        stuuser.setTel("111");
        stuuser.setSpecialtyId(1);

        boolean flag=iStuuserDao.addStuuser(stuuser);
        logger.info("----------",flag);

    }
}
