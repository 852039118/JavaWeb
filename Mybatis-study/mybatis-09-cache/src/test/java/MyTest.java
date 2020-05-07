import com.warren.dao.UserMapper;
import com.warren.pojo.User;
import com.warren.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        //sqlSession.clearCache();//手动清理缓存
        System.out.println("=====================");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("=====================");

        sqlSession.close();//只有当一个会话提交或者结束时，缓存才会提交到二级缓存中

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println("=====================");
        System.out.println(user==user2);
        sqlSession2.close();
    }
}
