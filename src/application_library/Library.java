package application_library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Клас Library призначений для зберігання усіх ГОТОВИХ питань та їх варіантів
 * відповідей для цього тесту та роботи з ними
 */
public class Library implements Serializable{
    /**Конструктор класу, що ініціалізує список питань*/
    public Library(){
        themes    = new ArrayList<>();
        variants  = new ArrayList<>();
        questions = new ArrayList<>();
        
        this.test_name = "Тест без назви";        
    }
    
    /**Конструктор класу, що додає нове питання в список питань бібліотеки
     * @param question Нове питання
     */
    public Library(Question question){
        this.test_name = "Тест без назви";
        questions = new ArrayList<>();
        
        themes    = new ArrayList<>();
        variants  = new ArrayList<>();
        
        questions.add(question);
    }
    
    /**Конструктор класу, що додає нове питання в список питань бібліотеки
     * @param questions Додає список питань
     */
    public Library(ArrayList<Question> questions){
        this.test_name = "Тест без назви";
        this.questions = questions;
        
        themes    = new ArrayList<>();
        variants  = new ArrayList<>();
    }
       
    /**Метод, що додає питання до бібліотеки
     * @param question Нове питання для бібліотеки
     */
    public void addQuestion(Question question){
        if(questions == null){
            questions = new ArrayList<>();
            questions.add(question);
        }
        
        questions.add(question);
    }
    
    /**
     * @return Метод, що повертає назву даного тесту
     */
    public String get_test_name(){
        return test_name;
    }
    
    /**Метод, за допомогою якого можна встановити назву для тесту
     * @param test_name Стрічка з назвою тесту
     */
    public void set_test_name(String test_name){
        this.test_name = test_name;
    }
    
    /**Статичний метод, що серіалізує (зберігає у вигляді бітів об'єкт класу) 
     * бібліотеку 
     * @param lib Об'єкт класу Library, який потрібно серіалізувати
     * @param path Шлях з розташуванням та іменем файлу, в який буде 
     * серіалізовано об'єкт
     */
    static public void save_library(Library lib, String path){
        lib.setPath(path);
        
        FileOutputStream   fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(lib);
            oos.flush();
            oos.close();   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**Статичний метод, що завантажує серіалізований об'єкт класу Library
     * (виконує десеріалізацію)
     * @param path Шлях до файлу з серіалізованим об'єктом
     * @return Повертає десеріалізований об'єкт класу Library
     */
    static public Library load_library(String path){
        FileInputStream   fis;
        ObjectInputStream oin;
        
        Library lib = new Library();
        
        try {
            fis = new FileInputStream(path);
            oin = new ObjectInputStream(fis);
            
            lib = (Library) oin.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lib;
    }
    
    /**
     * @return Повертає кількість питань у бібліотеці
     */
    public int get_questions_count(){
        return questions.size();
    }
    
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    
    public ArrayList<String> getThemes(){
        return themes;
    }
    
    public ArrayList<Integer> getVariants(){
        return variants;
    }
    
    public void updateQuestions(ArrayList<Question> questions){
        this.questions = questions;
        updateThemes();
        updateVariants();
    }
    
    private void updateThemes(){
        for(Question quest : questions){
            String theme = quest.get_theme();
            
            if(!themes.contains(theme)){
                themes.add(theme);
            }            
        }
    }
    
    private void updateVariants(){
        for(Question quest : questions){
            int variant = quest.get_own_variant();
            
            if(!variants.contains(variant)){
                variants.add(variant);
            }            
        }
    }
    
    /**Функція, що повертає питання за індексом
     * @param index Індекс питання у списку
     * @return Повертає питання за індексом
     */
    public Question get_question(int index){
        return questions.get(index);
    }
    
    /**
     * @param variant_number Номер варіанту
     * @return Повертає список усіх питань, що відносятся до заданого варіанту
     */
    public ArrayList<Question> get_question_of_variant(int variant_number){
        ArrayList<Question> list = new ArrayList<>();
        
        for(Question question : questions){
            if (question.get_own_variant() == variant_number){
                list.add(question);
            }
        }
        
        return list;
    }
    
    /**
     * @param theme Стрічка з назвою теми, до якої повинні відноситись питання
     * @return Повертає список питань, які відносяться до заданої теми
     */
    public ArrayList<Question> get_question_of_theme(String theme){
        ArrayList<Question> list = new ArrayList<>();
        
        for(Question question : questions){
            if (question.get_theme().equals(theme)){
                list.add(question);
            }
        }
        
        return list;
    }
    
    /**Метод, задопомогою якого можна отримати питання, кількість варіантів
     * відповідей на які знаходиться в певних межах
     * @param min_count Мінімальна кількість варіантів відповідей
     * @param max_count Максимальна кількість варіантів відповідей
     * @return Повертає список питань, до яокго увійшли усі питання з бібліотеки,
     * що мають кількість варіантів відповідей у заданих межах
     */
    public ArrayList<Question> get_question_with_answer_count(int min_count, int max_count){
        ArrayList<Question> list = new ArrayList<>();
        
        for(Question question : questions){
            int count = question.get_number_of_answers();
            if ( count > min_count && count < max_count){
                list.add(question);
            }
        }
        
        return list;
    }
    
    /**Метод, що повертає список випадковим чином відібраних питань з бібліотеки
     * @param  question_count Кількість питань, які потрібно відібрати
     * @return Повертає список випадкових питань
     */
    public ArrayList<Question> get_random_questions(int question_count){
        ArrayList<Question> list = new ArrayList<>();
        
        int indexes[]    = generate_unique_numbers(question_count);
        
        for(int i : indexes){
            list.add(questions.get(i));
        }
        
        return list;
    }
    
    /**Метод, що генерує унікальні числа в заданих межах
     * @param count Кількість випадкових унікальних чисел
     */
    private int[] generate_unique_numbers(int count){
        int indexes[] = new int[count];
        
        for(int i = 0; i < count; i++){
            boolean is_add = false;
            
            while(!is_add){
                int rand_value = Math.abs(random.nextInt(questions.size()));
                
                is_add = is_unique_int(indexes, rand_value);
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
    private boolean is_unique_int(int[] array, int n){
        boolean result = true;
        
        int i = 0;
        
        while(i < array.length && result){
            result = array[i] != n;
            
            i++;
        }
        
        return result;
    }
    
    public void setPath(String path){
        pathToSave = path;
    }
    
    public String getPath(){
        return pathToSave;
    }
    
    public void setRandomVariants(){
        for(Question q : questions){
            q.set_own_variant(random.nextInt(6)+1);
        }
    }
    
    private ArrayList<String>  themes;
    private ArrayList<Integer> variants;
    
    /**Шлях до збереженого файлу*/
    private String pathToSave = "";            
    /**Список питань даного тесту*/
    private ArrayList<Question> questions; 
    /**Назва даного тесту*/
    private String test_name;
    /**Генератор випадкових чисел*/
    private static Random random = new Random();
}
