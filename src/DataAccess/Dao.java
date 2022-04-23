package DataAccess;
import Domain.Game;
import Domain.Member;

import java.sql.SQLException;
import java.util.*;
public interface Dao <T> {

     List<T> getMembers();
//    ArrayList<Game> getGames();
//        Optional<T> get(long id);
//
//        List<T> getAll();
//
//        void save(T t) throws SQLException;
//
//        void update(T t, String[] params);
//
//        void delete(T t);
    }

