package com.warren.dao;

import com.warren.pojo.Student;
import com.warren.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    public List<Student> getStudents();
    public List<Student> getStudents2();
}
