public class Action {
    int minutes;
    String action;

    Action(int min, String item){
        minutes = min;
        action = item;
    }

    void edit (int min){
        minutes = min;
    };

    public String toString (){
        return "( " + minutes  +" "+ action +" )";
    }

    
}
