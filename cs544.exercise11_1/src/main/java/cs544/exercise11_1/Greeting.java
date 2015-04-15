/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.exercise11_1;

/**
 *
 * @author Shanta
 */
public class Greeting {
    private String greeting;

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting() {
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
    public void sayHello(){
    System.out.println(greeting);
    }
    
    
}
