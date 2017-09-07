package com.xsm.demo.common.mybatis;

import com.xsm.demo.common.mybatis.model.ModelExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;



public interface Manager<M , E extends ModelExample, ID> {

	int countByExample(E example);

	int deleteByExample(E example);

	int deleteByPrimaryKey(ID id);

	int insert(M model);

	int insertSelective(M model);

	List<M> selectByExample(E example);

	M selectByPrimaryKey(ID id);

	M selectOneByExample(E example);

	Page<M> selectPageByExample(Pageable pageable, E example);

	Page<M> selectPageByExample(Pageable pageable, long rows, E example);

	int updateByExampleSelective(M model, E example);

	int updateByExample(M model, E example);

	int updateByPrimaryKeySelective(M model);

	int updateByPrimaryKey(M model);

}
