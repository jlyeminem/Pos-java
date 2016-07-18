package promotion;

import goods.Goods;

//促销方式
public abstract class Promotion {
    abstract double getPrice(Goods goods, int num);

    public double getCouldPayPrice(double price) {
        return Double.parseDouble(String.format("%.2f",price));  //得到两位小数的价格
    }
}
