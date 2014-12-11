package application_library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**Клас Question призначений для зберігання тексту питання, його вартості,
 * теми та індексу варіанту, до якого відноситься питання та списку
 * варіантів відповідей
 */ 
public class Question implements Serializable{
    /**Конструктор класу
     * @param question Стрічка з текстом питання
     */ 
    public Question(String question){
        this.theme = "";
        this.answers  = new ArrayList<>();
        this.question = question;
    }
    
    /**Конструктор класу
     * @param question Стрічка з текстом питання
     * @param cost     Кількість балів за правильну відповідь на питання
     */
    public Question(String question, float cost){
        this.theme = "";
        this.answers  = new ArrayList<>();
        this.question = question;
        this.cost     = cost;
    }
    
    /**Конструктор класу
     * @param question Стрічка з текстом питання
     * @param theme    Стрічка з назвою теми, до якої відноситься питання
     */
    public Question(String question, String theme){
        this.answers  = new ArrayList<>();
        this.question = question;
        this.theme    = theme;
    }
    
    /**Конструктор класу
     * @param question Стрічка з текстом питання
     * @param theme    Стрічка з назвою теми, до якої відноситься питання
     * @param variant  Номер варіанту, до якого відноситься питання
     */
    public Question(String question, String theme, int variant){
        this.answers     = new ArrayList<>();
        this.question    = question;
        this.theme       = theme;
        this.own_variant = variant;
    }
    
    /**Конструктор класу
     * @param question Стрічка з текстом питання
     * @param theme    Стрічка з назвою теми, до якої відноситься питання
     * @param variant  Номер варіанту, до якого відноситься питання
     * @param cost     Кількість балів за правильну відповідь на питання
     */
    public Question(String question, String theme, int variant, float cost){
        this.answers     = new ArrayList<>();
        this.question    = question;
        this.theme       = theme;
        this.own_variant = variant;
        this.cost        = cost;
    }
    /**@return Повертає текст питання
     */ 
    public String get_text(){
        return question;
    }
    
    /**Метод, що оновлює текст питання
     * @param text Стрічка з новим текстом питання
     */
    public void set_text(String text){
        question = text;
    }
    
    /**
     * @return Повертає назву теми, до якої відноситься питання
     */
    public String get_theme(){
        return theme;
    }
    
    /**Метод, що дозволя встановити тему, до якої відноситься питання
     * @param theme Стрічка з назвою теми
     */
    public void set_theme(String theme){
        this.theme = theme;
    }
    
    /**
     * @return Повертає кількість балів за правильну відповідь на питання
     */
    public float get_cost(){
        return cost;
    }
    
    /**Метод, що дозволяє встановити кількість балів за правильну відповідь
     * на питання
     * @param cost Кількість балів
     */
    public void set_cost(float cost){
        this.cost = cost;
    }
    
    /**
     * @return Повертає номер варіанту, до якого відноситься дане питання
     */
    public int get_own_variant(){
        return own_variant;
    }
    
    /**Метод дозволяє встановити номер варіанту для даного питання
     * @param variant_number Номер варіанту
     */
    public void set_own_variant(int variant_number){
        own_variant = variant_number;
    }
    
    /**
     * @return Повертає кількісь варіантів відповідей
     */
    public int get_number_of_answers(){
        return answers.size();
    }
    
    /**
     * @return Повертає кількісь правильних варіантів відповідей
     */
    public int get_number_of_right_answers(){
        int numberOfRightAnswers = 0;
        for(Answer answer : answers){
            if(answer.is_right()){
                numberOfRightAnswers++;
            }
        }
        return numberOfRightAnswers;
    }
    
    /**Повертає список варіантів відповідей
     * @return 
     */
    public ArrayList<Answer> get_answers_list(){
        return answers;
    }
    
    /**
     * @return Повертає правильний варіант відповіді, якщо такий лише один. 
     * Інакше - null
     */
    public Answer get_right_answer(){
        Answer rightAnswer = null;
        
        for(Answer answ : answers){
            if(get_number_of_right_answers() == 1){
                if(answ.is_right()){
                    rightAnswer = answ;
                }
            }
        }
        return rightAnswer;
    }
    
    /**Метод, що додає переданий варіант відповіді до списку відповідей
     * @param answer
     */
    public void add_answer(Answer answer){
        answers.add(answer);
    }
    
