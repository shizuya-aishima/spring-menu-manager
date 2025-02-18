package com.github.shizuyaaishima.menu.controller;

import com.github.shizuyaaishima.menu.entity.MenuItem;
import com.github.shizuyaaishima.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * メニュー項目のREST APIを提供するコントローラークラス。
 * メニュー項目の取得に関するエンドポイントを提供します。
 */
@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {

    /** メニューサービス */
    private final MenuService menuService;

    /**
     * 有効な全てのメニュー項目を取得します。
     *
     * @return メニュー項目のリスト
     * @see MenuService#getAllMenuItems()
     */
    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    /**
     * トップレベルのメニュー項目を取得します。
     *
     * @return トップレベルのメニュー項目のリスト
     * @see MenuService#getRootMenuItems()
     */
    @GetMapping("/root")
    public List<MenuItem> getRootMenuItems() {
        return menuService.getRootMenuItems();
    }

    /**
     * 指定された親メニューに属するサブメニュー項目を取得します。
     *
     * @param parentId 親メニューのID
     * @return サブメニュー項目のリスト
     * @see MenuService#getSubMenuItems(Long)
     */
    @GetMapping("/sub/{parentId}")
    public List<MenuItem> getSubMenuItems(@PathVariable Long parentId) {
        return menuService.getSubMenuItems(parentId);
    }
} 