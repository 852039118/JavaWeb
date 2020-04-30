import com.warren.dao.UserMapper;
import com.warren.pojo.User;
import com.warren.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.getUsers();

        for(User user:users){
            System.out.println(user);
        }
        //MybatisUtils.getSqlSession()中已经设置了自动提交
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int number = mapper.addUser(new User(6, "阿六", "666666"));
        if (number > 0){
            System.out.println(number + "列插入成功！");
        }
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int number = mapper.updateUser(new User(6, "阿六不六pwd", "pwd686"));
        if (number > 0){
            System.out.println(number + "列修改成功！");
        }
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int number = mapper.deleteUser(6);
        if (number > 0){
            System.out.println(number + "列删除成功！");
        }
        sqlSession.close();
    }
}
