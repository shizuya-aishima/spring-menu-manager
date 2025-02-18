package com.example.menu.service;

import com.example.menu.entity.MenuItem;
import com.example.menu.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {

    private final MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAllByEnabledTrueOrderByDisplayOrderAsc();
    }

    public List<MenuItem> getRootMenuItems() {
        return menuItemRepository.findByParentIdIsNullOrderByDisplayOrderAsc();
    }

    public List<MenuItem> getSubMenuItems(Long parentId) {
        return menuItemRepository.findByParentIdOrderByDisplayOrderAsc(parentId);
    }
} 