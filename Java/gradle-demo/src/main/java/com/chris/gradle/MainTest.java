package com.chris.gradle;

import com.google.gson.Gson;
import com.power.monitor.libs.model.Vehicle;

/**
 * @author chrischan
 * create on 2019/7/12 9:39
 * use for:
 */
public class MainTest {
    public static void main(String[] args) {
        testMonitorBaseLibs();
    }

    private static void testMonitorBaseLibs() {
        Vehicle vehicle=new Vehicle();
        vehicle.setTenantId("zxbvhsahdguwsdiug");
    }

    private static void testGson() {
        System.out.println(new Gson().toJson("haha"));
    }


}
