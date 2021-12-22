package Threads;

import Beans.Memo;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MenuThread implements Runnable {
  private  boolean running =true;
    private  ArrayList<Memo> memos;

    public boolean isRunning() {
        return running;
    }

    Scanner input = new Scanner(System.in);

    public MenuThread(ArrayList<Memo> memos) {
        this.memos=memos;
    }

    @Override
    public void run() {
        while (running) {
            int choice;
            System.out.println("Hello User! What would you like to do?");
            System.out.println("-----------------");
            System.out.println("add a new memo-------> 1");
            System.out.println("show current memos-------> 2");
            System.out.println("End program-------> 3");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    memos.add(addMemo());
                    break;
                case 2:
                    showAllMemos();
                    break;

                case 3:
                    System.exit(2000);
            }
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        }
    }

    private void stopProgram() {
        running=false;
    }
private void showAllMemos() {
        for (Memo memo: memos){
            System.out.println(memo.toString());
        }
}
    private Memo addMemo() {
        boolean important=false;
        System.out.println("Please write the Memo description");
        input.nextLine();
        String describe = input.nextLine();
        System.out.println("Is the Memo important Y/N");
        char importChar = input.next().charAt(0);
        if (importChar == 'Y' || importChar == 'y') {
             important = true;
        }
        System.out.println("enter a day of month:");
        int day = input.nextInt();
        System.out.println("enter month:");
        int month = input.nextInt();
        System.out.println("enter year:");
        int year=input.nextInt();
        System.out.println("enter hours (0-23):");
        int hour = input.nextInt();
        System.out.println("enter minutes (0-59):");
        int minutes = input.nextInt();
        Memo newMemo= new Memo(describe,important,year,month,day,hour,minutes);
        return newMemo;
    }
}


