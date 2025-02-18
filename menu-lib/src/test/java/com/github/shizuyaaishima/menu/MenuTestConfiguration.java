package com.github.shizuyaaishima.menu;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** Spring Bootのテスト環境用の設定クラス。 このクラスはテストケースを含まず、テスト実行時の設定のみを提供します。 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.github.shizuyaaishima.menu")
public class MenuTestConfiguration {
  // このクラスはテスト環境の設定のみを目的としているため、
  // テストケースは含みません。
}
