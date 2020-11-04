package app;

import app.db.Connect;
import app.entity.Trace;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
       //new Trace().analyze();
        var connection = Connect.getInstance();
    }
}