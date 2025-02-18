package com.github.shizuyaaishima.menu.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * メニュー管理ライブラリのサンプルアプリケーション。 Spring Bootを使用してメニュー管理APIを提供します。
 *
 * <p>このアプリケーションは以下の機能を提供します：
 *
 * <ul>
 *   <li>メニュー項目の取得API
 *   <li>H2データベースによるデータ永続化
 *   <li>Flywayによるデータベースマイグレーション
 * </ul>
 *
 * @see SpringBootApplication Spring Bootアプリケーションの設定
 * @see ComponentScan コンポーネントスキャンの設定
 * @see EntityScan エンティティスキャンの設定
 * @see EnableJpaRepositories JPAリポジトリの設定
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.github.shizuyaaishima.menu")
@EntityScan(basePackages = "com.github.shizuyaaishima.menu.entity")
@EnableJpaRepositories(basePackages = "com.github.shizuyaaishima.menu.repository")
public class MenuSampleApplication {

  /** デフォルトコンストラクタ。 */
  public MenuSampleApplication() {}

  /**
   * アプリケーションのエントリーポイント。 Spring Bootアプリケーションを起動します。
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    SpringApplication.run(MenuSampleApplication.class, args);
  }
}
