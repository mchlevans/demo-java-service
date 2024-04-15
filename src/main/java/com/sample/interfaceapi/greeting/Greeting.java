package com.autos.api.greeting;

/*
    The Greeting object must be converted to JSON. Thanks to 
    Spring’s HTTP message converter support, you need not do 
    this conversion manually. Because Jackson 2 is on the 
    classpath, Spring’s MappingJackson2HttpMessageConverter 
    is automatically chosen to convert the Greeting instance 
    to JSON.
*/

public record Greeting(long id, String content) {};
