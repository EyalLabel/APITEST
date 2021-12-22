package Facade;

import Beans.Memo;
import DBDAO.MemoDB;
import Threads.MenuThread;
import Threads.ScannerThread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Facade {
    MemoDB mdb;
    private ArrayList<Memo> memos;
    MenuThread menuThread;
    ScannerThread scannerThread;

    public Facade() {
        mdb = new MemoDB();
        memos = new ArrayList<>();
        menuThread = new MenuThread(memos);
        scannerThread = new ScannerThread(memos);
        new Thread(menuThread).start();
        new Thread(scannerThread).start();
    }
}
