# Spring Menu Manager

Spring Boot用のメニュー管理ライブラリです。Webアプリケーションのナビゲーションメニューを簡単に管理できます。

## 機能

- メニュー項目の階層管理
- RESTful APIによるメニュー操作
- H2データベースによるデータ永続化
- Flywayによるデータベースマイグレーション
- Spring Boot 3.2.2との完全な互換性

## プロジェクト構成

- `menu-lib`: メインのライブラリモジュール
- `menu-sample`: サンプルアプリケーション

## 必要条件

- Java 17以上
- Gradle 8.5以上
- Spring Boot 3.2.2

## インストール

### Gradle

```groovy
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/shizuya-aishima/spring-menu-manager")
    }
}

dependencies {
    implementation 'com.github.shizuya-aishima:spring-menu-manager:0.0.1-SNAPSHOT'
}
```

## 使用方法

1. Spring Bootアプリケーションに依存関係を追加
2. エンティティスキャンとコンポーネントスキャンを設定

```java
@SpringBootApplication
@ComponentScan(basePackages = "com.github.shizuyaaishima.menu")
@EntityScan(basePackages = "com.github.shizuyaaishima.menu.entity")
@EnableJpaRepositories(basePackages = "com.github.shizuyaaishima.menu.repository")
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}
```

## API エンドポイント

- `GET /api/menu`: 全メニュー項目の取得
- `GET /api/menu/root`: ルートメニュー項目の取得
- `GET /api/menu/sub/{parentId}`: 特定の親メニューのサブメニュー項目の取得

## データベースマイグレーション

Flywayを使用してデータベースのマイグレーションを管理しています。

### テーブル構造

#### menu_items テーブル

メニュー項目を管理するためのメインテーブルです。階層構造のナビゲーションメニューを表現します。

| カラム名 | 型 | 説明 |
|----------|------|------|
| id | BIGINT | 主キー |
| name | VARCHAR(255) | メニュー項目名 |
| url | VARCHAR(255) | リンク先URL |
| display_order | INT | 表示順序 |
| parent_id | BIGINT | 親メニューのID（外部キー） |
| icon | VARCHAR(255) | アイコン名 |
| enabled | BOOLEAN | 有効/無効フラグ |
| created_at | TIMESTAMP | 作成日時 |
| updated_at | TIMESTAMP | 更新日時 |

### 初期データ

以下のメニュー構造が初期データとして登録されます：

```
- ホーム (/)
  - URL: /
  - アイコン: home
  - 表示順序: 1

- 設定 (/settings)
  - URL: /settings
  - アイコン: settings
  - 表示順序: 2
  
  - プロフィール設定 (/settings/profile)
    - URL: /settings/profile
    - アイコン: person
    - 表示順序: 1
    - 親メニュー: 設定
```

### マイグレーションファイルの配置

マイグレーションスクリプトは以下のディレクトリに配置します：

```
src/main/resources/db/migration/
```

### マイグレーションファイルの命名規則

```
V{バージョン}__{説明}.sql
```

例：
- `V1__create_menu_tables.sql`
- `V2__add_display_order.sql`

### マイグレーションコマンド

```bash
# マイグレーションの実行
./gradlew flywayMigrate

# マイグレーション情報の確認
./gradlew flywayInfo

# データベースのクリーンアップ（開発環境のみ）
./gradlew flywayClean
```

### 設定例

```yaml
spring:
  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true
```

## 開発

### ビルド

```bash
./gradlew build
```

### テスト

```bash
./gradlew test
```

### コード品質

- Spotlessによるコードスタイルチェック
- PMDによる静的解析
- JaCoCoによるコードカバレッジ

```bash
./gradlew spotlessCheck
./gradlew pmdMain pmdTest
./gradlew jacocoTestReport
```

## サンプルアプリケーション

サンプルアプリケーションの実行:

```bash
./gradlew :menu-sample:bootRun
```

詳細は[サンプルアプリケーションのREADME](menu-sample/README.md)を参照してください。

## ライセンス

MIT License

## 作者

Shizuya Aishima (shizuya.aishima@example.com)

## 貢献

1. Forkを作成
2. 機能ブランチを作成 (`git checkout -b feature/amazing-feature`)
3. 変更をコミット (`git commit -m 'Add some amazing feature'`)
4. ブランチをプッシュ (`git push origin feature/amazing-feature`)
5. Pull Requestを作成 