package com.github.shizuyaaishima.menu.repository;

import com.github.shizuyaaishima.menu.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * メニュー項目のデータアクセスを提供するリポジトリインターフェース。
 * Spring Data JPAを使用してデータベース操作を行います。
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    
    /**
     * 指定された親メニューIDに属するメニュー項目を表示順で取得します。
     *
     * @param parentId 親メニューのID
     * @return 表示順でソートされたメニュー項目のリスト
     */
    List<MenuItem> findByParentIdOrderByDisplayOrderAsc(Long parentId);

    /**
     * トップレベルのメニュー項目（親メニューを持たない項目）を表示順で取得します。
     *
     * @return 表示順でソートされたトップレベルメニュー項目のリスト
     */
    List<MenuItem> findByParentIdIsNullOrderByDisplayOrderAsc();

    /**
     * 有効なメニュー項目を全て表示順で取得します。
     *
     * @return 表示順でソートされた有効なメニュー項目のリスト
     */
    List<MenuItem> findAllByEnabledTrueOrderByDisplayOrderAsc();
} 