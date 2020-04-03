package FRAMEWORK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MainFrame extends JFrame implements ComponentListener {

    static WorkingPanel workingPanel;
    static InfoPanel infoPanel;
    JSplitPane splitter;

    static  JToolBar mainToolBar;
    static  JToggleButton btnSelect;
    static  JButton btnCircle, btnRect, btnGraph;

    public MainFrame (String title) { //Title of the Main Frame


        //Setup the Main Form Parameter
        super(title); //Show title

        this.setSize(1000,800); //Create the frame with this size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Button Exit on close
        this.setLocationRelativeTo(null); //set up the window will show at the middle of the destop

        //Create the layout for the main frame

        this.setLayout(new BorderLayout());

        //Install Toolbar
        mainToolBar = new JToolBar(); //After creating toolbar -> create panel on this
        JPanel mainToolBarPanel = new JPanel();
        btnSelect = new JToggleButton("Selecting"); //Show this status is selecting
        btnSelect.setSelected(true); //Can select
        btnCircle = new JButton("Circle");
        btnRect = new JButton("Rectangle");
        btnGraph = new JButton("Graph");
        mainToolBarPanel.setLayout(new FlowLayout()); //Layout of MainToolbar not whole
        //Add component into the layout
        mainToolBarPanel.add(btnSelect);
        mainToolBarPanel.add(btnCircle);
        mainToolBarPanel.add(btnRect);
        mainToolBarPanel.add(btnGraph);
        mainToolBarPanel.setBorder(BorderFactory.createEtchedBorder());//Creates a border with an "etched" look using the component's current background color for highlighting and shading.
        mainToolBar.add(mainToolBarPanel); //Add panel into main toolbar
        this.add(mainToolBar,BorderLayout.NORTH); //Add mainToolBar into the North

        //Install Component
        MainFrame.workingPanel = new WorkingPanel();
        MainFrame.workingPanel.setPreferredSize(new Dimension(1000,600));
        JScrollPane workingScroller = new JScrollPane(MainFrame.workingPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );


        MainFrame.infoPanel = new InfoPanel();
        MainFrame.infoPanel.setPreferredSize(new Dimension(1000,600));
        splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT, workingScroller, MainFrame.infoPanel);
        splitter.setOneTouchExpandable(true);

        this.getContentPane().add(splitter);

        MainFrame.infoPanel.println("App.Started ");

        //Add Listener
        this.addComponentListener(this);
        btnSelect.addItemListener(workingPanel);
//        btnRect.addItemListener(workingPanel); //be an iteam or click -> run in working panel
        btnRect.addActionListener(workingPanel);
//        btnCircle.addItemListener(workingPanel);
        btnCircle.addActionListener(workingPanel);
//        btnGraph.addItemListener(workingPanel);
        btnGraph.addActionListener(workingPanel);


    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension size = this.getSize();
        this.splitter.setDividerLocation(0.75);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}