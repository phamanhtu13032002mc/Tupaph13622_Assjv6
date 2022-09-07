package com.example.tupaph13622_assjv6.respository;

import com.example.tupaph13622_assjv6.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Sắp xếp phân trang
    @Query("SELECT o FROM Product o ORDER BY o.price ASC")
    Page<Product> findByKeywords(Pageable pageable);

    //
    // Tìm kiếm theo tên phân trang
    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    // Tìm kiếm theo loại phân trang
    @Query("SELECT o FROM Product o WHERE o.Categorys.id=?1")
    Page<Product> findIdByKeywords(String keywords, Pageable pageable);

//	@Query("SELECT p FROM Product p WHERE p.Categorys.id=?1 ")
//	List<Product> findByCategoryId(String cid);
}
