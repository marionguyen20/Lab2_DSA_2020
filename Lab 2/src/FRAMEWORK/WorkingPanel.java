package FRAMEWORK;

import GEOM.Axis;
import GEOM.Graph;
import GEOM.Point2D;
import GEOM.SpaceMapping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WorkingPanel extends JPanel implements MouseMotionListener,
        MouseListener,
        ItemListener,
        ActionListener,
        ComponentListener
{
    // Create an instance of SpaceMapping
    SpaceMapping spaceMapping = new SpaceMapping();
    Axis axis = new Axis(0,1,0,1);
    Graph sin, quad;

    public WorkingPanel () {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addComponentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MainFrame.btnCircle) {
            MainFrame.infoPanel.println("Action: Draw Circle");
        } else
            if (e.getSource() == MainFrame.btnRect) {
                MainFrame.infoPanel.println("Action: Draw Rectangle");
            } else if (e.getSource() == MainFrame.btnGraph) {
                sin = Graph.sin(2,-100,100,0.05);
                quad = Graph.quadratic(1,0,0,-100,100,0.05);
                this.repaint();
            }
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        axis.draw (g, spaceMapping);
        if (sin != null) {
            MainFrame.infoPanel.println("Action: Draw Sin Graph");
            sin.draw(g, spaceMapping);
        }
        if (quad != null) {
            MainFrame.infoPanel.println("Action: Draw Quadratic Graph");
            quad.draw(g,spaceMapping);
        }
        if (sin == null && quad == null) {
            MainFrame.infoPanel.println("Action: Cannot Draw ");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED) {
            MainFrame.infoPanel.println("Selected");
            MainFrame.btnSelect.setText("Selecting");
        } else {
            MainFrame.infoPanel.println("DeSelected");
            MainFrame.btnSelect.setText("Drawing");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //condition of double click
        if((e.getClickCount() == 2) && !e.isConsumed()) {
            Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
            String message = String.format("mouseClicked: Device (x,y) = (%d, %d);" +
                    "Logic (x,y) = (%6.2f, %6.2f) ", e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
            MainFrame.infoPanel.println(message);
            e.consume(); //stop telling the others listener when this event happened
        } else {
            Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
            String message = String.format("mouseDoubled Clicked: Device (x,y) = (%d, %d);" +
                    "Logic (x,y) = (%6.2f, %6.2f) ", e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
            MainFrame.infoPanel.println(message);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mousePressed: Device (x,y) = (%d, %d);" +
                "Logic (x,y) = (%6.2f, %6.2f) ", e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseReleased: Device (x,y) = (%d, %d);" +
                "Logic (x,y) = (%6.2f, %6.2f) ", e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseEntered: Device (x,y) = (%d, %d);" +
                "Logic (x,y) = (%6.2f, %6.2f) ", e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseExited: Device (x,y) = (%d, %d);" +
                "Logic (x,y) = (%6.2f, %6.2f) ", e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseDragged: Device (x,y) = (%d, %d);" +
                "Logic (x,y) = (%6.2f, %6.2f) ", e.getX(), e.getY(), logPoint.getX(), logPoint.getY());

        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseMoved: Device (x,y) = (%d, %d);" +
                "Logic (x,y) = (%6.2f, %6.2f) ", e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension size = this.getSize();
        int xGap = 50, yGap = 20;
        this.spaceMapping.updateDevViewPort(xGap, size.width - 2*xGap, yGap, size.height-2*yGap);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
//        addComponentListener(this);
    }

    @Override
    public void componentShown(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
//        addComponentListener(this);
    }
    @Override
    public void componentHidden(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
//        addComponentListener(this);
    }
}
