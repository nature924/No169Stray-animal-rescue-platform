
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
 * 流浪动物领养
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liulangdongwuOrder")
public class LiulangdongwuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(LiulangdongwuOrderController.class);

    private static final String TABLE_NAME = "liulangdongwuOrder";

    @Autowired
    private LiulangdongwuOrderService liulangdongwuOrderService;


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
    private LiulangdongwuJinkuangService liulangdongwuJinkuangService;//流浪动物近况
    @Autowired
    private LiulangdongwuLiuyanService liulangdongwuLiuyanService;//流浪动物留言
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
        PageUtils page = liulangdongwuOrderService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuOrderView> list =(List<LiulangdongwuOrderView>)page.getList();
        for(LiulangdongwuOrderView c:list){
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
        LiulangdongwuOrderEntity liulangdongwuOrder = liulangdongwuOrderService.selectById(id);
        if(liulangdongwuOrder !=null){
            //entity转view
            LiulangdongwuOrderView view = new LiulangdongwuOrderView();
            BeanUtils.copyProperties( liulangdongwuOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(liulangdongwuOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 流浪动物
            //级联表
            LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(liulangdongwuOrder.getLiulangdongwuId());
            if(liulangdongwu != null){
            BeanUtils.copyProperties( liulangdongwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLiulangdongwuId(liulangdongwu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(liulangdongwuOrder.getYonghuId());
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
    public R save(@RequestBody LiulangdongwuOrderEntity liulangdongwuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liulangdongwuOrder:{}",this.getClass().getName(),liulangdongwuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            liulangdongwuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        liulangdongwuOrder.setCreateTime(new Date());
        liulangdongwuOrder.setInsertTime(new Date());
        liulangdongwuOrderService.insert(liulangdongwuOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiulangdongwuOrderEntity liulangdongwuOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,liulangdongwuOrder:{}",this.getClass().getName(),liulangdongwuOrder.toString());
        LiulangdongwuOrderEntity oldLiulangdongwuOrderEntity = liulangdongwuOrderService.selectById(liulangdongwuOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            liulangdongwuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            liulangdongwuOrderService.updateById(liulangdongwuOrder);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody LiulangdongwuOrderEntity liulangdongwuOrderEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,liulangdongwuOrderEntity:{}",this.getClass().getName(),liulangdongwuOrderEntity.toString());

        LiulangdongwuOrderEntity oldLiulangdongwuOrder = liulangdongwuOrderService.selectById(liulangdongwuOrderEntity.getId());//查询原先数据

        if(liulangdongwuOrderEntity.getLiulangdongwuOrderYesnoTypes() == 2){//通过
            liulangdongwuOrderEntity.setLiulangdongwuOrderTypes(103);
            LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectById(oldLiulangdongwuOrder.getLiulangdongwuId());
            if(liulangdongwuEntity == null)
                return R.error("查不到流浪动物");
            liulangdongwuEntity.setDongwuZhuangtaiTypes(2);
            liulangdongwuService.updateById(liulangdongwuEntity);

        }else if(liulangdongwuOrderEntity.getLiulangdongwuOrderYesnoTypes() == 3){//拒绝
            liulangdongwuOrderEntity.setLiulangdongwuOrderTypes(109);
        }
        liulangdongwuOrderEntity.setLiulangdongwuOrderShenheTime(new Date());//审核时间
        liulangdongwuOrderService.updateById(liulangdongwuOrderEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LiulangdongwuOrderEntity> oldLiulangdongwuOrderList =liulangdongwuOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        liulangdongwuOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<LiulangdongwuOrderEntity> liulangdongwuOrderList = new ArrayList<>();//上传的东西
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
                            LiulangdongwuOrderEntity liulangdongwuOrderEntity = new LiulangdongwuOrderEntity();
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderUuidNumber(data.get(0));                    //申请领养编号 要改的
//                            liulangdongwuOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuId(Integer.valueOf(data.get(0)));   //流浪动物 要改的
//                            liulangdongwuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderCourierName(data.get(0));                    //快递公司 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderCourierNumber(data.get(0));                    //快递单号 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderTypes(Integer.valueOf(data.get(0)));   //领养状态 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderYesnoText(data.get(0));                    //审核意见 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            liulangdongwuOrderEntity.setInsertTime(date);//时间
//                            liulangdongwuOrderEntity.setCreateTime(date);//时间
                            liulangdongwuOrderList.add(liulangdongwuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //申请领养编号
                                if(seachFields.containsKey("liulangdongwuOrderUuidNumber")){
                                    List<String> liulangdongwuOrderUuidNumber = seachFields.get("liulangdongwuOrderUuidNumber");
                                    liulangdongwuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> liulangdongwuOrderUuidNumber = new ArrayList<>();
                                    liulangdongwuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("liulangdongwuOrderUuidNumber",liulangdongwuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //申请领养编号
                        List<LiulangdongwuOrderEntity> liulangdongwuOrderEntities_liulangdongwuOrderUuidNumber = liulangdongwuOrderService.selectList(new EntityWrapper<LiulangdongwuOrderEntity>().in("liulangdongwu_order_uuid_number", seachFields.get("liulangdongwuOrderUuidNumber")));
                        if(liulangdongwuOrderEntities_liulangdongwuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LiulangdongwuOrderEntity s:liulangdongwuOrderEntities_liulangdongwuOrderUuidNumber){
                                repeatFields.add(s.getLiulangdongwuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [申请领养编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        liulangdongwuOrderService.insertBatch(liulangdongwuOrderList);
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
        PageUtils page = liulangdongwuOrderService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuOrderView> list =(List<LiulangdongwuOrderView>)page.getList();
        for(LiulangdongwuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LiulangdongwuOrderEntity liulangdongwuOrder = liulangdongwuOrderService.selectById(id);
            if(liulangdongwuOrder !=null){


                //entity转view
                LiulangdongwuOrderView view = new LiulangdongwuOrderView();
                BeanUtils.copyProperties( liulangdongwuOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(liulangdongwuOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(liulangdongwuOrder.getLiulangdongwuId());
                if(liulangdongwu != null){
                    BeanUtils.copyProperties( liulangdongwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLiulangdongwuId(liulangdongwu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(liulangdongwuOrder.getYonghuId());
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
    public R add(@RequestBody LiulangdongwuOrderEntity liulangdongwuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,liulangdongwuOrder:{}",this.getClass().getName(),liulangdongwuOrder.toString());
            LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectById(liulangdongwuOrder.getLiulangdongwuId());
            if(liulangdongwuEntity == null){
                return R.error(511,"查不到该流浪动物");
            }
            // Double liulangdongwuNewMoney = liulangdongwuEntity.getLiulangdongwuNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
        liulangdongwuOrder.setLiulangdongwuOrderYesnoTypes(1);
            liulangdongwuOrder.setLiulangdongwuOrderTypes(101); //设置订单状态为已申请领养
            liulangdongwuOrder.setYonghuId(userId); //设置订单支付人id
            liulangdongwuOrder.setLiulangdongwuOrderUuidNumber(String.valueOf(new Date().getTime()));
            liulangdongwuOrder.setInsertTime(new Date());
            liulangdongwuOrder.setCreateTime(new Date());
                liulangdongwuOrderService.insert(liulangdongwuOrder);//新增订单
            return R.ok();
    }


    /**
    * 取消申请
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            LiulangdongwuOrderEntity liulangdongwuOrder = liulangdongwuOrderService.selectById(id);//当前表service
            Integer liulangdongwuId = liulangdongwuOrder.getLiulangdongwuId();
            if(liulangdongwuId == null)
                return R.error(511,"查不到该流浪动物");
            LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectById(liulangdongwuId);
            if(liulangdongwuEntity == null)
                return R.error(511,"查不到该流浪动物");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;





            liulangdongwuOrder.setLiulangdongwuOrderYesnoTypes(null);
            liulangdongwuOrder.setLiulangdongwuOrderTypes(102);//设置订单状态为已取消申请
            liulangdongwuOrderService.updateAllColumnById(liulangdongwuOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            liulangdongwuService.updateById(liulangdongwuEntity);//更新订单中流浪动物的信息

            return R.ok();
    }

    /**
     * 同意领养
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String liulangdongwuOrderCourierNumber, String liulangdongwuOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        LiulangdongwuOrderEntity  liulangdongwuOrderEntity = liulangdongwuOrderService.selectById(id);
        liulangdongwuOrderEntity.setLiulangdongwuOrderTypes(103);//设置订单状态为已同意领养
        liulangdongwuOrderEntity.setLiulangdongwuOrderCourierNumber(liulangdongwuOrderCourierNumber);
        liulangdongwuOrderEntity.setLiulangdongwuOrderCourierName(liulangdongwuOrderCourierName);
        liulangdongwuOrderService.updateById( liulangdongwuOrderEntity);

        return R.ok();
    }


    /**
     * 收到宠物
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        LiulangdongwuOrderEntity  liulangdongwuOrderEntity = liulangdongwuOrderService.selectById(id);
        liulangdongwuOrderEntity.setLiulangdongwuOrderTypes(104);//设置订单状态为收到宠物
        liulangdongwuOrderService.updateById( liulangdongwuOrderEntity);
        return R.ok();
    }

}

