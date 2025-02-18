package com.github.shizuyaaishima.menu.service;

import com.github.shizuyaaishima.menu.TestConfig;
import com.github.shizuyaaishima.menu.entity.MenuItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
    classes = TestConfig.class,
    properties = {
        "spring.flyway.enabled=true",
        "spring.jpa.hibernate.ddl-auto=validate"
    }
)
@Transactional
class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    void getAllMenuItems_正常系() {
        List<MenuItem> items = menuService.getAllMenuItems();
        assertNotNull(items, "メニュー項目のリストがnullです");
        assertTrue(items.size() >= 3, "メニュー項目が3件以上存在する必要があります");
        assertTrue(items.stream().allMatch(MenuItem::isEnabled), "全てのメニュー項目が有効である必要があります");
    }

    @Test
    void getRootMenuItems_正常系() {
        List<MenuItem> rootItems = menuService.getRootMenuItems();
        assertNotNull(rootItems, "ルートメニュー項目のリストがnullです");
        assertEquals(2, rootItems.size(), "ルートメニュー項目は2件存在する必要があります");
        assertTrue(rootItems.stream().allMatch(item -> item.getParentId() == null), 
            "全てのルートメニュー項目の親IDがnullである必要があります");
    }

    @Test
    void getSubMenuItems_正常系() {
        // 設定メニューのIDを取得
        Long settingsId = menuService.getRootMenuItems().stream()
                .filter(item -> "設定".equals(item.getName()))
                .findFirst()
                .map(MenuItem::getId)
                .orElseThrow(() -> new AssertionError("設定メニューが見つかりません"));

        List<MenuItem> subItems = menuService.getSubMenuItems(settingsId);
        assertNotNull(subItems, "サブメニュー項目のリストがnullです");
        assertEquals(1, subItems.size(), "サブメニュー項目は1件存在する必要があります");
        assertEquals("プロフィール設定", subItems.get(0).getName(), 
            "サブメニュー項目の名前が「プロフィール設定」である必要があります");
    }
}
