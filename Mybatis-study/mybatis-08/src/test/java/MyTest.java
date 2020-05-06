import com.warren.dao.BlogMapper;
import com.warren.pojo.Blog;
import com.warren.utils.IDUtils;
import com.warren.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","狂神说Mybatis");
        map.put("author","warren");

        List<Blog> blogList = mapper.queryBlogIF(map);
        for (Blog blog:blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("title","狂神说Mybatis");
        map.put("author","warren");
//        map.put("views","999");

        List<Blog> blogList = mapper.queryBlogChoose(map);
        for (Blog blog:blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, List> map = new HashMap<String, List>();

        ArrayList<String> ids = new ArrayList<String>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        map.put("ids",ids);

        List<Blog> blogList = mapper.queryBlogForeach(map);
        for (Blog blog:blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("title","狂神说Java8");
//            map.put("author","warren");
            map.put("id","78e73e351cf8413b8532b1af0494ee63");

            int num = mapper.updateBlog(map);
                System.out.println(num + "列更新成功");
            sqlSession.close();
        }
}
