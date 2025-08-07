package api.tests.cart;

import api.tests.BaseTest;

public class BaseCartTest extends BaseTest {

    public final Integer[] productList= {3072819,3072826};
    public final Integer[] productNoEsistList={30728198,30728199};
    public final String getCartSchema = "getCartResponse-schema.json";
    public final String messageProductNotExist ="данного товара не существует";
    public final String messageProductDFindInCart ="товар в корзине не найден";
}
