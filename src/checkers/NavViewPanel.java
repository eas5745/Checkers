/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author eas57
 */
public class NavViewPanel extends JPanel{

    NavViewBottomMenuPanel menu;
    NavViewSplashPanel splash;
    private MovePanel movePanel;
    private OptionsView o_view;
    private MainView m_view;
    private InstructionsView i_view;
    private CreditsView c_view;
    private NameLabelPanel nameLabelPanel;
    
    public NavViewPanel() {
        super();
        setLayout(new BorderLayout());     
        menu = new NavViewBottomMenuPanel();
        splash = new NavViewSplashPanel();
        nameLabelPanel = new NameLabelPanel();
        movePanel = new MovePanel();
        m_view = new MainView(movePanel);
     
        add(menu, BorderLayout.SOUTH);        
        add(splash, BorderLayout.CENTER);     
        
    }
    
    //Note: Splash scrren is only shown on startup.  No need to navigate back to it.
    
    public void addInstructions(InstructionsView i_view)
    {
        this.i_view = i_view;
        add(i_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void addOptions(OptionsView o_view)
    {
        this.o_view = o_view; //maintain handle to this view so we can remove it
        add(o_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void addCredits(CreditsView c_view)
    {
        this.c_view = c_view;
        add(c_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    public void addNameLabel(NameLabelPanel nameLabelPanel)
    {
        this.m_view = m_view;  //maintain handle to this view so we can remove it
        this.nameLabelPanel = nameLabelPanel;
        this.movePanel = movePanel;
        
        add(m_view, BorderLayout.CENTER);
        add(nameLabelPanel, BorderLayout.NORTH);
        add(movePanel, BorderLayout.EAST); 
        
        revalidate();
        repaint();
    }    
    
    public void addSplash(NavView n_view)
    {
        add(n_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    
    public void removeOptions()
    {
        if (this.o_view != null)
            remove(this.o_view);
    }
    
    public void removeMain()
    {
        if (this.m_view != null) {
            remove(this.m_view);
            remove(this.nameLabelPanel);
            remove(this.movePanel);
        }
    }    
    
    public void removeSplash()
    {
        remove(splash);
    }
    
    public void removeInstructions()
    {
            if (this.i_view != null)
                remove(this.i_view);
    }
         
    public void removeCredits()
    {
        if (this.c_view != null)
               remove(this.c_view);
    }
}
