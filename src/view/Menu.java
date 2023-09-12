/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import common.Library;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> choose;
    Library l = new Library();

    public Menu() {
        choose = new ArrayList<>();
    }

    public Menu(String td, String[] mc) {
        title = td;
        choose = new ArrayList<>();
        for (String s : mc) {
            choose.add((T) s);
        }  
    }
    
    public void display() {
        System.out.println(title);
        System.out.println("--------------------------------");
        for (int i = 0; i < choose.size(); i++) {
            System.out.println((i + 1) + "." + choose.get(i));
        }
        System.out.println("--------------------------------");
    }
    
     public int getSelected() {
        display();
        return l.getInt("Enter your choice", 1, choose.size() + 1);
    }
     
     public abstract void execute(int n);
     
    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > choose.size()) {
                break;
            }
        }
    }

}
