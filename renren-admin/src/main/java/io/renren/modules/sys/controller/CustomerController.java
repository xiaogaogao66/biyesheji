package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.CustomerEntity;
import io.renren.modules.sys.service.CustomerService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 客户管理
 *
 * @author gaodp
 * @email 18516325815@163.com
 * @date 2019-02-27 15:24:34
 */
@RestController
@RequestMapping("sys/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:customer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{customerId}")
    @RequiresPermissions("sys:customer:info")
    public R info(@PathVariable("customerId") Long customerId){
        CustomerEntity customer = customerService.selectById(customerId);

        return R.ok().put("customer", customer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:customer:save")
    public R save(@RequestBody CustomerEntity customer){
        customerService.insert(customer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:customer:update")
    public R update(@RequestBody CustomerEntity customer){
        ValidatorUtils.validateEntity(customer);
        customerService.updateAllColumnById(customer);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:customer:delete")
    public R delete(@RequestBody Long[] customerIds){
        customerService.deleteBatchIds(Arrays.asList(customerIds));

        return R.ok();
    }

}
