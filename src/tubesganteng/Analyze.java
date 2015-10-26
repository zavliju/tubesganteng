package tubesganteng;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author risol_000
 */
public class Analyze {
    private String words;
    int pos;

    public Analyze(String words) {
        this.words = words + '#';
        pos = 0;
        initiate(this.words.charAt(pos));
    }
    
    private void initiate(char karakter) {
        pos++;
        if((karakter >= 65 && karakter <= 90) || (karakter >= 97 && karakter <= 122)) state1(words.charAt(pos));
        else if(karakter >= 42 && karakter <= 43 || karakter == 45 || karakter ==47) state2(words.charAt(pos));
        else if(karakter <= 57 && karakter >= 48) state3(words.charAt(pos));
        else if(karakter >= 40 || karakter <= 41) state4(words.charAt(pos));
        else if(karakter == 35) return;
    }

    private void state1(char karakter) {
        pos++;
        if(karakter >= 65 && karakter <= 90 || karakter >= 97 && karakter <= 122 || karakter <= 57 && karakter >= 48 || karakter == 95) state1(words.charAt(pos)); //A-Z a-z 0-9
        else{
            System.out.println(karakter + " = Operand");
            initiate(karakter);
        }
    }

    private void state2(char karakter) {
        pos++;
        System.out.println("Operator");
        initiate(karakter);
    }

    private void state3(char karakter) {
        pos++;
        if(karakter <= 57 && karakter >= 48) state3(words.charAt(pos));
        else if(karakter == 44) state5(words.charAt(pos));
        else{
            System.out.println("Integer");
            if(karakter == 35) return;
            else initiate(karakter);
        }
    }

    private void state4(char karakter) {
        pos++;
        System.out.println("Grouping Symbol");
    }

    private void state5(char karakter) {
        pos++;
        if(karakter <= 57 && karakter >= 48) state3(words.charAt(pos));
        else if(karakter == 35) return;
        else initiate(karakter);
    }
    
}
