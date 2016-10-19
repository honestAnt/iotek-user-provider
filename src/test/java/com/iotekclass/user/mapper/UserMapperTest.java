package com.iotekclass.user.mapper;

import com.iotekclass.common.junit.BaseMapperTransactionalTest;
import com.iotekclass.model.user.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.mybatis.generator.codegen.ibatis2.model.ExampleGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import static org.testng.Assert.*;

/**
 * Created by honestAnt on 2016/10/18.
 */
public class UserMapperTest extends BaseMapperTransactionalTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testGetById() {
        Assert.assertNotNull(userMapper.selectByPrimaryKey(1));
    }
    @Test
    public void testSave() {
        UserInfo userInfo = userMapper.selectByPrimaryKey(1);
        userInfo.setTeleNumber("13022523213");
        Assert.assertNotNull(userMapper.updateByPrimaryKey(userInfo));
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",userInfo.getId());
        userMapper.updateByExampleSelective(userInfo, example);
    }
    @Test
    public void testDelete() {
        Assert.assertNotNull(userMapper.selectByPrimaryKey(1));
    }
    @Test
    public void testUpdate() {
        Assert.assertNotNull(userMapper.selectByPrimaryKey(1));
    }
}