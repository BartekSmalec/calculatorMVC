import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;



public class viewCalculator extends JFrame {
    private List<JButton> jButtons;
    private JTextField textResult;
    private String[] buttons;
    private JPanel thePanel;
    private GridBagLayout gridBagLayout;

    private GridBagConstraints gridBagConstraints;

    public viewCalculator() {

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        buttons = new String[]{"(", ")", "^", "CE", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        jButtons = new ArrayList<>(buttons.length);
        for (String temp : buttons) {
            jButtons.add(new JButton(temp));
        }
        textResult = new JTextField("0.0", 20);
        textResult.setEditable(false);
        textResult.setHorizontalAlignment(SwingConstants.RIGHT);

        thePanel = new JPanel();

        gridBagLayout = new GridBagLayout();
        gridBagConstraints = new GridBagConstraints();
        thePanel.setLayout(gridBagLayout);



        // Default settings
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        gridBagConstraints.gridwidth = 1;//how many columns it gona take up
        gridBagConstraints.gridheight = 1; //how many rown it gonna take up

        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 10;

        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.NORTH;

        gridBagConstraints.fill = GridBagConstraints.BOTH;




        gridBagConstraints.gridwidth = 4;
        thePanel.add(textResult, gridBagConstraints);
        gridBagConstraints.weightx = 50;

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx =  0;
        gridBagConstraints.gridy =  1;
        thePanel.add(jButtons.get(0),gridBagConstraints);

        gridBagConstraints.gridx =  1;
        thePanel.add(jButtons.get(1),gridBagConstraints);
        gridBagConstraints.gridx =  2;
        thePanel.add(jButtons.get(2),gridBagConstraints);
        gridBagConstraints.gridx =  3;
        thePanel.add(jButtons.get(3),gridBagConstraints);
        gridBagConstraints.gridx =  0;
        gridBagConstraints.gridy =  2;
        thePanel.add(jButtons.get(4),gridBagConstraints);
        gridBagConstraints.gridx =  1;
        thePanel.add(jButtons.get(5),gridBagConstraints);
        gridBagConstraints.gridx =  2;
        thePanel.add(jButtons.get(6),gridBagConstraints);
        gridBagConstraints.gridx =  3;
        thePanel.add(jButtons.get(7),gridBagConstraints);

        gridBagConstraints.gridx =  0;
        gridBagConstraints.gridy =  3;
        thePanel.add(jButtons.get(8),gridBagConstraints);
        gridBagConstraints.gridx =  1;
        thePanel.add(jButtons.get(9),gridBagConstraints);
        gridBagConstraints.gridx =  2;
        thePanel.add(jButtons.get(10),gridBagConstraints);
        gridBagConstraints.gridx =  3;
        thePanel.add(jButtons.get(11),gridBagConstraints);

        gridBagConstraints.gridx =  0;
        gridBagConstraints.gridy =  4;
        thePanel.add(jButtons.get(12),gridBagConstraints);
        gridBagConstraints.gridx =  1;
        thePanel.add(jButtons.get(13),gridBagConstraints);
        gridBagConstraints.gridx =  2;
        thePanel.add(jButtons.get(14),gridBagConstraints);
        gridBagConstraints.gridx =  3;
        thePanel.add(jButtons.get(15),gridBagConstraints);

        gridBagConstraints.gridx =  0;
        gridBagConstraints.gridy =  5;
        thePanel.add(jButtons.get(16),gridBagConstraints);
        gridBagConstraints.gridx =  1;
        thePanel.add(jButtons.get(17),gridBagConstraints);
        gridBagConstraints.gridx =  2;
        thePanel.add(jButtons.get(18),gridBagConstraints);
        gridBagConstraints.gridx =  3;
        thePanel.add(jButtons.get(19),gridBagConstraints);





        this.add(thePanel);
        this.setVisible(true);


    }

    public void displayError(String errorMessage)
    {
        JOptionPane.showMessageDialog(this,errorMessage);
    }

    public void displayMessage(String messgae) {
        Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);

        int msg = JOptionPane.showConfirmDialog(this, "Messgge", "Title",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(image));
        System.out.println(msg);
    }

    public String getTextResult()
    {
        return textResult.getText();
    }
    public void setTextResult(String text)
    {
        textResult.setText(text);
    }
    public void addActionListner(ActionListener e)
    {
        for(JButton button: jButtons)
        {
            button.addActionListener(e);
        }
    }

    public void addKeyListner(KeyListener a )
    {
        textResult.addKeyListener(a);
    }

}
