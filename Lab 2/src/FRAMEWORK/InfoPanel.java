package FRAMEWORK;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class InfoPanel extends JPanel implements ComponentListener {

    private JTextArea textArea;
    private JScrollPane textScroller;

    public InfoPanel () {

        //Create text area and set its properties
        this.textArea = new JTextArea();
        this.textArea.setEditable(false); //cannot edit the text

        //Create the ScrollPane to make the text scrollable
        this.textScroller = new JScrollPane(this.textArea);
        this.textScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //Set scroll is vertical

        //Create the title and border for the scroll panel
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Message: ");
        titledBorder.setTitleColor(Color.BLUE); //Color of border
        titledBorder.setTitleJustification(TitledBorder.CENTER); // Title is in the middle

        //Create border for text
        Border textBorder = BorderFactory.createCompoundBorder(
                titledBorder,
                BorderFactory.createEmptyBorder(3,3,3,3)
        );

        //Create border for scroll
        Border scrollerBorder = BorderFactory.createCompoundBorder(
                textBorder,
                textScroller.getBorder() //Current border of textScroller
        );

        //Add textScroller to the center this panel: use BorderLayout
        this.setLayout(new BorderLayout()); //First create the border layout and add this
        this.add(textScroller,BorderLayout.CENTER);

        //Register to listen to changes of this components
        this.addComponentListener(this);
    }
    //Clear the text area
    public void clear () {
        this.textArea.setText("");
    }
    //Output text in text area
    public void println(String message) {
        this.textArea.append("\n" + message);
        this.textArea.setCaretPosition(this.textArea.getDocument().getLength()); //Set the cursor positionin a JTextArea and at the end.of the text
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension size = this.getSize();
        this.textArea.getSize(size);
        this.textScroller.getSize(size);
    } //Change size of all components in panel

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}