    /**Метод, що створює новий варіант відповіді та додає його до списку
     * варіантів відповідей. Відповідь за замовчуванням встановлюється як
     * неправильна
     * @param answer_text Тест відповіді
     */
    public void add_answer(String answer_text){
        this.add_answer(answer_text, false);
    }
    
    /**Метод, що створює новий варіант відповіді та додає його до списку 
     * відповідей
     * @param answer_text Текст відповіді
     * @param is_right Прапорець правильності
     */
    public void add_answer(String answer_text, boolean is_right){
        answers.add(new Answer(answer_text, is_right));
    }
    
    /**Метод, що створює одразу декілька варіантів відповідей з переданого 
     * масиву текстів відповідей та додає їх у список відповідей
     * @param answers_text Масив з текстами варіантів відповідей
     */
    public void add_answers(String[] answers_text){
        for (String answer : answers_text) {
            this.add_answer(answer, false);
        }
    }
    
    /**Метод, що створює одразу декілька варіантів відповідей з переданого 
     * масиву текстів відповідей, встановлює за переданим індексом правильну 
     * відповідь та додає їх у список відповідей
     * @param answers_text Масив з текстами варіантів відповідей
     * @param index_of_right_answer Індекс правильної відповіді у масиві текстів
     */
    public void add_answers(String[] answers_text, int[] index_of_right_answer){
        for (String answers_text1 : answers_text) {
            this.add_answer(answers_text1);
        }
        
        for (int i : index_of_right_answer){
            answers.get(i).set_right();
        }
    } 
    
    @Override
    public String toString(){
        String questionString = "Питання: " + this.question;
        String answersString  = "";
        
        for(int i = 0; i < answers.size(); i++){
            answersString += "\nВаріант відповіді " + Integer.toString(i) + ":" +
                    answers.get(i).toString();
        }
        
        return questionString + answersString;
    }
    
    /**Метод перевірки наявності правильної відповіді серед списку варіантів
     * відповідей
     * @return Повертає false, якщо не знайдено ні однієї правильної відповіді
     * в списку варіантів відповідей
     */
    public boolean is_there_right_answer(){        
        boolean result = false;
        
        int i = 0;
        
        while(i < answers.size() && !result){
            result = answers.get(i).is_right();
            
            i++;
        }
        
        return result;
    }
    
    /**Метод, що змішує порядок варіантів відповідей у списку*/
    public void swap_answers(){
        ArrayList<Answer> list = new ArrayList<>();
                
        int indexes[] = generate_unique_numbers(answers.size());
        
        for(int i = 0; i < indexes.length; i++){
            list.add(answers.get(indexes[i]));
        }
        
        answers = list;
    }
    
    /**Метод, що генерує унікальні числа в заданих межах
     * @param count Кількість випадкових унікальних чисел
     */
    private int[] generate_unique_numbers(int count){
        int indexes[] = new int[count];
        
        for(int i = 0; i < count; i++){
            boolean is_add = false;
            
            while(!is_add){
                int rand_value = Math.abs(random.nextInt(count));
                
                is_add = is_unique_int(indexes, rand_value, i);
                if (is_add){
                    indexes[i] = rand_value;
                }
            }
        }
        
        return indexes;
    }
    
    /**Метод, що перевіряє на унікальність випадково обраного числа
     * @param array Масив з уже відібраними унікальними випадковими числами
     * @param n     Нове число
     */
    private boolean is_unique_int(int[] array, int n, int currIndex){
        boolean result = true;            
        
        int i = 0;
        
        while(i < currIndex && result){
            result = array[i] != n;
            //System.out.println(result);
            i++;
        }
        
        return result;
    }
    
    /**Стрічка з текстом питання */
    private String question;
    /**Стрічка з назвою теми, до якої відноситься питання */
    private String theme;
    /**Номер варіанту, до якого відноситься питання, за замовчуванням 
     * встановлено в 0(питання не відноситься до жодного варіанту)*/
    private int    own_variant = 0;    
    /**Кількість балів, які студент отримає за правильну відповідь на дане
     * питання. За замовчуванням встановлюється в 0, проте це поле обов'язково
     * змінюється при створенні об'єкту класу. 
     */
    private float  cost        = 0;
    /**Список відповідей на питання */
    private ArrayList<Answer> answers;
    
    /**Генератор випадкових чисел*/
    private static Random random = new Random();
}
