package DAO;

import Beans.Memo;

import java.util.List;

public interface Dao {
    Boolean addMemo(Memo memo);
    List<Memo>getMemoList();
}
