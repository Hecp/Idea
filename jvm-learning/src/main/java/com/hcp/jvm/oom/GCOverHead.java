package com.hcp.jvm.oom;

import java.util.Map;
import java.util.Random;

/**
 * java -Xmx12m -XX:+UseParallelGC GCOverHead
 * Created by hcp on 2018/8/2.
 */
public class GCOverHead {
    public static void main(String[] args) {
        Map map = System.getProperties();
        Random random = new Random();
        while (true) {
            int randomInt = random.nextInt();
            map.put(randomInt, "value" + randomInt);
        }
    }
}
