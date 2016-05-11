package tests;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

/**
*Audio tone generator, using the Java sampled sound API.
*@author Andrew Thompson
*@version 2007/12/6
*@source https://community.oracle.com/thread/1273219?start=0&tstart=0
*/
public class Sound extends JFrame {

  static AudioFormat af;
  static SourceDataLine sdl;

  public Sound() {
    super("Audio Tone");
    // Use current OS look and feel.
    
   

    try {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (UnsupportedLookAndFeelException e) {
        // handle exception
    } catch (ClassNotFoundException e) {
        // handle exception
    } catch (InstantiationException e) {
        // handle exception
    } catch (IllegalAccessException e) {
        // handle exception
    }
        /*try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Internal Look And Feel Setting Error.");
            System.err.println(e);
        }*/

    JPanel pMain=new JPanel(new BorderLayout());

    final JSlider sTone=new JSlider(JSlider.VERTICAL,200,2000,441);
    sTone.setPaintLabels(true);
    sTone.setPaintTicks(true);
    sTone.setMajorTickSpacing(200);
    sTone.setMinorTickSpacing(100);
    sTone.setToolTipText(
      "Tone (in Hertz or cycles per second - middle C is 441 Hz)");
    sTone.setBorder(new TitledBorder("Frequency"));
    pMain.add(sTone,BorderLayout.CENTER);

    final JSlider sDuration=new JSlider(JSlider.VERTICAL,0,2000,1000);
    sDuration.setPaintLabels(true);
    sDuration.setPaintTicks(true);
    sDuration.setMajorTickSpacing(200);
    sDuration.setMinorTickSpacing(100);
    sDuration.setToolTipText("Duration in milliseconds");
    sDuration.setBorder(new TitledBorder("Length"));
    pMain.add(sDuration,BorderLayout.EAST);

    final JSlider sVolume=new JSlider(JSlider.VERTICAL,0,100,20);
    sVolume.setPaintLabels(true);
    sVolume.setPaintTicks(true);
    sVolume.setSnapToTicks(false);
    sVolume.setMajorTickSpacing(20);
    sVolume.setMinorTickSpacing(10);
    sVolume.setToolTipText("Volume 0 - none, 100 - full");
    sVolume.setBorder(new TitledBorder("Volume"));
    pMain.add(sVolume,BorderLayout.WEST);

    final JCheckBox cbHarmonic  = new JCheckBox( "Add Harmonic", true );
    cbHarmonic.setToolTipText("..else pure sine tone");

    JButton bGenerate = new JButton("Generate Tone");
    bGenerate.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try{
            generateTone(sTone.getValue(),
              sDuration.getValue(),
              (int)(sVolume.getValue()*1.28),
              cbHarmonic.isSelected());
          }catch(LineUnavailableException lue){
            System.out.println(lue);
          }
        }
      } );

    JPanel pNorth = new JPanel(new BorderLayout());
    pNorth.add(bGenerate,BorderLayout.WEST);

    pNorth.add( cbHarmonic, BorderLayout.EAST );

    pMain.add(pNorth, BorderLayout.NORTH);
    pMain.setBorder( new javax.swing.border.EmptyBorder(5,3,5,3) );

    getContentPane().add(pMain);
    pack();
    setLocation(0,20);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    String address = "/image/tone32x32.png";
    URL url = getClass().getResource(address);

    if (url!=null) {
      Image icon = Toolkit.getDefaultToolkit().getImage(url);
      setIconImage(icon);
    }
  }

  /** Generates a tone.
  @param hz Base frequency (neglecting harmonic) of the tone in cycles per second
  @param msecs The number of milliseconds to play the tone.
  @param volume Volume, form 0 (mute) to 100 (max).
  @param addHarmonic Whether to add an harmonic, one octave up. */
  public static void generateTone(int hz,int msecs, int volume, boolean addHarmonic)
    throws LineUnavailableException {

    float frequency = 44100;
    byte[] buf;
    AudioFormat af;
    if (addHarmonic) {
      buf = new byte[2];
      af = new AudioFormat(frequency,8,2,true,false);
    } else {
      buf = new byte[1];
      af = new AudioFormat(frequency,8,1,true,false);
    }
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl = AudioSystem.getSourceDataLine(af);
    sdl.open(af);
    sdl.start();
    for(int i=0; i<msecs*frequency/1000; i++){
      double angle = i/(frequency/hz)*2.0*Math.PI;
      buf[0]=(byte)(Math.sin(angle)*volume);

      if(addHarmonic) {
        double angle2 = (i)/(frequency/hz)*2.0*Math.PI;
        buf[1]=(byte)(Math.sin(2*angle2)*volume*0.6);
        sdl.write(buf,0,2);
      } else {
        sdl.write(buf,0,1);
      }
    }
    sdl.drain();
    sdl.stop();
    sdl.close();
  }

  public static void main(String[] args){
    Runnable r = new Runnable() {
      public void run() {
        Sound t = new Sound();
        t.setVisible(true);
      }
    };
    SwingUtilities.invokeLater(r);
  }
}