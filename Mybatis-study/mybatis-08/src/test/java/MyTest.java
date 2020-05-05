import com.warren.dao.BlogMapper;
import com.warren.pojo.Blog;
import com.warren.utils.IDUtils;
import com.warren.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class MyTest {
    @Test
    public void Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("狂神说Java");
        blog.setAuthor("warren");
        blog.setCreateTime(new Date());
        blog.setViews(999);

        mapper.addBook(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("狂神说Mybatis");
        mapper.addBook(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("狂神说Spring");
        mapper.addBook(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("狂神说SpringMVC");
        mapper.addBook(blog);

        sqlSession.close();
    }
}
