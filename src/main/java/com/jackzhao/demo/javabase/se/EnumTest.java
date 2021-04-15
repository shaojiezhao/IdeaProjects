package com.jackzhao.demo.javabase.se;

public enum EnumTest {

    MON(1, "星期一"),TUE(2,"星期二");

    private final int dayValue;
    private  final String chinese;

    private EnumTest(int dayValue, String chinese)
    {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }
}

class Test
{
    public static void main(String[] args)
    {
        EnumTest day = EnumTest.MON;

        switch (day)
        {
            case MON:
            case TUE:
                System.out.println("周内");
                break;
            default:
                System.out.println("cannot process");
        }

    }
}
