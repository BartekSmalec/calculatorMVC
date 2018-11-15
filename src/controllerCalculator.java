import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class controllerCalculator {
    private modelCalculator model;
    private viewCalculator view;
    private String buffor;

    public controllerCalculator(modelCalculator model, viewCalculator view) {
        this.model = model;
        this.view = view;
        view.addActionListner(new ListenForButtons());
        view.addKeyListner(new ListenForKey());
        buffor = new String("");


    }

    private class ListenForButtons implements ActionListener {
        //String temp = new String("");
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!e.getActionCommand().equals("CE") && !e.getActionCommand().equals("=")) {

                buffor += e.getActionCommand();
                view.setTextResult(buffor);

            } else if (e.getActionCommand().equals("=")) {
                //System.out.println(view.getTextResult());
                model.setBuffor(view.getTextResult());

                buffor = model.getCalculation();
                view.setTextResult(buffor);


                //view.setTextResult(buffor);


            } else {

                view.setTextResult("0.0");


                buffor = "";
            }
        }
    }

    private class ListenForKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {


        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

                buffor = view.getTextResult();
                view.displayMessage("XD");
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            }

        }
    }
}
