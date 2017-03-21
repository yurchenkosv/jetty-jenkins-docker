/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.webserver.local;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 *
 * @author yurchenko.s
 */
public class MainTest {
    @Test
    public void ensureAppRunning(){
        int ret = Main.Running();
        assertEquals(1, ret);
    }
}
