package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.CustomerDao;
import io.renren.modules.sys.entity.CustomerEntity;
import io.renren.modules.sys.service.CustomerService;


@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CustomerEntity> page = this.selectPage(
                new Query<CustomerEntity>(params).getPage(),
                new EntityWrapper<CustomerEntity>()
        );

        return new PageUtils(page);
    }

}
