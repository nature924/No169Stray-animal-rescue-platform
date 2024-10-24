package com.dao;

import com.entity.LiulangdongwuJinkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LiulangdongwuJinkuangView;

/**
 * 流浪动物近况 Dao 接口
 *
 * @author 
 */
public interface LiulangdongwuJinkuangDao extends BaseMapper<LiulangdongwuJinkuangEntity> {

   List<LiulangdongwuJinkuangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
