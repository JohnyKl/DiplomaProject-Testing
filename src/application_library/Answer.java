package application_library;

import java.io.Serializable;

/**
 * Клас Answer призначений для зберігання 
 * текста відповіді та прапорця її вірності
 */
public class Answer implements Serializable{
    
    /**Конструктор класу
     * @param answer Стрічка з текстом варіанта відповіді
     */    
    public Answer(String answer){
        this.answer   = answer;
    }
    
    /**Конструктор класу
     * @param answer Стрічка з текстом варіанта відповіді
     * @param is_right Прапорець правильності відповіді
     */  
    public Answer(String answer, boolean is_right){
        this.answer   = answer;
        this.is_right = is_right;
    }
    /**@return Повертає текст варіанту відповіді
     */
    public String get_text(){
        return answer;
    }
    
    /**Метод, що оновлює значення тексту варіанту відповіді
     * @param text Новий текст варіанту відповіді
     */ 
    public void set_text(String text){
        answer = text;
    }
    
    /**Метод, що дозволяє позначити відповідь правильною
     */ 
    public void set_right(){
        is_right = true;
    }
    
    /**@return повертає значення прапорця правильності відповіді
     */ 
    public boolean is_right(){
        return is_right;
    }
    
    @Override
    public String toString(){
        String isRight = "Не вірна";
        
        if(this.is_right){
            isRight = "Вірна";
        }
            
        return answer + " - " + isRight;
    }
    
    /**Стрічка з текстом варіанта відповіді*/ 
    private String  answer;
    /**boolean-значення правильності відповіді,
     * що за замовчуванням встановлене у значення false
     */ 
    private boolean is_right = false;
}
