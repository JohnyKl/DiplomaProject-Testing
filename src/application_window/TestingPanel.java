/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_window;

import application_library.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Lenka
 */
public class TestingPanel extends javax.swing.JPanel {

    /**
     * Creates new form TestingPanel
     */
    public TestingPanel() {
        this(new ArrayList<Question>(), new Statistic());
    }

    public TestingPanel(ArrayList<Question> questions, Statistic statistic) {
        initComponents();

        setQuestions(questions);

        selectedAnswers = new ArrayList<>();
        answersTimeMilisec = new ArrayList<>();
        modelAnswers = new DefaultListModel<>();
        this.statistic = statistic;

        jList_Answers.setLayoutOrientation(JList.VERTICAL_WRAP);
        jList_Answers.setModel(modelAnswers);
    }

    public void setStatisticTableAndPane(JTable table, JTextPane pane, JFrame frame) {
        this.statisticTable = table;
        this.statisticPane = pane;
        this.statisticFrame = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_Timer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane_Question = new javax.swing.JScrollPane();
        jL_Question = new javax.swing.JLabel();
        jScrollPane_Answers = new javax.swing.JScrollPane();
        jList_Answers = new javax.swing.JList();
        jButton_Before = new javax.swing.JButton();
        jButton_Next = new javax.swing.JButton();
        jL_UserInfo = new javax.swing.JLabel();
        jL_QuestionCount = new javax.swing.JLabel();
        jL_Theme = new javax.swing.JLabel();
        jL_Variant = new javax.swing.JLabel();

        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(780, 460));
        setPreferredSize(new java.awt.Dimension(780, 460));

