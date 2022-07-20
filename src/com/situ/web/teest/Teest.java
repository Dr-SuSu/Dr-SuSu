package com.situ.web.teest;

import org.junit.Test;

public class Teest {
    class Foo {
        final int i;
        int j;

        Foo(int i) {
            this.i = i;
        }

        public void doSomething() {
            System.out.println(++j + i);
        }

    }
    public class While {
        public void loop() {
            int x= 10;
            while ( x == 0 )  {
                System.out.print("x minus one is " + (x - 1));
                x -= 1;
            }
        }
    }
    @Test
    public void test1() {
        System.out.println(13 & 17);
    }
}
