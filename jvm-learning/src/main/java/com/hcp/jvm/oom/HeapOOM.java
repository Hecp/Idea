package com.hcp.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcp on 2018/6/9.
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
