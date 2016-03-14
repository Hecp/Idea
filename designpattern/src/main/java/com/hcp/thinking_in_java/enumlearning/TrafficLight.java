package com.hcp.thinking_in_java.enumlearning;

/**
 * Thinking in java
 * switch语句中的enum
 * Created by Administrator on 2016/3/8.
 */
enum Signal{
    GREEN, YELLOW, RED
}
public class TrafficLight {
    Signal color = Signal.RED;
    /*swith中的enum其实是编译器已经通过调用enum实例的ordinal()方法
    获取当前实例所声明的次序值，然后再进行比较。*/
    public void change(){
        switch (color){
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    public String toString(){
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(trafficLight);
            trafficLight.change();
        }
    }
}
