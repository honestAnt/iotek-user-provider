package com.iotekclass.user.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iotekclass.common.junit.BaseMapperTest;
import com.iotekclass.model.user.City;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by honestAnt on 2016/10/19.
 */
public class CountryMapperTest extends BaseMapperTest {

    /*@Autowired
    CityMapper cityMapper;
    */
    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test() {
        CityMapper countryMapper = sqlSession.getMapper(CityMapper.class);
        Example example = new Example(City.class);
        example.createCriteria().andGreaterThan("id",100);
        PageHelper.startPage(2,10);
        List<City> countries = countryMapper.selectByExample(example);
        PageInfo<City> pageInfo = new PageInfo<City>(countries);
        System.out.println(pageInfo.getTotal());

        countries = countryMapper.selectByExample(example);
        pageInfo = new PageInfo<City>(countries);
        System.out.println(pageInfo.getTotal());
    }
}
