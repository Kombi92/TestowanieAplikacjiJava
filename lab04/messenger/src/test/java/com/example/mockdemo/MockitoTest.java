package com.example.mockdemo;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockitoTest {

    private final String VALID_SERVER = "inf.ug.edu.pl";
    private final String INVALID_SERVER = "inf.ug.edu.eu";
    private final String SHORT_SERVER = ".pl";
    private final String VALID_MESSAGE = "some message";
    private final String INVALID_MESSAGE = "ab";

    @Mock private MessageService mock;
    private Messenger messenger;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        messenger = new Messenger(mock);

    }

    @Test
    public void testValidServer() {

        when(mock.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
        assertEquals(0, messenger.testConnection(VALID_SERVER));
        verify(mock).checkConnection(VALID_SERVER);

    }

    @Test
    public void testInvalidServer() {

        when(mock.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
        assertEquals(1, messenger.testConnection(INVALID_SERVER));
        verify(mock).checkConnection(INVALID_SERVER);

    }

    @Test
    public void testShortServer() {

        when(mock.checkConnection(SHORT_SERVER)).thenReturn(ConnectionStatus.FAILURE);
        assertEquals(1, messenger.testConnection(SHORT_SERVER));
        verify(mock).checkConnection(SHORT_SERVER);

    }

    @Test
    public void testSendInvalidServer() throws MalformedRecipientException {

        when(mock.send(INVALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
        assertEquals(1, messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
        verify(mock).send(INVALID_SERVER, VALID_MESSAGE);

    }

    @Test
    public void testSendInvalidMessage() throws MalformedRecipientException {

        when(mock.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
        assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
        verify(mock).send(VALID_SERVER, INVALID_MESSAGE);

    }

    @Test
    public void testSendValid() throws MalformedRecipientException {

        when(mock.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
        assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
        verify(mock).send(VALID_SERVER, VALID_MESSAGE);

    }

}
