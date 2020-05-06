package com.warren.dao;

import com.warren.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //新增博客
    int addBook(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(Map map);

    //查询第1,2,3号博客
    List<Blog> queryBlogForeach(Map map);

    //更新博客
    int updateBlog(Map map);
}
