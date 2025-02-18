# Menu Manager Sample Application

このプロジェクトは、Spring Menu Managerライブラリを使用したサンプルアプリケーションです。

## 機能

- メニュー項目の取得API
- H2インメモリデータベースの使用
- Flywayによるデータベースマイグレーション
- サンプルデータの自動登録

## 使用方法

### アプリケーションの起動

```bash
./gradlew :menu-sample:bootRun
```

### APIエンドポイント

1. 全メニュー項目の取得
```bash
curl http://localhost:8080/api/menu
```

2. ルートメニュー項目の取得
```bash
curl http://localhost:8080/api/menu/root
```

3. サブメニュー項目の取得
```bash
curl http://localhost:8080/api/menu/sub/{parentId}
```

### H2データベースコンソール

- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:menudb`
- ユーザー名: `sa`
- パスワード: (空白)

## サンプルデータ

以下のメニュー構造が初期データとして登録されます：

```
- ホーム (/)
- 設定 (/settings)
  - プロフィール設定 (/settings/profile)
```

## 設定ファイル

主な設定は`src/main/resources/application.yml`で管理されています：

- データベース接続設定
- JPA設定
- Flyway設定
- サーバー設定

## 依存関係

- Spring Boot 3.2.2
- Spring Menu Manager (ローカルライブラリ)
- H2 Database
- Flyway
- Lombok 