package com.dao;

import com.entity.LiulangdongwuZhuyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LiulangdongwuZhuyangView;

/**
 * 流浪动物助养 Dao 接口
 *
 * @author 
 */
public interface LiulangdongwuZhuyangDao extends BaseMapper<LiulangdongwuZhuyangEntity> {

   List<LiulangdongwuZhuyangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
