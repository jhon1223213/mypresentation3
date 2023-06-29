package myPresentation;

/**
 * Jhon Frank Vasquez Valencia - 2226510 - jhon.frank.vasquez@correounivalle.edu.co
 */

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    // atributos
    private JButton myPhoto, myHobby, myExpectations;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private Title title;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    // métodos
    public GUI() {
        initGUI();

        this.setTitle("¿Quien soy...?");
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); // Hacer la ventana no redimensionable

        this.addMouseListener(listener);
        this.addKeyListener(listener);
        this.setFocusable(true);
    }

    private void initGUI() {
        // Definir container y Layout del JFrame
        // Crear objetos Escucha y Control
        // Configurar JComponents
        title = new Title("Un poco sobre mì  ", Color.BLACK);
        myPhoto = new JButton("Fisicamente");
        myHobby = new JButton("Pasiones");
        myExpectations = new JButton("Expectativas");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea(10, 12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, " Sobre Mí  ", TitledBorder.RIGHT,
                TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.SANS_SERIF, Font.PLAIN, 20), Color.BLACK));
        containerImage.add(imageLabel);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);

        myPhoto.addActionListener(listener);
        myHobby.addMouseListener(listener);
        myExpectations.addKeyListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI myGui = new GUI();
            }
        });
    }

    private  class Listener implements ActionListener, MouseListener, KeyListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearImageAndText();
            if (e.getSource() == myPhoto) {
                showPhoto();
            }
            revalidate();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                clearImageAndText();
                if (e.getSource() == GUI.this || e.getSource() == myHobby) {
                    showHobby();
                }
                revalidate();
                repaint();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 'm') {
                clearImageAndText();
                showExpectations();
                revalidate();
                repaint();
            }
        }

        // Implementar los demás métodos del MouseListener y KeyListener
        // con una implementación vacía ya que no se necesitan en este caso.

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

    private void clearImageAndText() {
        imageLabel.setIcon(null);
        containerImage.remove(expectativesText);
        revalidate();
        repaint();
    }

    private void showPhoto() {
        clearImageAndText();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Me.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH); // Tamaño deseado: 300x300
        imageIcon.setImage(image);
        imageLabel.setIcon(imageIcon);
    }

    private void showHobby() {
        clearImageAndText();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Hobby.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH); // Tamaño deseado: 300x300
        imageIcon.setImage(image);
        imageLabel.setIcon(imageIcon);
    }

    private void showExpectations() {
        expectativesText.setText("Hola.\n"
                + "\n"
                + "Si estas en este punto, es porque te a gustado algo del mundo del desarrollo de sofware.\n"
                + "Depronto ya trabajas en ese entorno, o en algun momento te gustaria estar en ese punto.\n"
                + "Entonces, para eso empezaras a construir proyectos como este o mejores.\n"
                + "\n"
                + "Soy Jhon Frank, estudiante de desarrollo de software y esto es un poco sobre mi.\n"
                + "Correo para contractaciones: jhon.frank.vasquez@correounivalle.edu.co");
        expectativesText.setBackground(Color.WHITE);
        expectativesText.setForeground(Color.BLACK);
        expectativesText.setEditable(false); // Deshabilitar la edición del texto
        containerImage.add(expectativesText);
    }
}
