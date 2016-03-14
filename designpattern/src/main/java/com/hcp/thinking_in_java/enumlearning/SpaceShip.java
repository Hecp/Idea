package com.hcp.thinking_in_java.enumlearning;

/**
 * Thinking in java
 * 覆盖enum的方法
 * Created by Administrator on 2016/3/8.
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    /**
     * 覆盖toString()方法
     * @return enum实例首字母大写，其余小写字符串
     */
    public String toString(){
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s : SpaceShip.values()) {
            System.out.println(s);
        }
    }

}
