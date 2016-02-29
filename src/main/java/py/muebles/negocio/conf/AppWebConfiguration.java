package py.muebles.negocio.conf;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;

import py.muebles.negocio.controller.ClienteController;
import py.muebles.negocio.controller.HomeController;
import py.muebles.negocio.dao.ClienteDAO;


//Revisar ..recien realize el extends ??
@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class,ClienteDAO.class})
@EnableCaching
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		return new CookieLocaleResolver();
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
//	@Bean
//	public InternalResourceViewResolver internalResourceViewResolver() {
//	InternalResourceViewResolver resolver =new InternalResourceViewResolver();
//	resolver.setPrefix("/WEB-INF/views/");
//	resolver.setSuffix(".jsp");
//	return resolver;
//	}
	
	@Bean(name="messageSource")
	public MessageSource messageSource(){
	ReloadableResourceBundleMessageSource bundle =new ReloadableResourceBundleMessageSource();
	bundle.setBasename("/WEB-INF/messages");
	bundle.setDefaultEncoding("UTF-8");
	bundle.setCacheSeconds(1);
	return bundle;
	}
	
	//para que la configuracion siempre sea realizada con este formato de fecha
	@Bean
	public FormattingConversionService mvcConversionService() {
	DefaultFormattingConversionService conversionService =
	new DefaultFormattingConversionService(true);
	DateFormatterRegistrar registrar =
	new DateFormatterRegistrar();
	registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
	registrar.registerFormatters(conversionService);
	return conversionService;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
	return new StandardServletMultipartResolver();
	}
	
	@Bean
	public InternalResourceViewResolver
	internalResourceViewResolver() {
	InternalResourceViewResolver resolver =
	new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	//passamos o exato nome da classe que será registrada
	resolver.setExposedContextBeanNames("shoppingCart");
	return resolver;
	}
	
	
	@Bean
	public RestTemplate restTemplate(){
	return new RestTemplate();
	}
	
//	@Bean
//	public CacheManager cacheManager(){
//	return new ConcurrentMapCacheManager();
//	}
//	
	@Bean
	public CacheManager cacheManager() {
	CacheBuilder<Object, Object> builder =
	CacheBuilder.newBuilder()
	.maximumSize(100)
	.expireAfterAccess(5, TimeUnit.MINUTES);
	GuavaCacheManager cacheManager = new GuavaCacheManager();
	cacheManager.setCacheBuilder(builder);
	return cacheManager;
	}
	
//	@Bean
//	public ViewResolver contentNegotiatingViewResolver(
//	ContentNegotiationManager manager) {
//	List<ViewResolver> resolvers =new ArrayList<ViewResolver>();
//	resolvers.add(internalResourceViewResolver());
//	resolvers.add(new JsonViewResolver());
//	ContentNegotiatingViewResolver resolver =
//	new ContentNegotiatingViewResolver();
//	resolver.setViewResolvers(resolvers);
//	resolver.setContentNegotiationManager(manager);
//	return resolver;
//	}
//	
	
//	@Bean
//	public MailSender mailSender() {
//	JavaMailSenderImpl javaMailSenderImpl =
//	new JavaMailSenderImpl();
//	javaMailSenderImpl.setHost("smtp.gmail.com");
//	javaMailSenderImpl.setPassword("daniel456");
//	javaMailSenderImpl.setPort(587);
//	javaMailSenderImpl.setUsername("magzoaa@gmail.com");
//	Properties mailProperties = new Properties();
//	mailProperties.put("mail.smtp.auth", true);
//	mailProperties.put("mail.smtp.starttls.enable", true);
//	javaMailSenderImpl.setJavaMailProperties(mailProperties);
//	return javaMailSenderImpl;
//	}
	

}
