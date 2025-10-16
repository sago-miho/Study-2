package study;

public class Task2_20 {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ

        // ④子クラスを元にしたインスタンスを作成して下さい。(インスタンス名：child)
        Child child = new Child();

        // ⑤インスタンスchildでcallNameメソッドを呼び出して下さい。
        child.callName();

        // ⑥インスタンスchildでupdateメソッドを呼び出して下さい。
        child.update();

        // ⑦オーバーロードされたargumentメソッドを呼び出し解答画像になるように出力して下さい。
        child.argument(0);
        child.argument(1);
        child.argument(2);
    }

}
