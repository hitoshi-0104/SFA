package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.base.BaseDao;
import dao.entity.ClassEntity;

/**
 * 分類マスタDao
 *
 */
public class ClassDao extends BaseDao {

	/** selectByCode1メソッドで使用するSQL */
	private static final String SELECT_BY_CODE1_SQL = "SELECT * FROM M_CLASS WHERE CODE1 = ? ORDER BY CODE1, CODE2";

	/**
	 * コンストラクタ
	 */
	public ClassDao(ConnectionProvider cp) {
		super(cp);
	}

	/**
	 * Code1を指定して分類を取得
	 * @param code1
	 * @return
	 * @throws Exception
	 */
	public List<ClassEntity> seleceByCode1(String code1) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_BY_CODE1_SQL)) {

			// ID
			statement.setObject(1, code1);

			// SQL実行
			ResultSet rs = statement.executeQuery();

			List<ClassEntity> list = new ArrayList<ClassEntity>();
			while (rs.next()) {
				ClassEntity entity = new ClassEntity();
				// ID
				entity.setId((Integer)rs.getObject("CLASS_ID"));
				// コード1
				entity.setCode1((String)rs.getObject("CODE1"));
				// コード1名
				entity.setCode1Name((String)rs.getObject("CODE1_NAME"));
				// コード2
				entity.setCode2((String)rs.getObject("CODE2"));
				// コード2名
				entity.setCode2Name((String)rs.getObject("CODE2_NAME"));
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
