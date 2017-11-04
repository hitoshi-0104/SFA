package service.lead.common;

import java.util.Map;
import java.util.TreeMap;

import service.lead.dto.SelectItemsDto;

/**
 * セレクトボックス用のアイテム取得ロジック
 * @author HITOSHI
 *
 */
public class GetSelectItems {

	/**
	 * 取得
	 * @return
	 */
	public SelectItemsDto get() {

		SelectItemsDto dto = new SelectItemsDto();

		// ソースの取得
		Map<String, String> sourceMap = new TreeMap<String, String>();
		sourceMap.put("", "");
		sourceMap.put("01", "Web");
		sourceMap.put("02", "電話");
		sourceMap.put("03", "紹介");
		sourceMap.put("04", "その他");
		dto.setSourceMap(sourceMap);

		// 状況の取得
		Map<String, String> statusMap = new TreeMap<String, String>();
		statusMap.put("", "");
		statusMap.put("01", "未着手");
		statusMap.put("02", "コンタクト");
		statusMap.put("03", "クローズ");
		dto.setStatusMap(statusMap);

		// 評価の取得
		Map<String, String> estimationMap = new TreeMap<String, String>();
		estimationMap.put("", "");
		estimationMap.put("01", "高");
		estimationMap.put("02", "中");
		estimationMap.put("03", "低");
		dto.setEstimationMap(estimationMap);

		// 業種の取得
		Map<String, String> industryMap = new TreeMap<String, String>();
		industryMap.put("", "");
		industryMap.put("01", "建設業");
		industryMap.put("02", "製造業");
		industryMap.put("03", "電気･ガス･熱供給･水道業");
		industryMap.put("04", "情報通信業");
		industryMap.put("05", "運輸業､郵便業");
		industryMap.put("06", "卸売業､小売業");
		industryMap.put("07", "金融業､保険業");
		industryMap.put("08", "不動産業､物品賃貸業");
		industryMap.put("09", "学術研究､専門･技術サービス業");
		industryMap.put("10", "宿泊業､飲食サービス業");
		industryMap.put("11", "生活関連サービス業､娯楽業");
		industryMap.put("12", "教育､学習支援業");
		industryMap.put("13", "医療､福祉");
		industryMap.put("14", "複合サービス事業");
		industryMap.put("15", "サービス業(他に分類されないもの)");
		industryMap.put("16", "公務（他に分類されない）");
		industryMap.put("17", "農業､林業");
		industryMap.put("18", "漁業");
		industryMap.put("19", "鉱業、採石業、砂利採取業");
		dto.setIndustryMap(industryMap);

		// 都道府県の取得
		Map<String, String> divisionMap = new TreeMap<String, String>();
		divisionMap.put("", "");
		divisionMap.put("01", "北海道");
		divisionMap.put("02", "青森県");
		divisionMap.put("03", "岩手県");
		divisionMap.put("04", "宮城県");
		divisionMap.put("05", "秋田県");
		divisionMap.put("06", "山形県");
		divisionMap.put("07", "福島県");
		divisionMap.put("08", "茨城県");
		divisionMap.put("09", "栃木県");
		divisionMap.put("10", "群馬県");
		divisionMap.put("11", "埼玉県");
		divisionMap.put("12", "千葉県");
		divisionMap.put("13", "東京都");
		divisionMap.put("14", "神奈川県");
		divisionMap.put("15", "新潟県");
		divisionMap.put("16", "富山県");
		divisionMap.put("17", "石川県");
		divisionMap.put("18", "福井県");
		divisionMap.put("19", "山梨県");
		divisionMap.put("20", "長野県");
		divisionMap.put("21", "岐阜県");
		divisionMap.put("22", "静岡県");
		divisionMap.put("23", "愛知県");
		divisionMap.put("24", "三重県");
		divisionMap.put("25", "滋賀県");
		divisionMap.put("26", "京都府");
		divisionMap.put("27", "大阪府");
		divisionMap.put("28", "兵庫県");
		divisionMap.put("29", "奈良県");
		divisionMap.put("30", "和歌山県");
		divisionMap.put("31", "鳥取県");
		divisionMap.put("32", "島根県");
		divisionMap.put("33", "岡山県");
		divisionMap.put("34", "広島県");
		divisionMap.put("35", "山口県");
		divisionMap.put("36", "徳島県");
		divisionMap.put("37", "香川県");
		divisionMap.put("38", "愛媛県");
		divisionMap.put("39", "高知県");
		divisionMap.put("40", "福岡県");
		divisionMap.put("41", "佐賀県");
		divisionMap.put("42", "長崎県");
		divisionMap.put("43", "熊本県");
		divisionMap.put("44", "大分県");
		divisionMap.put("45", "宮崎県");
		divisionMap.put("46", "鹿児島県");
		divisionMap.put("47", "沖縄県");

		dto.setDivisionMap(divisionMap);

		return dto;

	}

}
