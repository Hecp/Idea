package com.hcp.thinking_in_java.enumlearning;

/**
 * Thinking in
 * 19.7 使用接口组织枚举
 * Created by Administrator on 2016/3/12.
 */
public interface Food {
    enum Appetizer implements Food{
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food{
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
    }

    enum Dessert implements Food{
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
    }

    enum Coffee implements Food{
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCION, TEA, HERB_TEA;
    }
}
