package com.dao;

import com.entity.LiulangdongwuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LiulangdongwuLiuyanView;

/**
 * 流浪动物留言 Dao 接口
 *
 * @author 
 */
public interface LiulangdongwuLiuyanDao extends BaseMapper<LiulangdongwuLiuyanEntity> {

   List<LiulangdongwuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
