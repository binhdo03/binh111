package database;

import java.util.ArrayList;

public interface DAOinterface <T>{
		public ArrayList<T> selectALl();
		
		public T selectById(T t);
		
		public int insert(T t);
		
		public int inserAll(ArrayList<T> arr);
		
		public int delete(T t);
		
		public int deleteAll(ArrayList<T> arr);
		
		public int update(T t);
		
		
		

}
