package com.hcp.thinking_in_java.enumlearning;

import com.hcp.thinking_in_java.utils.Generator;

import java.util.Random;

/**
 * Thinking in java
 * 19.5 实现，而非继承
 * Created by Administrator on 2016/3/9.
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCKY, SILLY, BOUNCY, NUTTY, BOB;
    private Random random = new Random(47);
    public CartoonCharacter next(){
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation{
    public static <T> void printNext(Generator<T> rg){
        System.out.println(rg.next() + ". ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}