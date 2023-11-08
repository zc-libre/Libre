package com.libre.framework;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.google.common.collect.Lists;
import com.libre.framework.system.mapper.SysUserMapper;
import com.libre.framework.system.pojo.entity.SysUser;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class MybatisSaveBatchTests {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    private List<SysUser> userList = Lists.newArrayList();

    @Autowired
    private SysUserMapper sysUserMapper;

    @BeforeEach
    void init() throws SQLException {

        for (int i = 0; i < 500000; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUsername(IdWorker.get32UUID());
            sysUser.setPassword(IdWorker.get32UUID());
            userList.add(sysUser);
        }
    }

    @Test
    void saveTest() throws SQLException {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
        StopWatch stopWatch = new StopWatch();
        List<List<SysUser>> partition = Lists.partition(userList, 3000);
        stopWatch.start();
        for (List<SysUser> sysUsers : partition) {
            mapper.saveBatch(sysUsers);
            sqlSession.flushStatements();
		}
        sqlSession.commit();
        sqlSession.close();
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println(stopWatch.prettyPrint());

        stopWatch.start();
        for (List<SysUser> sysUsers : partition) {
            sysUserMapper.saveBatch(sysUsers);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println(stopWatch.prettyPrint());
    }
}
