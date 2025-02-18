package com.github.shizuyaaishima.menu.service;

import com.github.shizuyaaishima.menu.entity.MenuItem;
import com.github.shizuyaaishima.menu.repository.MenuItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * メニュー項目の業務ロジックを提供するサービスクラス。 メニュー項目の取得や管理に関する機能を提供します。
 *
 * @see RequiredArgsConstructor 必須フィールドを引数に取るコンストラクタを自動生成
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {

  /** メニュー項目リポジトリ */
  private final MenuItemRepository menuItemRepository;

  /**
   * 有効な全てのメニュー項目を取得します。 メニュー項目は表示順でソートされます。
   *
   * @return 有効なメニュー項目のリスト
   */
  public List<MenuItem> getAllMenuItems() {
    return menuItemRepository.findAllByEnabledTrueOrderByDisplayOrderAsc();
  }

  /**
   * トップレベルのメニュー項目を取得します。 親メニューを持たないメニュー項目が対象です。
   *
   * @return トップレベルのメニュー項目のリスト
   */
  public List<MenuItem> getRootMenuItems() {
    return menuItemRepository.findByParentIdIsNullOrderByDisplayOrderAsc();
  }

  /**
   * 指定された親メニューに属するサブメニュー項目を取得します。
   *
   * @param parentId 親メニューのID
   * @return サブメニュー項目のリスト
   */
  public List<MenuItem> getSubMenuItems(Long parentId) {
    return menuItemRepository.findByParentIdOrderByDisplayOrderAsc(parentId);
  }
}
