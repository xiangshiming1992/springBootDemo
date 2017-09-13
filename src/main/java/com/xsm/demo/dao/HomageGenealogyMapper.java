package com.xsm.demo.dao;

import com.xsm.demo.common.mybatis.mapper.Mapper;
import com.xsm.demo.entity.HomageGenealogy;
import com.xsm.demo.entity.HomageGenealogyExample;

public interface HomageGenealogyMapper extends Mapper<HomageGenealogy, HomageGenealogyExample, Long> {
    void isdf()throws  Exception;
}