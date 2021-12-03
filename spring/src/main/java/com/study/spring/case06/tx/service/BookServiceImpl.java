package com.study.spring.case06.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.case06.tx.dao.BookDao;
import com.study.spring.case06.tx.exception.InsufficientAmount;
import com.study.spring.case06.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	/*
	 * @Transactional 
	 * bookDao.UpdateStock(bid); bookDao.UpdateWallet(wid, price);
	 * 這兩個是一筆交易 
	 * 這兩個都要成功這筆交易才算成立 
	 * 其中有一個失敗或中間發生錯誤都會造成交易失敗 
	 * 有被更改的資料會回滾
	 */
	@Transactional(
		// propagation傳播級別 要不要使用上一層而來的交易級別
			// propagation = Propagation.REQUIRED//支持當前Transactional(預設)
			// propagation = Propagation.REQUIRES_NEW//自己有Transactional不會繼承他人
		// isolation隔離級別
			// isolation=Isolation.DEFAULT //根據資料庫隔離級別(預設)
			// isolation = Isolation.READ_UNCOMMITTED//允許交易讀取其他並行的交易還沒有提交的資料
			// isolation = Isolation.READ_COMMITTED//只讀取已經確認的資料
			// isolation = Isolation.REPEATABLE_READ//要求多次讀取資料必須相同(MySql預設)
			// isolation = Isolation.SERIALIZABLE//將資料表鎖定 序列化單工
		// timeout超時 會進行回滾
			// timeout = 3
		// readOnly=true//資料庫不鎖定的方式進行存取增加效能,用於查詢方案
		// rollbackFor 根據發生事件進行回滾
			rollbackFor = { InsufficientAmount.class, InsufficientQuantity.class }, noRollbackFor = {
					RuntimeException.class })
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientQuantity, InsufficientAmount {

		// 這本書的價格
		int price = bookDao.getPrice(bid);
		// 減去庫存
		bookDao.UpdateStock(bid);

		// 商業邏輯處理錯誤
		// System.out.println(10 / 0);

		// 錢包減去的金額
		bookDao.UpdateWallet(wid, price);

	}

	@Transactional(// timeout = 3
	)
	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientQuantity, InsufficientAmount {
		for (Integer bid : bids) {
			buyOne(wid, bid);
		}
	}
}
