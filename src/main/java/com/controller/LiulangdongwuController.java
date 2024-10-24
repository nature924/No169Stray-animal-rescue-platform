
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
 * 流浪动物
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liulangdongwu")
public class LiulangdongwuController {
    private static final Logger logger = LoggerFactory.getLogger(LiulangdongwuController.class);

    private static final String TABLE_NAME = "liulangdongwu";

    @Autowired
    private LiulangdongwuService liulangdongwuService;


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
    private LiulangdongwuCollectionService liulangdongwuCollectionService;//流浪动物收藏
    @Autowired
    private LiulangdongwuHuafeiService liulangdongwuHuafeiService;//流浪动物花费
    @Autowired
    private LiulangdongwuJinkuangService liulangdongwuJinkuangService;//流浪动物近况
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
        params.put("liulangdongwuDeleteStart",1);params.put("liulangdongwuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = liulangdongwuService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuView> list =(List<LiulangdongwuView>)page.getList();
        for(LiulangdongwuView c:list){
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
        LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(id);
        if(liulangdongwu !=null){
            //entity转view
            LiulangdongwuView view = new LiulangdongwuView();
            BeanUtils.copyProperties( liulangdongwu , view );//把实体数据重构到view中
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
    public R save(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liulangdongwu:{}",this.getClass().getName(),liulangdongwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LiulangdongwuEntity> queryWrapper = new EntityWrapper<LiulangdongwuEntity>()
            .eq("liulangdongwu_name", liulangdongwu.getLiulangdongwuName())
            .eq("liulangdongwu_types", liulangdongwu.getLiulangdongwuTypes())
            .eq("liulangdongwu_erji_types", liulangdongwu.getLiulangdongwuErjiTypes())
            .eq("liulangdongwu_age", liulangdongwu.getLiulangdongwuAge())
            .eq("liulangdongwu_jiezhong", liulangdongwu.getLiulangdongwuJiezhong())
            .eq("xingbie_types", liulangdongwu.getXingbieTypes())
            .eq("dongwu_zhuangtai_types", liulangdongwu.getDongwuZhuangtaiTypes())
            .eq("liulangdongwu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectOne(queryWrapper);
        if(liulangdongwuEntity==null){
            liulangdongwu.setLiulangdongwuDelete(1);
            liulangdongwu.setCreateTime(new Date());
            liulangdongwuService.insert(liulangdongwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,liulangdongwu:{}",this.getClass().getName(),liulangdongwu.toString());
        LiulangdongwuEntity oldLiulangdongwuEntity = liulangdongwuService.selectById(liulangdongwu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(liulangdongwu.getLiulangdongwuPhoto()) || "null".equals(liulangdongwu.getLiulangdongwuPhoto())){
                liulangdongwu.setLiulangdongwuPhoto(null);
        }

            liulangdongwuService.updateById(liulangdongwu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LiulangdongwuEntity> oldLiulangdongwuList =liulangdongwuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<LiulangdongwuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LiulangdongwuEntity liulangdongwuEntity = new LiulangdongwuEntity();
            liulangdongwuEntity.setId(id);
            liulangdongwuEntity.setLiulangdongwuDelete(2);
            list.add(liulangdongwuEntity);
        }
        if(list != null && list.size() >0){
            liulangdongwuService.updateBatchById(list);
        }

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
            List<LiulangdongwuEntity> liulangdongwuList = new ArrayList<>();//上传的东西
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
                            LiulangdongwuEntity liulangdongwuEntity = new LiulangdongwuEntity();
//                            liulangdongwuEntity.setLiulangdongwuName(data.get(0));                    //流浪动物名称 要改的
//                            liulangdongwuEntity.setLiulangdongwuPhoto("");//详情和图片
//                            liulangdongwuEntity.setLiulangdongwuTypes(Integer.valueOf(data.get(0)));   //动物类型 要改的
//                            liulangdongwuEntity.setLiulangdongwuErjiTypes(Integer.valueOf(data.get(0)));   //详细类型 要改的
//                            liulangdongwuEntity.setLiulangdongwuAge(Integer.valueOf(data.get(0)));   //流浪动物年龄 要改的
//                            liulangdongwuEntity.setLiulangdongwuJiezhong(data.get(0));                    //疫苗接种 要改的
//                            liulangdongwuEntity.setXingbieTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            liulangdongwuEntity.setLiulangdongwuZuyangjin(data.get(0));                    //助养金 要改的
//                            liulangdongwuEntity.setLiulangdongwuContent("");//详情和图片
//                            liulangdongwuEntity.setDongwuZhuangtaiTypes(Integer.valueOf(data.get(0)));   //动物状态 要改的
//                            liulangdongwuEntity.setLiulangdongwuDelete(1);//逻辑删除字段
//                            liulangdongwuEntity.setCreateTime(date);//时间
                            liulangdongwuList.add(liulangdongwuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        liulangdongwuService.insertBatch(liulangdongwuList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<LiulangdongwuView> returnLiulangdongwuViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = liulangdongwuOrderService.queryPage(params1);
        List<LiulangdongwuOrderView> orderViewsList =(List<LiulangdongwuOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(LiulangdongwuOrderView orderView:orderViewsList){
            Integer liulangdongwuTypes = orderView.getLiulangdongwuTypes();
            if(typeMap.containsKey(liulangdongwuTypes)){
                typeMap.put(liulangdongwuTypes,typeMap.get(liulangdongwuTypes)+1);
            }else{
                typeMap.put(liulangdongwuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("liulangdongwuTypes",type);
            PageUtils pageUtils1 = liulangdongwuService.queryPage(params2);
            List<LiulangdongwuView> liulangdongwuViewList =(List<LiulangdongwuView>)pageUtils1.getList();
            returnLiulangdongwuViewList.addAll(liulangdongwuViewList);
            if(returnLiulangdongwuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = liulangdongwuService.queryPage(params);
        if(returnLiulangdongwuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnLiulangdongwuViewList.size();//要添加的数量
            List<LiulangdongwuView> liulangdongwuViewList =(List<LiulangdongwuView>)page.getList();
            for(LiulangdongwuView liulangdongwuView:liulangdongwuViewList){
                Boolean addFlag = true;
                for(LiulangdongwuView returnLiulangdongwuView:returnLiulangdongwuViewList){
                    if(returnLiulangdongwuView.getId().intValue() ==liulangdongwuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnLiulangdongwuViewList.add(liulangdongwuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnLiulangdongwuViewList = returnLiulangdongwuViewList.subList(0, limit);
        }

        for(LiulangdongwuView c:returnLiulangdongwuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnLiulangdongwuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = liulangdongwuService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuView> list =(List<LiulangdongwuView>)page.getList();
        for(LiulangdongwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(id);
            if(liulangdongwu !=null){


                //entity转view
                LiulangdongwuView view = new LiulangdongwuView();
                BeanUtils.copyProperties( liulangdongwu , view );//把实体数据重构到view中

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
    public R add(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,liulangdongwu:{}",this.getClass().getName(),liulangdongwu.toString());
        Wrapper<LiulangdongwuEntity> queryWrapper = new EntityWrapper<LiulangdongwuEntity>()
            .eq("liulangdongwu_name", liulangdongwu.getLiulangdongwuName())
            .eq("liulangdongwu_types", liulangdongwu.getLiulangdongwuTypes())
            .eq("liulangdongwu_erji_types", liulangdongwu.getLiulangdongwuErjiTypes())
            .eq("liulangdongwu_age", liulangdongwu.getLiulangdongwuAge())
            .eq("liulangdongwu_jiezhong", liulangdongwu.getLiulangdongwuJiezhong())
            .eq("xingbie_types", liulangdongwu.getXingbieTypes())
            .eq("dongwu_zhuangtai_types", liulangdongwu.getDongwuZhuangtaiTypes())
            .eq("liulangdongwu_delete", liulangdongwu.getLiulangdongwuDelete())
//            .notIn("liulangdongwu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectOne(queryWrapper);
        if(liulangdongwuEntity==null){
            liulangdongwu.setLiulangdongwuDelete(1);
            liulangdongwu.setCreateTime(new Date());
        liulangdongwuService.insert(liulangdongwu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

