package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelAndView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

  @Override
  public boolean supports(Object handler) {
    return (handler instanceof ControllerV3); // ControllerV3의 구현체인지?
  }

  @Override
  public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws ServletException, IOException {

    ControllerV3 controller = (ControllerV3) handler;
    Map<String, String> paramMap = createparamMap(request);

    return controller.process(paramMap);

  }

  private Map<String, String> createparamMap(HttpServletRequest request) {
    Map<String, String> paramMap = new HashMap<>();
    request.getParameterNames().asIterator()
        .forEachRemaining(paramName ->
            paramMap.put(paramName, request.getParameter(paramName)));
    return paramMap;
  }
}