        jL_Timer.setBackground(java.awt.SystemColor.text);
        jL_Timer.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jL_Timer.setForeground(new java.awt.Color(204, 0, 0));
        jL_Timer.setText("45:00");
        jL_Timer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jL_Timer.setName("jL_Timer"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("1)");

        jL_Question.setBackground(new java.awt.Color(255, 255, 255));
        jL_Question.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jL_Question.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jL_Question.setText("<html>Тут має бути текст запитання  <br><br><br><br><br><br><br>Scroll</html>\n");
        jL_Question.setAutoscrolls(true);
        jL_Question.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane_Question.setViewportView(jL_Question);

        jList_Answers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList_Answers.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jList_Answers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "qwerty1 qwerty2 qwerty3 qwerty4 qwerty5 qwerty6 qwerty7 qwerty8 qwerty9 qwerty10\\n qwerty11 qwerty12 qwerty13 qwerty14 qwerty15 qwerty16 qwerty17 qwerty18 qwerty19 qwerty20 qwerty21 qwerty22 qwerty23 qwerty24 qwerty25", "2", "2" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList_Answers.setSelectionBackground(new java.awt.Color(255, 255, 153));
        jList_Answers.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jList_Answers.setVisibleRowCount(-1);
        jScrollPane_Answers.setViewportView(jList_Answers);

        jButton_Before.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton_Before.setForeground(new java.awt.Color(0, 153, 153));
        jButton_Before.setText("Попереднє питання");
        jButton_Before.setEnabled(false);
        jButton_Before.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_BeforeMouseClicked(evt);
            }
        });

        jButton_Next.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton_Next.setForeground(new java.awt.Color(0, 153, 153));
        jButton_Next.setText("Наступне питання");
        jButton_Next.setEnabled(false);
        jButton_Next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NextMouseClicked(evt);
            }
        });

        jL_UserInfo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_UserInfo.setText("Студент: Закернична Олена, 4ОК1");

        jL_QuestionCount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_QuestionCount.setText("Питання: 10/50");

        jL_Theme.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_Theme.setText("Тема: Тема, до якої відноситься питання");

        jL_Variant.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_Variant.setText("Варіант: 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_Answers)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane_Question)
                        .addGap(10, 10, 10)
                        .addComponent(jL_Timer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jL_Theme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jL_Variant))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jL_UserInfo)
                        .addGap(18, 18, 18)
                        .addComponent(jL_QuestionCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(jButton_Before)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Next)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Theme)
                    .addComponent(jL_Variant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jL_Timer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane_Question, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_Answers, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Next)
                    .addComponent(jButton_Before)
                    .addComponent(jL_QuestionCount)
                    .addComponent(jL_UserInfo))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void startTest() {
        minutes = (int) (questions.size() * 54) / 60;
        timeout = minutes;

        answersTimeMilisec.add(System.currentTimeMillis());

        initTimer();

        isTesting = true;
    }

    public void restartTest() {
        isTesting = true;

        attemptCounter++;

        questionCounter = 0;

        selectedAnswers.clear();
        answersTimeMilisec.clear();

        minutes = timeout;
        seconds = 59;

        startTest();
        redrawPanel();
    }

    private void initSelectedAnswersList(int size) {
        for (int i = 0; i < size; i++) {
            selectedAnswers.add(i, new ArrayList<Answer>());
        }
    }

    private void jButton_BeforeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_BeforeMouseClicked
        questionCounter--;

        addTimes();

        if (questionCounter == 0) {
            jButton_Before.setEnabled(false);
        }

        for (int i = 0; i < selectedAnswers.get(questionCounter).size(); i++) {
            selectedAnswers.get(questionCounter).remove(i);
        }

        redrawPanel();

        jButton_Next.setText("Наступне питання");
        jButton_Next.setEnabled(false);
    }//GEN-LAST:event_jButton_BeforeMouseClicked

    private void jButton_NextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_NextMouseClicked
        addTimes();

        ArrayList<Answer> answers = questions.get(questionCounter).get_answers_list();
        ArrayList<String> stringAnswers = (ArrayList<String>) jList_Answers.getSelectedValuesList();

        for (String answerText : stringAnswers) {
            String clearText = clearAnswerText(answerText);

            for (Answer answ : answers) {
                if (clearText.equals(answ.get_text())) {

                    selectedAnswers.get(questionCounter).add(answ);
                }
            }
        }

        int size = questions.size();

        jButton_Before.setEnabled(true);

        if (questionCounter == size - 1) {
            showResults();
        } else {
            if (questionCounter == size - 2) {
                jButton_Next.setText("Завершити тестування");
            }

            questionCounter++;
            redrawPanel();
        }
        jButton_Next.setEnabled(false);
    }//GEN-LAST:event_jButton_NextMouseClicked

    private void addTimes() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - answersTimeMilisec.get(questionCounter);

        answersTimeMilisec.remove(questionCounter);
        answersTimeMilisec.add(questionCounter, elapsedTime);
        answersTimeMilisec.add(questionCounter + 1, currentTime);

    }

    public void setTimeOut(int minutes) {
        this.minutes = minutes;
        timeout = minutes;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;

        int size = this.questions.size();

        if (size > 0) {
            initSelectedAnswersList(size);
        }

        System.out.println(this.questions.size());
    }

    public void redrawPanel() {
        setActuallyQuestionText(questionCounter);
        drawAnswersList();

        if (questions.size() == 1) {
            jButton_Next.setText("Завершити тестування");
        }
    }

    public void setStatistic(Statistic stat) {
        statistic = stat;
    }

    private void setActuallyQuestionText(int index) {
        Question q = questions.get(index);

        jLabel1.setText(Integer.toString(index + 1) + ")");
        jL_Question.setText(q.get_text());
        jL_Theme.setText("Тема: " + q.get_theme());
        jL_Variant.setText("Варіант: " + Integer.toString(q.get_own_variant()));
        jL_QuestionCount.setText("Питання: " + Integer.toString(index + 1) + "/" + Integer.toString(questions.size()));
    }

    private void drawAnswersList() {
        modelAnswers.removeAllElements();

        Question currentQuestion = questions.get(questionCounter);

        currentQuestion.swap_answers();

        ArrayList<Answer> answers = currentQuestion.get_answers_list();

        for (int i = 0; i < answers.size(); i++) {
            String numberedText = addNumberToAnswerText(answers.get(i).get_text(), i);

            modelAnswers.addElement(numberedText);
        }

        addselectionListener();
    }

    private void addselectionListener() {
        jList_Answers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                jButton_Next.setEnabled(true);
            }
        });
    }

    private String addNumberToAnswerText(String answer, int index) {
        String number = "<html>" + String.valueOf((char) ((int) 'a' + index)) + ") ";

        return number + answer + "</html>";
    }

    private String clearAnswerText(String answer) {

        return answer.substring(9, answer.length() - 7);
    }

    private void initTimer() {
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds > 0) {
                    seconds--;
                } else {
                    if (minutes > 0) {
                        minutes--;

                        seconds = 59;
                    } else {
                        timer.stop();

                        finishByTimeout();
                    }
                }
                formatTimerString();
            }
        });

        timer.start();
    }

    private void formatTimerString() {
        jL_Timer.setText(String.format("%02d:%02d", minutes, seconds));
    }

    public void finishByTimeout() {
        for (int i = questionCounter; i < questions.size(); i++) {
            answersTimeMilisec.add(i, 0l);
            selectedAnswers.get(i).add(new Answer("Відповідь не обрана через "
                    + "закінчення часу, відведеного на тестування"));
        }

        showResults();

        isTesting = false;
    }

    private void showResults() {
        statistic.set_selected_answers(selectedAnswers);
        statistic.set_response_time(answersTimeMilisec);
        statistic.setAttemptNumber(attemptCounter);

        statistic.drawShortStatistic(statisticTable, statisticPane);

        statisticFrame.setVisible(true);

        this.setEnabled(false);
        this.setVisible(false);

    }

    private ArrayList<Question> questions;
    private ArrayList<ArrayList<Answer>> selectedAnswers;
    private ArrayList<Long> answersTimeMilisec;

    private DefaultListModel<String> modelAnswers;

    private Statistic statistic;

    private int questionCounter = 0;

    private Timer timer;
    private int minutes = 44;
    private int seconds = 59;

    private int timeout = minutes;

    private JTable statisticTable;
    private JTextPane statisticPane;
    private JFrame statisticFrame;

    private static int attemptCounter = 1;

    public boolean isTesting = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Before;
    private javax.swing.JButton jButton_Next;
    private javax.swing.JLabel jL_Question;
    private javax.swing.JLabel jL_QuestionCount;
    private javax.swing.JLabel jL_Theme;
    private javax.swing.JLabel jL_Timer;
    private javax.swing.JLabel jL_UserInfo;
    private javax.swing.JLabel jL_Variant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList_Answers;
    private javax.swing.JScrollPane jScrollPane_Answers;
    private javax.swing.JScrollPane jScrollPane_Question;
    // End of variables declaration//GEN-END:variables
}
