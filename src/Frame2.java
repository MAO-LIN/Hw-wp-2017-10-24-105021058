import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.*;

public class Frame2 extends JFrame {
    private int screenH= Toolkit.getDefaultToolkit().getScreenSize().height;
    private int screenW= Toolkit.getDefaultToolkit().getScreenSize().width;
    private JMenuBar jmb=new JMenuBar();
    private JMenu jmF=new JMenu("File");
    private JMenu jmS=new JMenu("Set");
    private JMenu jmG=new JMenu("Game");
    private JMenu jmA=new JMenu("About");
    private JMenuItem jmFExit=new JMenuItem("Exit");
    private JMenuItem jmFLoto=new JMenuItem("Loto");
    private JMenuItem jmFKeyB=new JMenuItem("keyboard");
    private JInternalFrame jinFrame=new JInternalFrame();
    private JInternalFrame jinFrame2=new JInternalFrame();
    private JDesktopPane jdktpane= new JDesktopPane();
    private JPanel jinPanlC=new JPanel(new GridLayout(1,6,5,5));
    private JLabel jlbLoto[]=new JLabel[6];
    private JPanel jinPanlS=new JPanel(new GridLayout(1,2,15,10));
    private JButton jinbtnClose=new JButton("Exit");
    private JButton jinbtnGo=new JButton("Go");
    private Random rdm=new Random(System.currentTimeMillis());
    private LoginFrame log;

    public Frame2(LoginFrame LoginFrame){
        log=LoginFrame;
        initComp();
    }
    private void initComp(){
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-600/2,screenH/2-450/2,600,450);
        this.setJMenuBar(jmb);
        this.setContentPane(jdktpane);
        jinFrame.setBounds(0,0,300,150);
        jinFrame.setBounds(0,0,500,400);
        jmb.add(jmF);
        jmb.add(jmS);
        jmb.add(jmG);
        jmb.add(jmA);
        jmF.add(jmFExit);
        jmG.add(jmFLoto);
        jmG.add(jmFKeyB);
        jmFLoto.setAccelerator(KeyStroke.getKeyStroke('L',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jinFrame.setLayout(new BorderLayout(5,5));
        jinFrame.add(BorderLayout.CENTER,jinPanlC);
        for(int i=0;i<6;i++){
            jlbLoto[i]=new JLabel("null",JLabel.CENTER);
            jlbLoto[i].setFont(new Font("",Font.BOLD,24));
            jlbLoto[i].setBackground(new Color(175, 231,255));
            jinPanlC.add(jlbLoto[i]);
            jlbLoto[i].setBackground(new Color(255, 222, 185));
        }
        setLoto();
        jdktpane.add(jinFrame);
        jinFrame.add(BorderLayout.SOUTH,jinPanlS);
        jinPanlS.add(jinbtnClose);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Frame2.this.setVisible(false);
                log.setVisible(true);
            }
        });
        jinbtnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jinFrame.setVisible(false);
            }
        });
        jinPanlS.add(jinbtnGo);

        jmFExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmFExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmFLoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jinFrame.setVisible(true);
            }
        });
        jinbtnGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLoto();
            }
        });

    }
    private void setLoto(){
        for(int i=0;i<6;i++){
            jlbLoto[i].setText(Integer.toString(rdm.nextInt(6)+1));
            for(int j=0;j<i;j++){
                if(jlbLoto[i].getText().equals(jlbLoto[j].getText())){
                   i=i-1;
                   break;
                }
            }
        }
    }
}
