package br.com.alura.forum.repository.setup;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.topic_domain.Topic;

public class TopicRepositoryTestSetup {

	private TestEntityManager testEntityManager;
	
	public TopicRepositoryTestSetup(TestEntityManager testEntityManager) {
		this.testEntityManager = testEntityManager;
	}
	
	public void openTopicsByCategorySetup() {
		Category programacao = this.testEntityManager.persist(new Category("Programação"));
				
		Category front = this.testEntityManager.persist(new Category("Front-end"));
		
		Category javaWeb = this.testEntityManager.persist(new Category("Java Web", programacao));
		
		Category javaScript = this.testEntityManager.persist(new Category("JavaScript", front));
		
		Course fj27 = this.testEntityManager.persist(new Course("Spring Framework", javaWeb));

		Course fj21 = this.testEntityManager.persist(new Course("Servelet API e MVC", javaWeb));

		Course fj46 = this.testEntityManager.persist(new Course("React", javaScript));
		
		Topic springTopic = new Topic("Topic Spring", "Conteudo do topico", null, fj27);
		
		Topic serveletTopic = new Topic("Topic Servelet", "Conteudo do topico", null, fj21);
		
		Topic reactTopic = new Topic("Topic React", "Conteudo do topico", null, fj46);
		
		this.testEntityManager.persist(springTopic);
		this.testEntityManager.persist(serveletTopic);
		this.testEntityManager.persist(reactTopic);
	}
}
