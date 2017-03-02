package test.com.daniellfeijo.personaltasksmanager.util.interceptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.mvc.Controller;

import main.com.daniellfeijo.personaltasksmanager.user.model.User;
import main.com.daniellfeijo.personaltasksmanager.util.interceptor.AuthorizerInterceptor;

public class AuthorizedInterceptorTest {
	
	@Test
	public void preHandleLoginFormTest(){
	    HttpServletRequest req = mock(HttpServletRequest.class);
	    HttpServletResponse resp = mock(HttpServletResponse.class);
	    Controller controller = mock(Controller.class);
	    
		when(req.getRequestURI()).thenReturn("loginForm");
	    
		AuthorizerInterceptor authorizerInterceptor = new AuthorizerInterceptor();
		
		try {
			Assert.assertEquals(true, authorizerInterceptor.preHandle(req, resp, controller));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void preHandleMakeLoginTest(){
	    HttpServletRequest req = mock(HttpServletRequest.class);
	    HttpServletResponse resp = mock(HttpServletResponse.class);
	    Controller controller = mock(Controller.class);
	    
	    when(req.getRequestURI()).thenReturn("makeLogin");
	    
		AuthorizerInterceptor authorizerInterceptor = new AuthorizerInterceptor();
		
		try {
			Assert.assertEquals(true, authorizerInterceptor.preHandle(req, resp, controller));
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	@Test
	public void preHandleResourceTest(){
	    HttpServletRequest req = mock(HttpServletRequest.class);
	    HttpServletResponse resp = mock(HttpServletResponse.class);
	    Controller controller = mock(Controller.class);
	    
	    when(req.getRequestURI()).thenReturn("resource");
	    
		AuthorizerInterceptor authorizerInterceptor = new AuthorizerInterceptor();
		
		try {
			Assert.assertEquals(true, authorizerInterceptor.preHandle(req, resp, controller));
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
		
	@Test
	public void preHandleChangeLangueTest(){
	    HttpServletRequest req = mock(HttpServletRequest.class);
	    HttpServletResponse resp = mock(HttpServletResponse.class);
	    Controller controller = mock(Controller.class);
	    
	    when(req.getRequestURI()).thenReturn("changeLangue");
	    
		AuthorizerInterceptor authorizerInterceptor = new AuthorizerInterceptor();
		
		try {
			Assert.assertEquals(true, authorizerInterceptor.preHandle(req, resp, controller));
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	@Test
	public void preHandleLoggedRootUserTest(){
	    HttpServletRequest req = mock(HttpServletRequest.class);
	    HttpServletResponse resp = mock(HttpServletResponse.class);
	    HttpSession httpSession = mock(HttpSession.class);
	    Controller controller = mock(Controller.class);
	    User user = new User();
	    user.setEmail("daniellfeijo@gmail.com");
	    user.setProfile("root");	    	    

	    when(req.getRequestURI()).thenReturn("anyActionRoot");
	    when(req.getSession()).thenReturn(httpSession);
	    when(httpSession.getAttribute("loggedUser")).thenReturn(user);
	    
		AuthorizerInterceptor authorizerInterceptor = new AuthorizerInterceptor();
		
		try {
			Assert.assertEquals(true, authorizerInterceptor.preHandle(req, resp, controller));
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	@Test
	public void preHandleNotLoggedRootUserTest(){
	    HttpServletRequest req = mock(HttpServletRequest.class);
	    HttpServletResponse resp = mock(HttpServletResponse.class);
	    HttpSession httpSession = mock(HttpSession.class);
	    Controller controller = mock(Controller.class);
	    User user = new User();
	    user.setEmail("daniellfeijo@gmail.com");
	    user.setProfile("user");	    	    

	    when(req.getRequestURI()).thenReturn("anyActionRoot");
	    when(req.getSession()).thenReturn(httpSession);
	    when(httpSession.getAttribute("loggedUser")).thenReturn(user);
	    
		AuthorizerInterceptor authorizerInterceptor = new AuthorizerInterceptor();
		
		try {
			Assert.assertEquals(false, authorizerInterceptor.preHandle(req, resp, controller));
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
}
