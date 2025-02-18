package com.github.shizuyaaishima.menu.controller;

import com.github.shizuyaaishima.menu.entity.MenuItem;
import com.github.shizuyaaishima.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    @GetMapping("/root")
    public List<MenuItem> getRootMenuItems() {
        return menuService.getRootMenuItems();
    }

    @GetMapping("/sub/{parentId}")
    public List<MenuItem> getSubMenuItems(@PathVariable Long parentId) {
        return menuService.getSubMenuItems(parentId);
    }
} 