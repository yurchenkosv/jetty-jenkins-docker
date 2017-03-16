/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.webserver.local;

import org.eclipse.jetty.server.Server;

/**
 *
 * @author yurchenko.s
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8680);
        server.start();
        server.dumpStdErr();
        server.join();
    }

}
