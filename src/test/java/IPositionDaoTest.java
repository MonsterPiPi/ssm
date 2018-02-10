import com.example.bean.Position;
import com.example.dao.IPositionDao;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Autowired
    private IPositionDao dao;

    @Test
    public void testgetPositionById() {
        int id = 1;
        Position position = dao.getPositionById(id);
        System.out.println(position.getName());
    }
}
