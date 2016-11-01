package cooksys.calmDown;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cooksys.component.LoggerComponent;

@Component
@Scope("request")
public class GetReqd {

	public GetReqd(LoggerComponent logger) {
		logger.logIt("Request scoped bean created!");
	}
	
}
