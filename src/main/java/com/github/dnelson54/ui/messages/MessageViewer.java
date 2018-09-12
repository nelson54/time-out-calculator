package com.github.dnelson54.ui.messages;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class MessageViewer extends JPanel {


    private final LayoutManager layout;

    public MessageViewer() {
        layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(layout);
    }

    public void show(Collection<String> messages) {
        this.removeAll();
        Message.create(messages).forEach(this::add);
        this.updateUI();
    }


}
