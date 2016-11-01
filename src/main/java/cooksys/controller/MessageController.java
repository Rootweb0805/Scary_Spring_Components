package cooksys.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.DataTransferObject;
import cooksys.calmDown.HalfBakedIdea;
import cooksys.calmDown.Message;
import cooksys.component.LoggerComponent;

@RestController
@RequestMapping("message")
public class MessageController {

	HalfBakedIdea actions;
	Message message;
	LoggerComponent logger;
	ArrayList<String> list = new ArrayList<>();

	public MessageController(Message msg, HalfBakedIdea actions, LoggerComponent logger) {
		message = msg;
		this.actions = actions;
		this.logger = logger;
	}

	@GetMapping
	public Message getMessage() {
		return message;
	}

	/**
	 * Use a Map<String, String> to accept any arbitrary JSON object as
	 * key-value pairs
	 * 
	 * @param incoming
	 * @return
	 */
	@PostMapping
	public String postMessage(@RequestBody Map<String, String> incoming) {

		StringBuffer b = new StringBuffer();

		incoming.entrySet().forEach(

				entry -> b.append(entry.getKey() + " HAS A VALUE OF " + entry.getValue() + "\n")

		);

		return b.toString();
	}

	/**
	 * Use a POJO to cause Spring to marshal the incoming JSON as a particular
	 * object
	 * 
	 * @param incoming
	 * @return
	 */
	@PutMapping
	public String putMessage(@RequestBody DataTransferObject incoming) {

		System.out.println(incoming.getValue());
		return incoming.getValue();
	}

	@GetMapping("count")
	public Integer getCharacterCount() {
		return message.getMessage().length();
	}

	@GetMapping("actions")
	public Integer getActions() {
		return actions.getActionCount();
	}

//	@GetMapping("/user/{username}")
//	public String getFirstCharacterOfUserName(@PathVariable String username) {
//		return username.substring(0, 1);
//	}

	@PutMapping("/user/{username}")
	public String putDataToUser(@PathVariable String username, @RequestBody DataTransferObject msg) {
		String message = msg.getValue();
		this.list.add(message);
		logger.logIt(message);
		return username + " got a message containing " + msg.getValue() + "!";
	}

	@GetMapping("/user/{username}")
	public String getDataforUser(@PathVariable String username) {
		String messages = "No messages!";
			if (this.list != null) {
				for (String s : this.list) {
				messages = s + "\n";
				}
			}
			if (this.list != null)this.list.clear();
			return messages;

	}
}
