package config.dream.com;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/** web.xml*/
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class}; //webconfig에서 rootconfig로 연동
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return null;
	}

}
