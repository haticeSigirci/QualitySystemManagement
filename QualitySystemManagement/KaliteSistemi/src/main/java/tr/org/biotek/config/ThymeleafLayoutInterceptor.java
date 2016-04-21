package tr.org.biotek.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {

	public static final String MAIN_LAYOUT = "layout/main";
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		String originalViewName = modelAndView.getViewName(); // view get from controller
		
		if(isRedirectOrForward(originalViewName)) {
			
			return; //continue
			
		}
		
		//intercepter is changing the controller action, in this way we can choose the second url
		
		modelAndView.setViewName(MAIN_LAYOUT);
		modelAndView.addObject("layout_main", originalViewName); // add attribute model
		
	
	}

	private boolean isRedirectOrForward(String originalViewName) {
		return originalViewName.startsWith("redirect:") || originalViewName.startsWith("forward:");
	}
}
