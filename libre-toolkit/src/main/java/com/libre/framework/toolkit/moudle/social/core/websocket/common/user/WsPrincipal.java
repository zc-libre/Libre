
package com.libre.framework.toolkit.moudle.social.core.websocket.common.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.security.Principal;

/**
 * websocket Principal
 *
 * @author L.cm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WsPrincipal implements Principal, Serializable {

	private String name;

}
