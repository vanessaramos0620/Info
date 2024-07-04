package studentrecord;


import java.awt.EventQueue;

public class StudentRecord {

    
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

 @Override
        public void run(){
            Login lp = new Login();
            lp.setVisible(true);
        }
    }
       
);

    }

    
}