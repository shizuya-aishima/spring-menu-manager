package com.example.menu.repository;

import com.example.menu.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByParentIdOrderByDisplayOrderAsc(Long parentId);
    List<MenuItem> findByParentIdIsNullOrderByDisplayOrderAsc();
    List<MenuItem> findAllByEnabledTrueOrderByDisplayOrderAsc();
} 