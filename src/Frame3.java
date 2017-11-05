import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Frame3 extends JFrame{
    private Container cp;
    private JTextField jtf=new JTextField();
    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
    private int LoginH=500,LoginW=400;
    private int screenW= dim.width;
    private int screenH= dim.height;
    private JButton btn[]=new JButton[12];
    private JPanel conter=new JPanel(new GridLayout(4,3,5,5));
    private LoginFrame log;
    private String data[]={"0","1","2","3","4","5","6","7","8","9"};
    public Frame3(LoginFrame loginFrame){
        log=loginFrame;
        initComp();
    }
    private void initComp(){
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Random rdm=new Random();
        this.setBounds(screenW/2-LoginW/2,screenH/2-LoginH/2,LoginW,LoginH);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(BorderLayout.NORTH,jtf);
        cp.add(BorderLayout.CENTER,conter);
        jtf.setEditable(false);
        String tmp;
        for(int i=0;i<10;i++){
            int index=rdm.nextInt(8);
            tmp=data[i];
            data[i]=data[index];
            data[index]=tmp;
        }
        for(int i=0;i<10;i++){
            btn[i]=new JButton(data[i]);
            conter.add(btn[i]);
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempBtn= (JButton)e.getSource();
                    jtf.setText(jtf.getText()+tempBtn.getText());
                }
            });
        }
        btn[10]=new JButton("<");
        conter.add(btn[10]);
        btn[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String tmp=jtf.getText().substring(0,jtf.getText().length()-1);
                if(!jtf.getText().equals("")) {
                    jtf.setText(jtf.getText().substring(0, jtf.getText().length() - 1));
                }
            }
        });
        btn[11]=new JButton("Clear");
        conter.add(btn[11]);
        btn[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                Frame2.this.setVisible(false);
                dispose();
                log.setVisible(true);
            }
        });

    }
}
