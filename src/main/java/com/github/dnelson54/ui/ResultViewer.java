package com.github.dnelson54.ui;

import javax.swing.*;
import java.awt.*;

class ResultViewer extends JPanel {

    private LayoutManager layout;
    private JLabel result;

    ResultViewer() {
        layout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(layout);

        setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        setMinimumSize(new Dimension(100, 100));

        result = new JLabel();
        add(result);
    }

    void updateResult(String text) {
        this.result.setText(text);
    }
}
