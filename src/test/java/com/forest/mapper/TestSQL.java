package com.forest.mapper;

import com.forest.bean.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestSQL {
    @Test
    public void TestIf() throws Exception {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp emp = new Emp(15, "Craig", 45, "Male");

        List<Emp> list = mapper.getEmpListByCriteria(emp);

        for (Emp e: list) {
            System.out.println(e);
        }
    }

    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        return  sqlSessionFactory;
    }
}
