package com.inventory.productInventory.repository;

import com.inventory.productInventory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    @Query(value = "SELECT DISTINCT (c.*) " +
            "FROM CATEGORY c " +
            "INNER JOIN product p ON c.ID = p.ID_CATEGORY " +
            "WHERE (:id IS NULL OR c.ID = :id) " +
            "AND (:type IS NULL OR c.TYPE = :type) " +
            "AND (:name IS NULL OR c.NAME = :name) " +
            "AND (:productName IS NULL OR p.NAME = :productName); ", nativeQuery = true)
    List<Category> search(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("productName") String productName);
}
