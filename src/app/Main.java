package app;

import app.entity.Trace;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
       new Trace().analyze();
    }
}