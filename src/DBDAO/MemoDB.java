package DBDAO;

import Beans.Memo;
import DAO.Dao;
import SQL.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MemoDB implements Dao {
    private static final String ADD_MEMO = "INSERT INTO `memoSystem`.`memos` (`description`,`important` ,`shown` ,`memoDate`) VALUES (?,?,?,?)";
    private static final String UPDATE_MEMO = "UPDATE `memoSystem`.`memos` set description=?, important=?, shown=?, memoDate=? WHERE id=?";
    private static final String GET_ONE_MEMO_BY_ID = "SELECT * FROM `memoSystem`.`memos` WHERE id=?";
    private static final String GET_ALL_REPAIR_BY_SN = "";
    private static final String GET_ALL_MEMO = "SELECT * FROM `memoSystem`.`memos`";
    private static final String DELETE_BY_ID = "DELETE FROM `memoSystem`.`memos` where id=?";
    //connection to the data base
    Connection connection;

    public MemoDB() {
        try {
            ConnectionPool.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Boolean addMemo(Memo memo) {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_MEMO);
            statement.setString(1, memo.getDescription());
            statement.setBoolean(2, memo.isImportant());
            statement.setBoolean(2, memo.isShown());
            statement.setDate(4, memo.getMemoDate());
statement.execute();
return true;
        } catch (InterruptedException | SQLException e) {
return false;
        }finally {
            try {
                ConnectionPool.getInstance().closeAllConnection();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Memo> getMemoList() {
        return null;
    }
}
