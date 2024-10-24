package com.dao;

import com.entity.LiulangdongwuOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LiulangdongwuOrderView;

/**
 * 流浪动物领养 Dao 接口
 *
 * @author 
 */
public interface LiulangdongwuOrderDao extends BaseMapper<LiulangdongwuOrderEntity> {

   List<LiulangdongwuOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
