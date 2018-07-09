package listeners;

import object.KeyDto;
import javax.swing.*;
import java.awt.event.*;

public class GameKeyListener extends JFrame implements KeyListener {

    private KeyDto keyPressed;

    JLabel labelTitulo;
    JLabel labelAreaEntrada;
    JLabel labelAreaSalida;
    JLabel labelSalida;
    JLabel labelContadorVocales;
    JTextArea areaEntradaDeTexto;
    JScrollPane scrollPaneAreaEntrada;
    JTextArea areaSalidaDeTexto;
    JScrollPane scrollPaneAreaSalida;

    public GameKeyListener()
    {
        super();
        setFocusable(true);
        addKeyListener(this);
        iniciaComponentes();
        //Asigna un titulo a la barra de titulo
        setTitle("CoDejaVu : Ventana Eventos del Teclado");
        //tamaño de la ventana
        setSize(550,350);
        //pone la ventana en el Centro de la pantalla
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void iniciaComponentes(){

        labelTitulo= new JLabel();
        labelTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 28));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Eventos del Teclado");
        labelTitulo.setBorder(javax.swing.BorderFactory.
                createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelTitulo.setBounds(110, 20, 300, 40);

        labelAreaEntrada= new JLabel();
        labelAreaEntrada.setBounds(10, 70, 180, 40);
        labelAreaEntrada.setText("Area Entrada de Texto");

        areaEntradaDeTexto = new JTextArea();
        areaEntradaDeTexto.setLineWrap(true);
        areaEntradaDeTexto.addKeyListener(this);

        scrollPaneAreaEntrada = new JScrollPane();
        scrollPaneAreaEntrada.setBounds(10, 100, 513, 70);
        scrollPaneAreaEntrada.setViewportView(areaEntradaDeTexto);

        labelAreaSalida= new JLabel();
        labelAreaSalida.setBounds(10, 170, 180, 40);
        labelAreaSalida.setText("Area Salida de Texto");

        areaSalidaDeTexto = new JTextArea();
        areaSalidaDeTexto.setLineWrap(true);
        areaSalidaDeTexto.addKeyListener(this);

        scrollPaneAreaSalida = new JScrollPane();
        scrollPaneAreaSalida.setBounds(10, 200, 513, 70);
        scrollPaneAreaSalida.setViewportView(areaSalidaDeTexto);

        labelContadorVocales = new JLabel();
        labelContadorVocales.setBounds(380, 280, 190, 20);

        labelSalida = new JLabel();
        labelSalida.setText("Para salir presione la tecla Escape");
        labelSalida.setBounds(10, 280, 210, 20);

        add(labelTitulo);
        add(labelSalida);
        add(labelContadorVocales);
        add(labelAreaEntrada);
        add(labelAreaSalida);
        add(scrollPaneAreaEntrada);
        add(scrollPaneAreaSalida);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed = new KeyDto("PRESSED", e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Se solto la tecla con key : " + e.getKeyCode());
        // keyPressed = null;
    }


    public KeyDto getKeyPressed() {
        return keyPressed;
    }

}