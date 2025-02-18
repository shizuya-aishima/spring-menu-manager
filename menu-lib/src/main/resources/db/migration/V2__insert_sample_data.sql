-- Root menu items
INSERT INTO menu_items (name, url, display_order, icon, enabled, created_at, updated_at)
VALUES 
('ホーム', '/', 1, 'home', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('設定', '/settings', 2, 'settings', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sub menu items for Settings
INSERT INTO menu_items (name, url, display_order, parent_id, icon, enabled, created_at, updated_at)
SELECT 
    'プロフィール設定',
    '/settings/profile',
    1,
    id,
    'person',
    true,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM menu_items
WHERE name = '設定'; 