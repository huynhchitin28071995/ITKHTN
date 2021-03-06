package interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import businessLogics.AuthorBL;
import javaBeans.Author;

public class AuthorInterceptor implements HandlerInterceptor{
  @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	List<Author> dsAuthor = AuthorBL.docTatCa();
	request.setAttribute("dsAuthor", dsAuthor);
	
	return true;
}
}
