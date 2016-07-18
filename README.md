# Read me

[pipeline](http://52.77.255.254:8080/ "Jenkins Pipeline")

##说明:

###cart
   >CartItems   购物车,存储用户购买的商品和数量Map<String,Integer>

   >Item        购物车中的促销商品信息

###goods
   >Goods      商品类,其属性为商品信息:名称，数量单位，单价，类别和条形码（伪）。

   >GoodsMap   存储着商店的全部商品信息,可通过商品条形码查看商品的具体信息Hash<String,Goods>

###onsale:
   >BuyTwoGetOneFreeGoodsList    存储着享受买二赠一促销的商品信息List<String>

   >NinetyFiveDiscountGoodsList  存储着享受95折促销的商品信息List<String>

###promotion:
   >Promotion                    各类促销类的父类,方法有:计算促销后商品的价格;将价格的小数转化为2位

   >BuyTwoGetOneFreePromotion    买二赠一。覆盖父类的计算价格方法,享受该折扣的商品则价格相当于买三花二,否则,买三花三

   >NinetyFiveDiscountPromotion  95折。覆盖父类的计算价格方法,享受该折扣的商品则价格相当于0.95*原价,否则,为原价

###utils:
   >ParseUtils      解析商品条形码中包含'-'的条形码,如苹果的条形码"ITEM000003-2",解析后为"ITEM000003-"



