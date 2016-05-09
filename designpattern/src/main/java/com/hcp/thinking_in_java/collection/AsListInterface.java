package com.hcp.thinking_in_java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Thinking in java
 * 11.3添加一组元素
 * Created by Administrator on 2016/3/23.
 */

class Snow{}
class Power extends Snow{}
class Light extends Power{}
class Heavy extends Power{}
class Crusty extends Snow{}
class Sluch extends Snow{}

public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snows1 = Arrays.asList(new Crusty(), new Sluch(), new Power());

        //Arrays.<Snow>asList()显示声明类型
        List<Snow> snows2 = Arrays.<Snow>asList(new Light(), new Heavy());

        List<Snow> snows3 = new ArrayList<Snow>();
        Collections.addAll(snows3, new Light(), new Heavy());
    }

}
