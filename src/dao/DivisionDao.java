package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.base.BaseDao;
import dao.entity.DivisionEntity;

/**
 * 都道府県マスタエンティティ
 *
 */
public class DivisionDao extends BaseDao {

	/** selectAllメソッドで使用するSQL */
	private static final String SELECT_ALL_SQL = "SELECT * FROM M_DIVISION ORDER BY CODE";

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public DivisionDao(ConnectionProvider cp) {
		super(cp);
	}

	/**
	 * CODEを指定して都道府県を取得する
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public List<DivisionEntity> selectAll() throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_ALL_SQL)) {

			// SQL実行
			ResultSet rs = statement.executeQuery();

			List<DivisionEntity> list = new ArrayList<DivisionEntity>();
			while (rs.next()) {
				DivisionEntity entity = new DivisionEntity();
				// ID
				entity.setId((Integer)rs.getObject("DIVISION_ID"));
				// コード
				entity.setCode((String)rs.getObject("CODE"));
				// コード名
				entity.setName((String)rs.getObject("NAME"));
				// 作成日
				entity.setCreateDate((String)rs.getObject("CREATE_DATE"));
				// 作成者
				entity.setCreaterId((Integer)rs.getObject("CREATER_ID"));
				// 更新日
				entity.setUpdateDate((String)rs.getObject("UPDATE_DATE"));
				// 更新者
				entity.setUpdaterId((Integer)rs.getObject("UPDATER_ID"));

				list.add(entity);
			}
			return list;
		}
	}

}
