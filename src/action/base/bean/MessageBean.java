package action.base.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 画面表示のメッセージを格納するBeanクラス
 *
 */
public class MessageBean implements Serializable {

	/**
	 * メッセージ
	 */
	private List<String> messages = new ArrayList<String>();

	/**
	 * @return messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages セットする messages
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
