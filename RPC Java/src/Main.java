
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static int userWins = 0;
    private static int computerWins = 0;
    private static int ties = 0;



    public static void main(String[] args) {
        Font font = new Font("Noto Color Emoji", Font.PLAIN, 20);
        JFrame frame = new JFrame("Rock-Paper-Scissors");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel userLabel = new JLabel("User Wins: 0");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(userLabel, constraints);

        JLabel computerLabel = new JLabel("      Computer Wins: 0");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(computerLabel, constraints);

        JLabel tieLabel = new JLabel("  Ties: 0");
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(tieLabel, constraints);

        // Create a button with a rock emoji
        JButton rockButton = new JButton("\uD83E\uDD18"); // Unicode for rock emoji
        rockButton.setFont(font);
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame(1, userLabel, computerLabel, tieLabel);
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(rockButton, constraints);

        // Create a button with a paper emoji
        JButton paperButton = new JButton("\ud83d\udcd6"); // Unicode for paper emoji
        paperButton.setFont(font);
        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame(2, userLabel, computerLabel, tieLabel);
            }
        });
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(paperButton, constraints);

        // Create a button with a scissors emoji
        JButton scissorsButton = new JButton("\u2702"); // Unicode for scissors emoji
        scissorsButton.setFont(font);
        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame(3, userLabel, computerLabel, tieLabel);
            }
        });
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(scissorsButton, constraints);


        frame.add(panel);
        frame.setVisible(true);


    }

    private static void playGame(int userChoice, JLabel userLabel, JLabel computerLabel, JLabel tieLabel) {
        int computerChoice = (int) (Math.random() * 3) + 1;

        String userChoiceString = "";
        String computerChoiceString = "";

        switch (userChoice) {
            case 1:
                userChoiceString = "Rock";
                break;
            case 2:
                userChoiceString = "Paper";
                break;
            case 3:
                userChoiceString = "Scissors";
                break;
        }

        switch (computerChoice) {
            case 1:
                computerChoiceString = "Rock";
                break;
            case 2:
                computerChoiceString = "Paper";
                break;
            case 3:
                computerChoiceString = "Scissors";
                break;
        }

        String message = "You chose " + userChoiceString + ".\n"
                + "The computer chose " + computerChoiceString + ".\n";

        if (userChoice == computerChoice) {
            message += "It's a tie!";
            ties++;
            tieLabel.setText("Ties: " + ties);
        } else if ((userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)) {
            message += "You win!";
            userWins++;
            userLabel.setText("User Wins: " + userWins);
            JFrame gifFrame = new JFrame();
            ImageIcon icon = new ImageIcon("winning.gif");
            JLabel label = new JLabel(icon);
            gifFrame.add(label);
            gifFrame.pack();
            gifFrame.setLocation(550, 200); // Move window
            gifFrame.setVisible(true);

            Timer timer = new Timer(5000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gifFrame.dispose();
                }
            });
            timer.setRepeats(false);
            timer.start();

        } else {
            message += "The computer wins!";
            computerWins++;
            computerLabel.setText("     Computer Wins: " + computerWins);
        }

        JOptionPane.showMessageDialog(null, message);
        boolean keepPlaying = true;
        while (keepPlaying) {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to keep playing?", "Keep Playing", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                keepPlaying = false;  // set flag to false to exit loop
                System.exit(0);
            } else {
                keepPlaying = false;  // set flag to false to exit loop
            }
        }
    }
    }