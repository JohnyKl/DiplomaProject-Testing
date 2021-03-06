/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application_window;

/**
 *
 * @author Lenka
 */
public class HelpWindowGraphicInterface extends javax.swing.JFrame {

    public static final int MAIN_WINDOW_MODE = 0;
    public static final int EDIT_WINDOW_MODE = 1;
    
    /**
     * Creates new form HelpWindowGraphicInterface
     */
    public HelpWindowGraphicInterface() {
        initComponents();
    }
    
    public void setMode(int mode){        
        if(mode == MAIN_WINDOW_MODE){
            jTextPane1.setText("<html><h1>Довідка</h1><ul>" +
                "<li>Меню->Відкрити – дозволяє відкрити файл тестів або "
                + "переглянути статистику користувача;</li>" +
                "<li>Меню->Почати заново – доступна лише під час тестування, "
                + "дозволяє розпочати тест заново без збереження даних;</li>" +
                "<li>Меню->Завершити тестування – доступна лише під час тестування,"
                + " дозволяє закінчити тестування передчасно зі збереженням "
                + "отриманих результатів та виведенням статистик користувача;</li>" +
                "<li>Меню->Вихід – вихід з програми без будь-якого збереження даних;</li>" +
                "<li>Вчителю->Додати тест – не доступна під час тестування, "
                + "дозволяє створити новий тест;</li>" +
                "<li>Вчителю->Редагувати – не доступна під час тестування, "
                + "дозволяє редагувати раніше створені тести;</li>" +
                "<li>Налаштування – дозволяє змінити зовнішній вигляд програми "
                + "та пароль для доступу до режиму редагування та створення тестів;</li>" +
                "<li>Допомога – дозволяє відкрити довідку для даної програми.</li>"
                + "</ul>" +
                "<p>Під час тестування користувач може обирати будь-яку кількість"
                + " варіантів відповідей, при цьому, навіть якщо він вибере усі "
                + "відповіді, серед яких, звичайно ж, опиниться і правильна, "
                + "питання зараховано не буде. Якщо користувач вибере, наприклад, "
                + "одну правильну відповідь, а для цього запитання є декілька "
                + "правильних варіантів відповіді, студенту буде зараховано "
                + "відповідний кількості правильних відповідей відсоток від "
                + "загальної кількості балів для цього питання. Проте це "
                + "нарахування балів відбудеться лише у тому випадку, якщо "
                + "користувач обрав таку саму кількість відповідей, як і "
                + "кількість правильних відповідей для цього питання. Таким "
                + "чином, виключається можливість обрання усіх відповідей і "
                + "через це отримання балів нібито за правильну відповідь.</p></html>");
        }
        else if(mode == EDIT_WINDOW_MODE){
            jTextPane1.setText("<html><h1>Довідка</h1>"
                    + "<p>Користувачу, який буде створювати чи редагувати тести,"
                    + " слід зосередити свою увагу на введення варіантів "
                    + "відповідей для кожного питання. Так як у текстовій "
                    + "панелі увесь текст можна редагувати, потрібно бути уважним, "
                    + "щоб не видалити випадково розділювальні вставки, які "
                    + "служать для коректного розділення суцільного тексту на "
                    + "питання. Також, не слід намагатись самостійно вписати "
                    + "розділювальний текст, для цього є спеціальна кнопка "
                    + "«Додати варіант відповіді». Якщо ж ви ненароком видалили "
                    + "таку вставку, можна просто скопіювати будь-яку іншу та "
                    + "вставити її у потрібне місце, не забуваючи виправити "
                    + "номер питання у вставці відповідно до формату. </p></html>");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Про програму");
        setMinimumSize(new java.awt.Dimension(500, 400));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(500, 400));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 400));

        jTextPane1.setEditable(false);
        jTextPane1.setContentType("text/html"); // NOI18N
        jTextPane1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextPane1.setMinimumSize(new java.awt.Dimension(500, 400));
        jTextPane1.setPreferredSize(new java.awt.Dimension(500, 400));
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
