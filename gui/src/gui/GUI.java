/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
 
/**
 *
 * @author Sean Placchetti
 */
public class GUI extends JFrame implements ActionListener {

    protected UndoAction undoAction;
     
    protected RedoAction redoAction;
    protected UndoManager undoMan = new UndoManager();
    JButton save, load, cut, copy, paste, undo, redo;
    JTextArea text;

    public GUI() {
        super("Text Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }

    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(null);
        undoAction = new UndoAction();
        redoAction = new RedoAction();


        save = new JButton("save");
        save.setBounds(60, 20, 70, 40);
        panel.add(save);

        load = new JButton("load");
        load.setBounds(130, 20, 70, 40);
        panel.add(load);

        undo = new JButton("undo");
        undo.setBounds(200, 20, 70, 40);
        undo.addActionListener(undoAction);
        panel.add(undo);

        redo = new JButton("redo");
        redo.addActionListener(redoAction);
        redo.setBounds(270, 20, 70, 40);
        panel.add(redo);

        cut = new JButton("cut");
        cut.setBounds(340, 20, 70, 40);
        panel.add(cut);

        copy = new JButton("copy");
        copy.setBounds(410, 20, 70, 40);
        panel.add(copy);

        paste = new JButton("paste");
        paste.setBounds(480, 20, 70, 40);
        panel.add(paste);

        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");


        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        menubar.setBounds(0, 0, 50, 20);
        menubar.add(file);
        file.add(save);
        file.add(load);
        file.add(redoAction);
        file.add(undoAction);
        file.add(cut);
        file.add(copy);
        file.add(paste);
        panel.add(menubar);

        text = new JTextArea();
        text.setBounds(30, 80, 440, 300);
        panel.add(text);
        add(panel);
        setSize(600, 500);



        text.getDocument().addUndoableEditListener(new undoRedoListener());
    }

    class undoRedoListener implements UndoableEditListener {

        public void undoableEditHappened(UndoableEditEvent e) {
            //Remember the edit and update the menus.
            undoMan.addEdit(e.getEdit());
            undoAction.updateUndo();
            redoAction.updateRedo();
        }
    }

    class UndoAction extends AbstractAction {

        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            // makes sure that you can undo an action before attempting
            try {
                undoMan.undo();
            } catch (CannotUndoException ex) {
                System.out.println("Could not undo.");
            }
            updateUndo();
            redoAction.updateRedo();
        }

        protected void updateUndo() {
            // gets the action, enables the object that is using the listener to be able to undo things
            if (undoMan.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, undoMan.getUndoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Undo");
            }
        }
    }

    class RedoAction extends AbstractAction {

        public RedoAction() {
            super("Redo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            // makes sure that you can redo an action before attempting
            try {
                undoMan.redo();
            } catch (CannotRedoException ex) {
                System.out.println("Could not redo.");
            }
            updateRedo();
            undoAction.updateUndo();
        }

        protected void updateRedo() {
            // gets the action, enables the object that is using the listener to be able to undo things
            if (undoMan.canRedo()) {
                setEnabled(true);
                putValue(Action.NAME, undoMan.getRedoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}