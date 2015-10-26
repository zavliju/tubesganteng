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
        initiate(pos);
    }
    
    private void initiate(int pos) {
        char karakter = words.charAt(pos);
        if((karakter >= 65 && karakter <= 90) || (karakter >= 97 && karakter <= 122)) state1(++pos); // huruf
        else if(karakter >= 42 && karakter <= 43 || karakter == 45 || karakter ==47) state2(++pos); // operator +-*/
        else if(karakter <= 57 && karakter >= 48) state3(++pos); // digit
        else if(karakter == 40 || karakter == 41) state4(++pos); // grouping symbol
        else if(karakter == 35) return;
    }

    private void state1(int pos) { //state huruf
        char karakter = words.charAt(pos);
        if(karakter >= 65 && karakter <= 90 || karakter >= 97 && karakter <= 122 || karakter <= 57 && karakter >= 48 || karakter == 95) state1(++pos); //A-Z a-z 0-9 _
        else{
            System.out.println(" Operand");
            initiate(pos);
        }
    }

    private void state2(int pos) { // state operator
        System.out.println("Operator");
        initiate(pos);
    }

    private void state3(int pos) { // state digit loop ke digit
        char karakter = words.charAt(pos);
        if(karakter <= 57 && karakter >= 48) state3(++pos);
        else if(karakter == 44) state5(++pos);
        else if(karakter == 69) state7(++pos);
        else{
            System.out.println("Operand");
            initiate(pos);
        }
    }

    private void state4(int pos) { // state grouping symbol
        System.out.println("Grouping Symbol");
        initiate(pos);
    }

    private void state5(int pos) { // state koma (,)
        char karakter = words.charAt(pos);
        if(karakter <= 57 && karakter >= 48) state6(++pos); // digit
        else return;
    }
    private void state6(int pos){ // state digit dari koma
        char karakter = words.charAt(pos);
        if(karakter <= 57 && karakter >= 48) state6(++pos); // digit
        else if(karakter == 69) state7(++pos);
        else{
            System.out.println("Operand");
            initiate(pos);
        }
    }

    private void state7(int pos) { // state E dari state6
        char karakter = words.charAt(pos);
        if(karakter <= 57 && karakter >= 48) state6(++pos); // digit
        else if(karakter == 43 || karakter == 45) state8(++pos);
        else return;
    }

    private void state8(int pos) { // state terakhir dari +-
        char karakter = words.charAt(pos);
        if(karakter <= 57 && karakter >= 48) state6(++pos); // digit
        else return;
    }
}
