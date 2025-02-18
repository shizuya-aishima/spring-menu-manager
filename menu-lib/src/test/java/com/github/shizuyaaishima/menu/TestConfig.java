package com.github.shizuyaaishima.menu;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * テスト用の設定クラス。
 * Spring Bootのテスト環境を設定します。
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.github.shizuyaaishima.menu")
public class TestConfig {
    // このクラスはテスト環境の設定のみを目的としているため、
    // テストケースは含みません。
}
