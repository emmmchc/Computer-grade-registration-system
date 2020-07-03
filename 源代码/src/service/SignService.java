package service;

import entity.Sign;

import java.util.List;

public interface SignService {
	/**
	 * 插入
	 * @param sign
	 * @return
	 */
	boolean insert(Sign sign);

	/**
	 * 根据学号删除
	 */
	boolean delete(String signNumber);

	/**
	 * 更新全部
	 * @param sign
	 * @return
	 */
	boolean update(Sign sign);

	/**
	 * 按照学号查找
	 * @param signNumber
	 * @return
	 */
	Sign select(String signNumber);

	/**
	 * 查询全部
	 * @return
	 */
	List<Sign> findAll();

	/**
	 * 获取最后一条记录的id
	 * @return
	 */
	int selectLastId();





	void confind(Sign sign);
}



