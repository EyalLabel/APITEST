package Threads;

import Beans.Memo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

public class ScannerThread implements Runnable {
   private ArrayList<Memo> memos;
    private boolean running=true;

    public ScannerThread(ArrayList<Memo> memos) {
        this.memos = memos;
        boolean running;

    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
     try {

         while (running) {
             for (Memo memo : memos) {
                 if (memo.getMemoDate().getTime().equals(Calendar.getInstance().getTime()) && !memo.isShown()) {
                     if (memo.isImportant()) {
                         System.out.println(memo.getDescription());
                         System.out.println(memo.getDescription());
                         System.out.println(memo.getDescription());
                         memo.setShown(true);
                     } else {
                         System.out.println(memo.getDescription());
                         memo.setShown(true);
                     }
                 }
             }
         }
     }catch (NullPointerException e){
         System.out.println("Set not initialized");
     }
    }
    private void stopProgram(){
        running=false;
    }


}
