package com.libre;

import net.dreamlu.mica.http.AsyncExchange;
import net.dreamlu.mica.http.HttpRequest;

/**
 * @author: Libre
 * @Date: 2023/4/9 6:02 AM
 */
public class AsyncHttpTest {

	public static void main(String[] args) {
		AsyncExchange asyncExchange = HttpRequest.get("https://www.baidu.com")
				.async() // 开启异步
				.onFailed((request, e) -> {    // 异常时的处理
					e.printStackTrace();
				});

	}

}
