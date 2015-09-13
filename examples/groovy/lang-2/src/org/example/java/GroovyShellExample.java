package org.example.java;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class GroovyShellExample {
    public static void main(String[] args) {
        Binding binding = new Binding();
        binding.setProperty("width", 14);
        binding.setProperty("height", 10);
        
        GroovyShell shell = new GroovyShell(binding);
        shell.evaluate("area = width * height");
        
        Integer area = (Integer) binding.getProperty("area");
        System.out.println("area: " + area);
    }
}
