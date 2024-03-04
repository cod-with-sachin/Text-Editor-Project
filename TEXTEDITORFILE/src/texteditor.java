import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class texteditor implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JMenu file = new JMenu("file"),edit = new JMenu("Edit");
    JMenuItem newFile,openFile,saveFile;

    JMenuItem cut,copy,paste,selectall,close;

    JTextArea textarea = new JTextArea();
        texteditor(){
frame=new JFrame();


            menuBar=new JMenuBar();

            newFile=new JMenuItem("New Window");
openFile=new JMenuItem("Open File");
saveFile=new JMenuItem("Save File");

cut=new JMenuItem("Cut");
copy=new JMenuItem("Copy");
paste=new JMenuItem("Paste");
selectall=new JMenuItem("Select All");
close=new JMenuItem("Close");
newFile.addActionListener(this);
openFile.addActionListener(this);
saveFile.addActionListener(this);
cut.addActionListener(this);
copy.addActionListener(this);
paste.addActionListener(this);
selectall.addActionListener(this);
close.addActionListener(this);

edit.add(cut);
edit.add(copy);
edit.add(paste);
edit.add(selectall);
edit.add(close);


file.add(newFile);
file.add(openFile);
file.add(saveFile);


menuBar.add(file);
menuBar.add(edit);
frame.setJMenuBar(menuBar);
frame.add(textarea);
frame.setBounds(0,0,400,400);
frame.setVisible(true);
frame.setLayout(null);

        }
        public void actionPerformed (ActionEvent actionEvent){
           if(actionEvent.getSource()==cut){
               textarea.cut();
           }
            if(actionEvent.getSource()==copy){
                textarea.copy();
            }

            if(actionEvent.getSource()==paste){
                textarea.paste();
            }
            if(actionEvent.getSource()==selectall){
                textarea.selectAll();
            }
            if(actionEvent.getSource()==close){
                System.exit(0);
            }
            if(actionEvent.getSource()==openFile){
                JFileChooser fileChooser=new JFileChooser("C:");
                int chooseOption=fileChooser.showOpenDialog(null);
if(chooseOption==JFileChooser.APPROVE_OPTION){
    File file=fileChooser.getSelectedFile();
    String filePath=file.getPath();
    try {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String intermediate = "";
        String output = "";
        while ((intermediate = bufferedReader.readLine()) != null) {
            output += intermediate + "\n";
            textarea.setText(output);
        }
    }catch(IOException fileNotFoundException){
            fileNotFoundException.printStackTrace();

    }
}
            }
            if(actionEvent.getSource()==saveFile){
                JFileChooser fileChooser=new JFileChooser("C:");
                int chooseOption =fileChooser.showSaveDialog(null);
                if(chooseOption==JFileChooser.APPROVE_OPTION){
                    File file=new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                    try{
                        FileWriter fileWriter=new FileWriter(file);
                        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                        textarea.write(bufferedWriter);
                        bufferedWriter.close();
                    }
                    catch (IOException ioException){
                        ioException.printStackTrace();
                    }
                }
            }
            if(actionEvent.getSource()==newFile){
                texteditor newtexteditor=new texteditor();
            }

        }
        public static void main(String[] args) {

            texteditor texteditor=new texteditor();
    }
}