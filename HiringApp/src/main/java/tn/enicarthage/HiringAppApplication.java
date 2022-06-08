package tn.enicarthage;
import tn.enicarthage.Repo.AdministrateurRepo;
import tn.enicarthage.Repo.PostulantRepo;
import tn.enicarthage.Repo.RecruteurRepo;
import tn.enicarthage.Repo.UtilisateurRepo;
import tn.enicarthage.Service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HiringAppApplication {

	public static void main(String[] args) {
		/*ConfigurableApplicationContext configureApplicationContext =
				SpringApplication.run( HiringAppApplication.class , args) ; 
		UtilisateurRepo recruteurRepo=configureApplicationContext.getBean(RecruteurRepo.class);
		UtilisateurRepo postulantRepo=configureApplicationContext.getBean(PostulantRepo.class);
		AdministrateurRepo administrateurRepo=configureApplicationContext.getBean(AdministrateurRepo.class);*/
		SpringApplication.run(HiringAppApplication.class, args);
	}

	
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
			}
		};
	}
}
