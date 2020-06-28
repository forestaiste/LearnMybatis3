package com.forest.mapper;

import com.forest.bean.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> getEmpListByCriteria(Emp emp);
}
