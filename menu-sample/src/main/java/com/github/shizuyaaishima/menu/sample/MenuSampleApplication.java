package com.github.shizuyaaishima.menu.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * メニュー管理ライブラリのサンプルアプリケーション。
 * Spring Bootを使用してメニュー管理APIを提供します。
 * 
 * <p>このアプリケーションは以下の機能を提供します：</p>
 * <ul>
 *   <li>メニュー項目の取得API</li>
 *   <li>H2データベースによるデータ永続化</li>
 *   <li>Flywayによるデータベースマイグレーション</li>
 * </ul>
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.github.shizuyaaishima.menu")
@EntityScan(basePackages = "com.github.shizuyaaishima.menu.entity")
@EnableJpaRepositories(basePackages = "com.github.shizuyaaishima.menu.repository")
public class MenuSampleApplication {

    /**
     * アプリケーションのエントリーポイント。
     * Spring Bootアプリケーションを起動します。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        SpringApplication.run(MenuSampleApplication.class, args);
    }
} 