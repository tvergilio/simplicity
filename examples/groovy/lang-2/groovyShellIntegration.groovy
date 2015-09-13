import groovy.lang.Binding;
import groovy.lang.GroovyShell;

// Provide script variables
Binding binding = new Binding();
binding.setProperty("width", 14);
binding.setProperty("height", 10);

// Evaluate a script
GroovyShell shell = new GroovyShell(binding);
shell.evaluate("area = width * height");

// Retrieve a result
Integer area = (Integer) binding.getProperty("area");
System.out.println("area: " + area);