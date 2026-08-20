import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;

public class MainFrame extends JFrame {
    private JPanel jpanel;
    private JTextField kullaniciadiarayuz;
    private JTextField sifrearayuz;
    private JButton kayitolmaButton;
    private JButton girisyapmaButton;

    public void createUIComponents() {
        // TODO: place custom component creation code here

    }
    public MainFrame(){
        add(jpanel);
        setSize(400, 250);
        setTitle("Fatih Login System");




        girisyapmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                String usernameinput = kullaniciadiarayuz.getText();
                String passwordinput = sifrearayuz.getText();


                int usernamekontrollogin = usernameinput.indexOf(",");
                int passwordkontrollogin = passwordinput.indexOf(",");

                int usernamekontroluzunluklogin = usernameinput.length();
                int passwordkontroluzunluklogin = passwordinput.length();

                if (!Objects.equals(usernameinput, "") && !Objects.equals(passwordinput, "")) {

                    if (usernamekontroluzunluklogin > 4 && passwordkontroluzunluklogin > 4) {

                        if (usernamekontrollogin == -1 && passwordkontrollogin == -1) {

                            int girisbasarili = 0;
                            BufferedReader reader;
                            try {
                                reader = new BufferedReader(new FileReader("C:\\Users\\MehmetFatih\\Desktop\\MyJavaProjects\\OverHelloWorld\\src\\DataBase.txt"));
                                String line = reader.readLine();

                                while (line != null) {
                                    //System.out.println(line);   //Burada yazdırmak yerine eşleştirmeliyim
                                    String[] eslestirme = line.split(",");
                                    //System.out.println("Kullanıcı adı: " + eslestirme[0] + " -------- Şifre: " + eslestirme[1]);

                                    if (usernameinput.equals(eslestirme[0]) && passwordinput.equals(eslestirme[1])) {

                                        JOptionPane.showMessageDialog(jpanel, "Başarılı bir şekilde giriş yaptınız!");
                                        girisbasarili = 1;

                                    }

                                    line = reader.readLine();

                                }
                                reader.close();


                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }


                            if (girisbasarili == 0) {
                                JOptionPane.showMessageDialog(jpanel, "Girilen kullanıcı adı veya şifre hatalı!");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(jpanel, "Kullanıcı adında veya şifrede virgül bulunamaz!");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(jpanel, "Kullanıcı adın ve şifren 4 harften uzun olmalı!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(jpanel, "Kullanıcı adı ve şifre kısmını doldurmalısınız!");
                }

            }
        });
        kayitolmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String usernameinputsignup = kullaniciadiarayuz.getText();
                String passwordinputsignup = sifrearayuz.getText();

                int usernamekontrol = usernameinputsignup.indexOf(",");
                int passwordkontrol = passwordinputsignup.indexOf(",");

                int usernamekontroluzunluk = usernameinputsignup.length();
                int passwordkontroluzunluk = passwordinputsignup.length();


                int kaydauygun = 1;

                if (!usernameinputsignup.equals("") && !passwordinputsignup.equals("")) {

                    if (usernamekontroluzunluk>4 && passwordkontroluzunluk>4) {

                        if (usernamekontrol == -1 && passwordkontrol == -1) {


                            BufferedReader reader;
                            try {
                                reader = new BufferedReader(new FileReader("C:\\Users\\MehmetFatih\\Desktop\\MyJavaProjects\\OverHelloWorld\\src\\DataBase.txt"));
                                String line = reader.readLine();

                                while (line != null) {
                                    //System.out.println(line);   //Burada yazdırmak yerine eşleştirmeliyim
                                    String[] eslestirme = line.split(",");
                                    //System.out.println("Kullanıcı adı: " + eslestirme[0] + " -------- Şifre: " + eslestirme[1]);

                                    if (usernameinputsignup.equals(eslestirme[0])) {
                                        //JOptionPane.showMessageDialog(frame, "Bu kullanıcı adından zaten var!");
                                        kaydauygun = 0;

                                    }

                                    line = reader.readLine();

                                }
                                reader.close();


                            } catch (IOException exx) {
                                throw new RuntimeException(exx);
                            }


                            if (kaydauygun == 1) {

                                try {
                                    FileWriter writer = new FileWriter("C:\\Users\\MehmetFatih\\Desktop\\MyJavaProjects\\OverHelloWorld\\src\\DataBase.txt", true);
                                    writer.write(usernameinputsignup + "," + passwordinputsignup + "\n");
                                    writer.close();
                                    JOptionPane.showMessageDialog(jpanel, "Kayıt başarılı!");


                                } catch (IOException exx) {
                                    throw new RuntimeException(exx);
                                }

                            }
                            else {
                                JOptionPane.showMessageDialog(jpanel, "Bu kullanıcı adı daha önceden kullanılmıştır!");
                            }

                        }
                        else {
                            JOptionPane.showMessageDialog(jpanel, "Kullanıcı adında veya şifrede virgül bulunamaz");
                        }


                    }

                    else {
                        JOptionPane.showMessageDialog(jpanel, "Kullanıcı adın ve şifren 4 harften uzun olmalı!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(jpanel, "Kullanıcı adı ve şifre kısmını doldurmalısınız!");
                }

            }
        });
    }


}
