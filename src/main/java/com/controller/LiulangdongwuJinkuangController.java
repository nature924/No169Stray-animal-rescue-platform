
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 流浪动物近况
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liulangdongwuJinkuang")
public class LiulangdongwuJinkuangController {
    private static final Logger logger = LoggerFactory.getLogger(LiulangdongwuJinkuangController.class);

    private static final String TABLE_NAME = "liulangdongwuJinkuang";

    @Autowired
    private LiulangdongwuJinkuangService liulangdongwuJinkuangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiulangdongwuService liulangdongwuService;//流浪动物
    @Autowired
    private LiulangdongwuCollectionService liulangdongwuCollectionService;//流浪动物收藏
    @Autowired
    private LiulangdongwuHuafeiService liulangdongwuHuafeiService;//流浪动物花费
    @Autowired
    private LiulangdongwuLiuyanService liulangdongwuLiuyanService;//流浪动物留言
    @Autowired
    private LiulangdongwuOrderService liulangdongwuOrderService;//流浪动物领养
    @Autowired
    private LiulangdongwuZhuyangService liulangdongwuZhuyangService;//流浪动物助养
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = liulangdongwuJinkuangService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuJinkuangView> list =(List<LiulangdongwuJinkuangView>)page.getList();
        for(LiulangdongwuJinkuangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LiulangdongwuJinkuangEntity liulangdongwuJinkuang = liulangdongwuJinkuangService.selectById(id);
        if(liulangdongwuJinkuang !=null){
            //entity转view
            LiulangdongwuJinkuangView view = new LiulangdongwuJinkuangView();
            BeanUtils.copyProperties( liulangdongwuJinkuang , view );//把实体数据重构到view中
            //级联表 流浪动物
            //级联表
            LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(liulangdongwuJinkuang.getLiulangdongwuId());
            if(liulangdongwu != null){
            BeanUtils.copyProperties( liulangdongwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLiulangdongwuId(liulangdongwu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(liulangdongwuJinkuang.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LiulangdongwuJinkuangEntity liulangdongwuJinkuang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liulangdongwuJinkuang:{}",this.getClass().getName(),liulangdongwuJinkuang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            liulangdongwuJinkuang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LiulangdongwuJinkuangEntity> queryWrapper = new EntityWrapper<LiulangdongwuJinkuangEntity>()
            .eq("liulangdongwu_id", liulangdongwuJinkuang.getLiulangdongwuId())
            .eq("yonghu_id", liulangdongwuJinkuang.getYonghuId())
            .eq("liulangdongwu_jinkuang_name", liulangdongwuJinkuang.getLiulangdongwuJinkuangName())
            .eq("liulangdongwu_jinkuang_address", liulangdongwuJinkuang.getLiulangdongwuJinkuangAddress())
            .eq("liulangdongwu_jinkuang_types", liulangdongwuJinkuang.getLiulangdongwuJinkuangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiulangdongwuJinkuangEntity liulangdongwuJinkuangEntity = liulangdongwuJinkuangService.selectOne(queryWrapper);
        if(liulangdongwuJinkuangEntity==null){
            liulangdongwuJinkuang.setInsertTime(new Date());
            liulangdongwuJinkuang.setCreateTime(new Date());
            liulangdongwuJinkuangService.insert(liulangdongwuJinkuang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiulangdongwuJinkuangEntity liulangdongwuJinkuang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,liulangdongwuJinkuang:{}",this.getClass().getName(),liulangdongwuJinkuang.toString());
        LiulangdongwuJinkuangEntity oldLiulangdongwuJinkuangEntity = liulangdongwuJinkuangService.selectById(liulangdongwuJinkuang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            liulangdongwuJinkuang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(liulangdongwuJinkuang.getLiulangdongwuJinkuangPhoto()) || "null".equals(liulangdongwuJinkuang.getLiulangdongwuJinkuangPhoto())){
                liulangdongwuJinkuang.setLiulangdongwuJinkuangPhoto(null);
        }

            liulangdongwuJinkuangService.updateById(liulangdongwuJinkuang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LiulangdongwuJinkuangEntity> oldLiulangdongwuJinkuangList =liulangdongwuJinkuangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        liulangdongwuJinkuangService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<LiulangdongwuJinkuangEntity> liulangdongwuJinkuangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LiulangdongwuJinkuangEntity liulangdongwuJinkuangEntity = new LiulangdongwuJinkuangEntity();
//                            liulangdongwuJinkuangEntity.setLiulangdongwuId(Integer.valueOf(data.get(0)));   //流浪动物 要改的
//                            liulangdongwuJinkuangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            liulangdongwuJinkuangEntity.setLiulangdongwuJinkuangUuidNumber(data.get(0));                    //流浪动物近况编号 要改的
//                            liulangdongwuJinkuangEntity.setLiulangdongwuJinkuangName(data.get(0));                    //近况标题 要改的
//                            liulangdongwuJinkuangEntity.setLiulangdongwuJinkuangPhoto("");//详情和图片
//                            liulangdongwuJinkuangEntity.setLiulangdongwuJinkuangAddress(data.get(0));                    //记录地点 要改的
//                            liulangdongwuJinkuangEntity.setLiulangdongwuJinkuangTypes(Integer.valueOf(data.get(0)));   //流浪动物状态 要改的
//                            liulangdongwuJinkuangEntity.setJiluTime(sdf.parse(data.get(0)));          //记录时间 要改的
//                            liulangdongwuJinkuangEntity.setLiulangdongwuJinkuangContent("");//详情和图片
//                            liulangdongwuJinkuangEntity.setInsertTime(date);//时间
//                            liulangdongwuJinkuangEntity.setCreateTime(date);//时间
                            liulangdongwuJinkuangList.add(liulangdongwuJinkuangEntity);


                            //把要查询是否重复的字段放入map中
                                //流浪动物近况编号
                                if(seachFields.containsKey("liulangdongwuJinkuangUuidNumber")){
                                    List<String> liulangdongwuJinkuangUuidNumber = seachFields.get("liulangdongwuJinkuangUuidNumber");
                                    liulangdongwuJinkuangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> liulangdongwuJinkuangUuidNumber = new ArrayList<>();
                                    liulangdongwuJinkuangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("liulangdongwuJinkuangUuidNumber",liulangdongwuJinkuangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //流浪动物近况编号
                        List<LiulangdongwuJinkuangEntity> liulangdongwuJinkuangEntities_liulangdongwuJinkuangUuidNumber = liulangdongwuJinkuangService.selectList(new EntityWrapper<LiulangdongwuJinkuangEntity>().in("liulangdongwu_jinkuang_uuid_number", seachFields.get("liulangdongwuJinkuangUuidNumber")));
                        if(liulangdongwuJinkuangEntities_liulangdongwuJinkuangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LiulangdongwuJinkuangEntity s:liulangdongwuJinkuangEntities_liulangdongwuJinkuangUuidNumber){
                                repeatFields.add(s.getLiulangdongwuJinkuangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [流浪动物近况编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        liulangdongwuJinkuangService.insertBatch(liulangdongwuJinkuangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = liulangdongwuJinkuangService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuJinkuangView> list =(List<LiulangdongwuJinkuangView>)page.getList();
        for(LiulangdongwuJinkuangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LiulangdongwuJinkuangEntity liulangdongwuJinkuang = liulangdongwuJinkuangService.selectById(id);
            if(liulangdongwuJinkuang !=null){


                //entity转view
                LiulangdongwuJinkuangView view = new LiulangdongwuJinkuangView();
                BeanUtils.copyProperties( liulangdongwuJinkuang , view );//把实体数据重构到view中

                //级联表
                    LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(liulangdongwuJinkuang.getLiulangdongwuId());
                if(liulangdongwu != null){
                    BeanUtils.copyProperties( liulangdongwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLiulangdongwuId(liulangdongwu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(liulangdongwuJinkuang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody LiulangdongwuJinkuangEntity liulangdongwuJinkuang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,liulangdongwuJinkuang:{}",this.getClass().getName(),liulangdongwuJinkuang.toString());
        Wrapper<LiulangdongwuJinkuangEntity> queryWrapper = new EntityWrapper<LiulangdongwuJinkuangEntity>()
            .eq("liulangdongwu_id", liulangdongwuJinkuang.getLiulangdongwuId())
            .eq("yonghu_id", liulangdongwuJinkuang.getYonghuId())
            .eq("liulangdongwu_jinkuang_uuid_number", liulangdongwuJinkuang.getLiulangdongwuJinkuangUuidNumber())
            .eq("liulangdongwu_jinkuang_name", liulangdongwuJinkuang.getLiulangdongwuJinkuangName())
            .eq("liulangdongwu_jinkuang_address", liulangdongwuJinkuang.getLiulangdongwuJinkuangAddress())
            .eq("liulangdongwu_jinkuang_types", liulangdongwuJinkuang.getLiulangdongwuJinkuangTypes())
//            .notIn("liulangdongwu_jinkuang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiulangdongwuJinkuangEntity liulangdongwuJinkuangEntity = liulangdongwuJinkuangService.selectOne(queryWrapper);
        if(liulangdongwuJinkuangEntity==null){
            liulangdongwuJinkuang.setInsertTime(new Date());
            liulangdongwuJinkuang.setCreateTime(new Date());
        liulangdongwuJinkuangService.insert(liulangdongwuJinkuang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

