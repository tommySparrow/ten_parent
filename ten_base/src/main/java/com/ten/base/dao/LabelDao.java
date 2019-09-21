package com.ten.base.dao;

import com.ten.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaSpecificationExecutor 用于分页查询
 * @author jerry
 */
public interface LabelDao extends JpaRepository<Label,String> , JpaSpecificationExecutor<Label> {
}
