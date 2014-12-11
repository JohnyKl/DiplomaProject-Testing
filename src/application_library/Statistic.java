package application_library;

import java.awt.Color;
import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Statistic implements Serializable{
    public Statistic(){
        this.delivery_questions = new ArrayList<>();
        this.response_times     = new ArrayList<>();
        this.selected_answers   = new ArrayList<>();
        this.group              = "";
        this.full_name          = "";
        this.userInfo           = "";
        this.filter             = "";
        this.testName           = "";
        this.attemptNumber      = 0;
        this.resultScore        = 0;
        this.score              = 0;
    }
    
    public void setName(String fullName){
        this.full_name = fullName;
    }
    
    public void setGroup(String group){
        this.group = group;
    }
    
    public void setFilter(String filter){
        this.filter = filter;
    }
    
    public String getStudentInfo(){
        return full_name + group;
    }
    
    public void setTestName(String testName){
        this.testName = testName;
    }
    
    public void set_questions(ArrayList<Question> list){
        delivery_questions.addAll(list);
    }
    
    public void set_question(Question question){
        delivery_questions.add(question);
    }
    
    public void set_response_time(ArrayList<Long> list){
        response_times = list;
    }
    
    public void set_response_time(long time){
        response_times.add(time);
    }
    
    public void set_selected_answers(ArrayList<ArrayList<Answer>> list){
        selected_answers = list;
    }
    
    public void setAttemptNumber(int attemptNumber){
        this.attemptNumber = attemptNumber;
    }
    
    private void createTable(JTable table, JTextPane textPane){
        int questionNumber = delivery_questions.size(); 
        System.out.println("Delivery question size is " + Integer.toString(questionNumber));
        
        DefaultTableModel model      = (DefaultTableModel) table.getModel();
        TableColumnModel columnModel = table.getColumnModel();
  
        for(int i = 0; i < questionNumber; i++){
            model.insertRow(i,new Object[]{i + 1,isRightAnswers(i),
                            formatTime(response_times.get(i)),
                            delivery_questions.get(i).get_cost()});
            System.out.println("Add row " + Integer.toString(i));            
        }        
        columnModel.getColumn(1).setCellRenderer(new ColorTableCellRenderer());
        
        addSelectionListener(table, textPane);
                
        calculateResultScore();
        createUserInfoText();
        
        textPane.setText(userInfo);
    }
    
    public void drawShortStatistic(JTable table, JTextPane textPane){
        if(isEmpty){
            createTable(table, textPane);
            isEmpty = false;
        }
    }
    
    private void addSelectionListener(final JTable table, final JTextPane textPane){        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = 0;
                try{
                    index = (int) table.getValueAt(table.getSelectedRow(),0);
                }
                catch(NullPointerException ex){
                    index = -1;
                }
                finally{
                    drawDetailInfo((index - 1), textPane);
                }
                
            }
        });
    }
    
    private void createUserInfoText(){
        String htmlTegOpen    = "<html>";
        
        userInfo = htmlTegOpen + "<br><h1>Назва тесту: </h1>" + testName +
                "<br><b>Прізвище та ім'я студента: </b>" +full_name +
                "<br><b>Група: </b>" + group + "<br><b>Кількість спроб проходження тесту: </b>" +
                Integer.toString(attemptNumber) + "<br><b>Загальна кількість питань: </b>" +
                Integer.toString(delivery_questions.size()) + "<br><b>Кількість набраних балів: </b>" +
                Float.toString(resultScore) + "<br><b>Фільтр: </b>" + filter + 
                "<br><b>_______________________________________________________________________</b><br>";
        
    }
    
    private void drawDetailInfo(int index, JTextPane textPane){
        String htmlTegClose   = "</html>";
        
        if(index == -2){
            textPane.setText(userInfo + "Виділено пустий рядок!" + htmlTegClose);
        }
        else{
            String question;
            String rightAnswer;
            String selectedAnswer = "<p><i>Обрана відповідь: </i></p>";

            String rightAnswerSuffix = "Обрано правильну відповідь: ";

            question = "<p><b>Варіант: " + 
                       Integer.toString(delivery_questions.get(index).get_own_variant()) +
                       "<br>Тема: " + delivery_questions.get(index).get_theme() + 
                       "<br>" + Integer.toString(index + 1) +  
                       delivery_questions.get(index).get_text() + "</b></p>";

            for(Answer answ : selected_answers.get(index)){
                if(!answ.is_right()){
                    rightAnswerSuffix = "Правильна відповідь: ";

                    selectedAnswer += "<i>" + answ.get_text() + "</i>";
                }
                else{
                    selectedAnswer = "";
                }
            }

            rightAnswer = "<p>" + rightAnswerSuffix + "</p>" + 
                          delivery_questions.get(index).get_right_answer().get_text();


            textPane.setText(userInfo + question + rightAnswer + selectedAnswer + htmlTegClose);
        }
    }
        
    private String isRightAnswers(int index){
        String  result = "-";
        
        ArrayList<Answer> answ = selected_answers.get(index);
        
        int numberOfRightAnswer = delivery_questions.get(index).get_number_of_right_answers();
        
        for(Answer answer : answ){
            if(answer.is_right() && numberOfRightAnswer > 0){
                result = "+";
                
                numberOfRightAnswer--;
                
                score += delivery_questions.get(index).get_cost();
                System.out.println(score);
            }
        }
        
        if(numberOfRightAnswer > 0){
            result = "-";
        }
              
        return result;
    }
    
    private String formatTime(long time){
        int minutes = (int) (time/1000)/60%60;
        int seconds = (int) time/1000 % 60;
        
        return String.format("%02d:%02d",minutes, seconds);   
    }
    
    public class ColorTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if("+".equals((String)value)){
                setBackground(Color.GREEN);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
            
            else{
                setBackground(Color.RED);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
            return this;
        }
    }   
    
    static public void saveStatistic(Statistic stat, String path){
        FileOutputStream   fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(stat);
            oos.flush();
            oos.close();   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static public Statistic loadStatistic(String path){
        FileInputStream   fis;
        ObjectInputStream oin;
        
        Statistic stat;
        
        try {
            fis = new FileInputStream(path);
            oin = new ObjectInputStream(fis);
            
            stat = (Statistic) oin.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
            
            stat = new Statistic();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
            
            stat = new Statistic();
        }
        
        return stat;
    }
    
    private void calculateResultScore(){
        float fullScore = 0;
        
        for(Question quest : delivery_questions){
            fullScore += quest.get_cost();
        }
        
        if(fullScore > 0){                    
            resultScore = (5*score)/fullScore;  
            
            System.out.println(resultScore);
        }
    }
    
    private boolean isEmpty = true;
    
    private ArrayList<Question> delivery_questions;
    private ArrayList<Long>     response_times;
    
    private ArrayList<ArrayList<Answer>> selected_answers;  
    
    private String full_name;    
    private String group;
    private String userInfo;
    private String filter;
    private String testName;
    private int    attemptNumber;
    private float  resultScore;
    private float  score;
}
