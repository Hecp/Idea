package com.hcp.sharding.jdbc.repository;

import com.hcp.sharding.jdbc.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hcp on 2018/5/19.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
