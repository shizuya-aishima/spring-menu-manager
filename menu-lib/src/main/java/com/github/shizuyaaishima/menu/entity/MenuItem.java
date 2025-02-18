package com.github.shizuyaaishima.menu.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * メニュー項目を表すエンティティクラス。
 * Webアプリケーションのナビゲーションメニューの各項目を管理します。
 */
@Entity
@Table(name = "menu_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {
    
    /** メニュー項目のID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** メニュー項目の名前 */
    @Column(nullable = false)
    private String name;
    
    /** メニュー項目のURL */
    @Column
    private String url;
    
    /** 表示順序（小さい順に表示） */
    @Column(name = "display_order")
    private Integer displayOrder;
    
    /** 親メニューのID（トップレベルのメニューの場合はnull） */
    @Column(name = "parent_id")
    private Long parentId;
    
    /** メニュー項目のアイコン（オプション） */
    @Column
    private String icon;
    
    /** メニュー項目の有効/無効状態 */
    @Column
    @Builder.Default
    private boolean enabled = true;
    
    /** レコード作成日時 */
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;
    
    /** レコード更新日時 */
    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;
    
    /**
     * レコード作成時の処理。
     * 作成日時と更新日時を現在時刻に設定します。
     */
    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
        updatedAt = createdAt;
    }
    
    /**
     * レコード更新時の処理。
     * 更新日時を現在時刻に設定します。
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }
} 