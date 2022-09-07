package com.example.tupaph13622_assjv6.respository;

import com.example.tupaph13622_assjv6.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccountRepository extends JpaRepository<Account, String> {
    // Sắp xếp phân trang
    @Query("SELECT o FROM Account o ORDER BY o.username ASC")
    Page<Account> findByKeywords(Pageable pageable);

    // Tìm kiếm theo tên phân trang
    @Query("SELECT o FROM Account o WHERE o.username LIKE ?1")
    Page<Account> findByKeywords(String keywords, Pageable pageable);
}
