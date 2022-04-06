package edu.mooncoder.view.additions;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocumentListeners {
    public interface FunctionTriggered {
        void triggerOnDocumentListener();
    }

    public static class NumberCounter implements DocumentListener {
        private final FunctionTriggered functionTriggered;

        public NumberCounter(FunctionTriggered functionTriggered) {
            this.functionTriggered = functionTriggered;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            functionTriggered.triggerOnDocumentListener();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            functionTriggered.triggerOnDocumentListener();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            functionTriggered.triggerOnDocumentListener();
        }
    }
}
