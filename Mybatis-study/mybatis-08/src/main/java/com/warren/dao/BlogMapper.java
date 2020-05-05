package com.warren.dao;

import com.warren.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBook(Blog blog);

    List<Blog> queryBlogIF(Map map);
}
