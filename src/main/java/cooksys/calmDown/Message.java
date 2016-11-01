package cooksys.calmDown;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cooksys.interfaces.ConditionalThing;
import cooksys.interfaces.Printable;

@Component
@PropertySource("classpath:messinWithStuff.properties")
@Scope(SCOPE_PROTOTYPE)
public class Message implements Printable, ConditionalThing {
	
	//Logger log = LoggerFactory.getLogger(Message.class);
	
	private String msg;
	
	public Message(HalfBakedIdea actionz, String hello) {
		msg = hello;
		
		//env.getProperty("arbitraryValue");
		
		actionz.doThings(this);
	}

	@Override
	public String getMessage() {
		return msg;
	}
	
	public void setMessage(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return getMessage();
	}

	@Override
	public boolean isCondition() {
		// TODO Auto-generated method stub
		return true;
	}

	public Message() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}