package com.icss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.icss.model.User;
/*
 * 
 * 2016-09-12
 */
public interface MySqlMapper {
	
	/*
	 * mapper.xml映射文件的第二种实现方法
	 */
//	@Select("select * from tableName")
//	List<User> getList();
}
