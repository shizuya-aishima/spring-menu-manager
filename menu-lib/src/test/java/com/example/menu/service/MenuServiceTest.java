package com.example.menu.service;

import com.example.menu.entity.MenuItem;
import com.example.menu.repository.MenuItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    void getAllMenuItems_正常系() {
        List<MenuItem> items = menuService.getAllMenuItems();
        assertNotNull(items);
        assertTrue(items.size() >= 3); // サンプルデータで3件投入されているため
        assertTrue(items.stream().allMatch(MenuItem::isEnabled));
    }

    @Test
    void getRootMenuItems_正常系() {
        List<MenuItem> rootItems = menuService.getRootMenuItems();
        assertNotNull(rootItems);
        assertEquals(2, rootItems.size()); // ホームと設定の2件
        assertTrue(rootItems.stream().allMatch(item -> item.getParentId() == null));
    }

    @Test
    void getSubMenuItems_正常系() {
        // 設定メニューのIDを取得
        Long settingsId = menuService.getRootMenuItems().stream()
                .filter(item -> "設定".equals(item.getName()))
                .findFirst()
                .map(MenuItem::getId)
                .orElseThrow();

        List<MenuItem> subItems = menuService.getSubMenuItems(settingsId);
        assertNotNull(subItems);
        assertEquals(1, subItems.size()); // プロフィール設定の1件
        assertEquals("プロフィール設定", subItems.get(0).getName());
    }
} 