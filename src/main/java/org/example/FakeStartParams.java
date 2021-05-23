package org.example;

public class FakeStartParams {

    Boolean asGui = true; // default.
    Boolean asServer = false;
    String serverIP = "127.0.0.0.1";
    int serverPort = 1234;

    static FakeStartParams fromArgs(String[] args){

        FakeStartParams fp = new FakeStartParams();
        // if args contains.. "--cli ".. then asGui = false
        // and check conflict:if server never GUI..

        // here simply:
        fp.asGui = true;

        return fp;
    }
}
