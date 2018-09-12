package com.github.dnelson54.ui.messages;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.stream.Collectors;

class Message extends JLabel {

    private Message(String text) {
        super(text);
        setForeground(new Color(153, 0, 0));
    }

    static Collection<Message> create(Collection<String> messages) {
        return messages.stream().map(Message::new).collect(Collectors.toList());
    }
}
