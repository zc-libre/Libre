package com.libre.framework.im.controller;

import com.libre.framework.common.security.support.SecurityUtil;
import com.libre.framework.im.pojo.vo.ConversationVO;
import com.libre.toolkit.result.R;
import com.libre.framework.im.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**oiyb
 * @author: Libre
 * @Date: 2022/6/13 11:09 PM
 */
@RestController
@RequestMapping("/conversation")
@RequiredArgsConstructor
public class ConversationController {

	private final ConversationService conversationService;

	@GetMapping("/list")
	public R<List<ConversationVO>> listByUserId() {
		Long userId = Objects.requireNonNull(SecurityUtil.getUser()).getId();
		List<ConversationVO> conversations = conversationService.listByUserId(userId);
		return R.data(conversations);
	}


	@PutMapping
	public R<Boolean> add(@RequestParam Long friend) {
		conversationService.add(friend);
		return R.status(Boolean.TRUE);
	}

	@DeleteMapping
	public R<Boolean> remove(@RequestParam Long friendId) {
		Long userId = Objects.requireNonNull(SecurityUtil.getUser()).getId();
		conversationService.removeByUserIdAndFriendId(userId, friendId);
		return R.status(Boolean.TRUE);
	}
}
