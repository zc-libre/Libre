package com.libre.framework.toolkit.moudle.social.core.websocket.server.config;

import com.libre.framework.toolkit.moudle.social.core.websocket.server.account.DefaultWsAccountStore;
import com.libre.framework.toolkit.moudle.social.core.websocket.server.account.IWsAccountManage;
import com.libre.framework.toolkit.moudle.social.core.websocket.server.account.IWsAccountStore;
import com.libre.framework.toolkit.moudle.social.core.websocket.server.account.WsAccountManageImpl;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * websocket 账号管理
 *
 * @author L.cm
 */
@AutoConfiguration
@ConditionalOnProperty(name = "enable-account-store", prefix = WebSocketServerProperties.PREFIX, havingValue = "true",
		matchIfMissing = true)
public class WebSocketAccountManageConfiguration {

	@Bean
	public IWsAccountManage wsAccountManage(ObjectProvider<IWsAccountStore> provider) {
		IWsAccountStore wsAccountStore = provider.getIfAvailable(DefaultWsAccountStore::new);
		return new WsAccountManageImpl(wsAccountStore);
	}

}
