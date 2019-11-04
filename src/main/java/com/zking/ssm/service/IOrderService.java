package com.zking.ssm.service;

import com.zking.ssm.model.Order;

public interface IOrderService {
    Order querySingleOrderByManyToOne(Integer oid);
}