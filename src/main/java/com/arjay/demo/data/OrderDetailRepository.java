package com.arjay.demo.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.arjay.demo.model.OrderDetail;

@RepositoryRestResource(collectionResourceRel = "orderDetail", path = "orderDetail")
public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Long>, CrudRepository<OrderDetail,Long> {
    
  List<OrderDetail> findByOrder_Id(@Param("order") Long order);
}
