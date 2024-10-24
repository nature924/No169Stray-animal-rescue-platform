package com.dao;

import com.entity.LiulangdongwuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LiulangdongwuCollectionView;

/**
 * 流浪动物收藏 Dao 接口
 *
 * @author 
 */
public interface LiulangdongwuCollectionDao extends BaseMapper<LiulangdongwuCollectionEntity> {

   List<LiulangdongwuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
