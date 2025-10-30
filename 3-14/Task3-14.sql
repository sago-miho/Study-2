

-- 1. 商品テーブルから価格が20000円以上の商品の商品コードと商品名、価格を取得して下さい。
    select goods_code,goods_name,price from goods_table
    where price >= 20000;

-- 2. 店舗情報を店舗名のABC順に抽出して下さい。
    select * from store_table order by store_table.store_nameAbc asc;

-- 3. 在庫テーブルに店舗テーブル、商品テーブルを「内部結合」し、店舗名・商品名・在庫数をすべて取得して下さい。
    select store_name,goods_name, quantity from stock_table
    join goods_table on stock_table.goods_code = goods_table.goods_code
    join store_table on stock_table.store_code = store_table.store_code;

-- 4. 商品テーブルから全商品の価格の平均値を抽出して下さい。
    select avg(price) from goods_table;

-- 5. 店舗コード（'EA03'）の店舗に関連する在庫情報（商品コード、在庫数）を取得して下さい。
    select goods_code,quantity,store_code from stock_table
    where store_code = 'EA03';

-- 6. 商品テーブルに「商品コード='M001'、商品名='マフラー'、価格=4500円、更新日付=本日日付」のデータを追加して下さい。。※実行後の「データ出力」画面も貼付すること。
    insert into goods_table
    (goods_code,goods_name,price,update_day)
    values
    ('M001','マフラー','4500','2025-10-30');


-- 7. 店舗テーブルに下記の3つのデータを同時に追加して下さい。
「店舗コード='EA09'、店舗名='新宿店'、店舗名(アルファベット)='SHINJUKUTEN'、更新日='2012-08-01'」
「店舗コード='WE03'、店舗名='梅田店'、店舗名(アルファベット)='UMEDETEN'、更新日='2013-02-01'」
「店舗コード='WE04'、店舗名='福岡店'、店舗名(アルファベット)='FUKUOKATEN'、更新日='2014-05-01'」
    insert into store_table
    (store_code, store_name,store_nameAbc,update_day)
    values
    ('EA09','新宿店','SHINJUKUTEN','2012-08-01'),
    ('WE03','梅田店','UMEDATEN','2013-02-01'),
    ('WE04','福岡店','FUKUOKATEN','2014-05-01');

-- 8. 在庫テーブルの在庫数が20以上の商品の在庫数を50に更新して下さい。※実行後の「データ出力」画面も貼付すること。
    update stock_table
    set
    quantity = 50
    where quantity >= 20;

-- 9. 在庫テーブルの商品（'S987'）かつ、店舗（'EA01'）の在庫数を10増やす更新を行って下さい。※実行後のSELECT結果も貼付すること。
    update stock_table
    set
    quantity = quantity + 10
    where
    goods_code = 'S987'
    and 
    store_code = 'EA01';

-- 10. 商品コード（'Z939'）かつ、店舗コード（'EA04'）に関連する在庫情報を在庫テーブルから削除して下さい。※実行後の「データ出力」画面も貼付すること。
    delete from stock_table
    where goods_code = 'Z939'
    and
    store_code = 'EA04';