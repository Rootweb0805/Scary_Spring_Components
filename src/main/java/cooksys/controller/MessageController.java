package cooksys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.calmDown.HalfBakedIdea;
import cooksys.calmDown.Message;

@RestController
@RequestMapping("message")
public class MessageController {

	HalfBakedIdea actions;
	Message message;

	public MessageController(Message msg, HalfBakedIdea actions) {
		message = msg;
		this.actions = actions;
	}

	@GetMapping
	public Message getMessage() {
		return message;
	}

	@GetMapping("count")
	public Integer getCharacterCount() {
		return message.getMessage().length();
	}

	@GetMapping("actions")
	public Integer getActions() {
		return actions.getActionCount();
	}

}
