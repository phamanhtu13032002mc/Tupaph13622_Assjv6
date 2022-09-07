package com.example.tupaph13622_assjv6.respository;

import java.util.Date;
import java.util.List;

import com.example.tupaph13622_assjv6.entity.OrderDetail;
import com.example.tupaph13622_assjv6.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    //số lượng sp bán ngày
    @Query("SELECT count(o.id) FROM OrderDetail  o where o.order.createdate =?1")
    int lists(Date date);

    //doanh thu 1 này
    @Query("SELECT sum(o.price * o.quantity) FROM OrderDetail  o where o.order.createdate =?1")
    float sums(Date date);

    @Query("SELECT new Reports( DAY(o.order.createdate), sum(o.price * o.quantity) ) "
            + "FROM OrderDetail  o where o.order.createdate BETWEEN GETDATE()-7 AND GETDATE()"
            + "GROUP BY o.order.createdate")
    List<Reports> tksum();


}
