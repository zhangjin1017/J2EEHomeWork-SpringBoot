package com.zj.mapper;

import com.zj.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentMapper {
    //查询所有
     List<Student> findAll();

}
