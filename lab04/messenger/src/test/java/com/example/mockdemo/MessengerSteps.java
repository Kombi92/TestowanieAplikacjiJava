package com.example.mockdemo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class MessengerSteps extends Steps{

    private Messenger mess;
    private MessageService ms;
    private String server;
    private String message;

    @Given("a messenger")
    public void MessengerSetup(){
        mess = new Messenger(new MessageServiceSimpleImpl());
    }

    @When("connect to $a")
    public void connectTo(String a){
        server = a;
    }

    @Then("connection should return $result")
    public void shouldConnect(int result){
        assertEquals(result, mess.testConnection(server));
    }

    @When("given server $s and message $m")
    public void givenValues(String a,String m){
        server = a;
        message = m;
    }

    @Then("sending should return $r or $re")
    public void shouldSend(int r,int re){
        int result = mess.sendMessage(server,message);
        assertTrue(result == r ||  result == re);
    }
    @Then("sending should return $result")
    public void shouldSend(int result){
        assertEquals(result, mess.sendMessage(server,message));
    }

}
