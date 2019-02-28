package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.CustomerEntity;

import java.util.Map;

/**
 * 客户管理
 *
 * @author gaodp
 * @email 18516325815@163.com
 * @date 2019-02-27 15:24:34
 */
public interface CustomerService extends IService<CustomerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

