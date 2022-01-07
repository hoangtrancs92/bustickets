package com.example.bustickets.testcase;

import org.junit.Test;
import org.junit.Assert;
import com.example.bustickets.config.kiemtra;
import org.junit.runner.RunWith;

public class test {
    @Test
    public void say_hello(){
        kiemtra kt = new kiemtra("pete");
        Assert.assertEquals("hellopete",kt.hello());
        Assert.assertEquals("hellojohn",kt.hello("john"));
        Assert.assertNotEquals("hello john",kt.hello());
    }
}
