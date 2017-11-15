package service.lead.common;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import service.lead.dto.SelectItemsDto;

/**
 * GetSelectItemsクラスのテストクラス
 *
 */
class GetSelectItemsTest {

	/**
	 * getメソッドのテストクラス
	 */
	@Test
	void testGet() {
		GetSelectItems gsi = new GetSelectItems();

		SelectItemsDto dto = null;
		try {
			dto = gsi.get();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		// ソース
		Map<String, String> m = dto.getSourceMap();
		assertEquals(m.get(""), "");
		assertEquals(m.get("01"), "Web");
		assertEquals(m.get("02"), "電話");
		assertEquals(m.get("03"), "紹介");
		assertEquals(m.get("04"), "その他");

		// 状況
		m = dto.getStatusMap();
		assertEquals(m.get(""), "");
		assertEquals(m.get("01"), "未着手");
		assertEquals(m.get("02"), "コンタクト");
		assertEquals(m.get("03"), "クローズ");

		// 評価
		m = dto.getEstimationMap();
		assertEquals(m.get(""), "");
		assertEquals(m.get("01"), "高");
		assertEquals(m.get("02"), "中");
		assertEquals(m.get("03"), "低");

		// 業種
		m = dto.getIndustryMap();
		assertEquals(m.get(""), "");
		assertEquals(m.get("01"), "建設業");
		assertEquals(m.get("02"), "製造業");
		assertEquals(m.get("03"), "電気･ガス･熱供給･水道業");
		assertEquals(m.get("04"), "情報通信業");
		assertEquals(m.get("05"), "運輸業､郵便業");
		assertEquals(m.get("06"), "卸売業､小売業");
		assertEquals(m.get("07"), "金融業､保険業");
		assertEquals(m.get("08"), "不動産業､物品賃貸業");
		assertEquals(m.get("09"), "学術研究､専門･技術サービス業");
		assertEquals(m.get("10"), "宿泊業､飲食サービス業");
		assertEquals(m.get("11"), "生活関連サービス業､娯楽業");
		assertEquals(m.get("12"), "教育､学習支援業");
		assertEquals(m.get("13"), "医療､福祉");
		assertEquals(m.get("14"), "複合サービス事業");
		assertEquals(m.get("15"), "サービス業(他に分類されないもの)");
		assertEquals(m.get("16"), "公務（他に分類されない）");
		assertEquals(m.get("17"), "農業､林業");
		assertEquals(m.get("18"), "漁業");
		assertEquals(m.get("19"), "鉱業、採石業、砂利採取業");

		// 都道府県
		m = dto.getDivisionMap();
		assertEquals(m.get(""), "");
		assertEquals(m.get("01"), "北海道");
		assertEquals(m.get("02"), "青森県");
		assertEquals(m.get("03"), "岩手県");
		assertEquals(m.get("04"), "宮城県");
		assertEquals(m.get("05"), "秋田県");
		assertEquals(m.get("06"), "山形県");
		assertEquals(m.get("07"), "福島県");
		assertEquals(m.get("08"), "茨城県");
		assertEquals(m.get("09"), "栃木県");
		assertEquals(m.get("10"), "群馬県");
		assertEquals(m.get("11"), "埼玉県");
		assertEquals(m.get("12"), "千葉県");
		assertEquals(m.get("13"), "東京都");
		assertEquals(m.get("14"), "神奈川県");
		assertEquals(m.get("15"), "新潟県");
		assertEquals(m.get("16"), "富山県");
		assertEquals(m.get("17"), "石川県");
		assertEquals(m.get("18"), "福井県");
		assertEquals(m.get("19"), "山梨県");
		assertEquals(m.get("20"), "長野県");
		assertEquals(m.get("21"), "岐阜県");
		assertEquals(m.get("22"), "静岡県");
		assertEquals(m.get("23"), "愛知県");
		assertEquals(m.get("24"), "三重県");
		assertEquals(m.get("25"), "滋賀県");
		assertEquals(m.get("26"), "京都府");
		assertEquals(m.get("27"), "大阪府");
		assertEquals(m.get("28"), "兵庫県");
		assertEquals(m.get("29"), "奈良県");
		assertEquals(m.get("30"), "和歌山県");
		assertEquals(m.get("31"), "鳥取県");
		assertEquals(m.get("32"), "島根県");
		assertEquals(m.get("33"), "岡山県");
		assertEquals(m.get("34"), "広島県");
		assertEquals(m.get("35"), "山口県");
		assertEquals(m.get("36"), "徳島県");
		assertEquals(m.get("37"), "香川県");
		assertEquals(m.get("38"), "愛媛県");
		assertEquals(m.get("39"), "高知県");
		assertEquals(m.get("40"), "福岡県");
		assertEquals(m.get("41"), "佐賀県");
		assertEquals(m.get("42"), "長崎県");
		assertEquals(m.get("43"), "熊本県");
		assertEquals(m.get("44"), "大分県");
		assertEquals(m.get("45"), "宮崎県");
		assertEquals(m.get("46"), "鹿児島県");
		assertEquals(m.get("47"), "沖縄県");

	}

}
