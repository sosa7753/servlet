package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

  boolean supports(Object handler); // 컨트롤러가 처리 가능한지.

  ModelView handle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws ServletException, IOException;

}
