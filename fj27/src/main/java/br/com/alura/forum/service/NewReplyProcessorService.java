package br.com.alura.forum.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.forum.model.Answer;
import br.com.alura.forum.model.topic_domain.Topic;
import br.com.alura.forum.repository.AnswerRepository;
import br.com.alura.forum.service.infra.ForumMailService;
import br.com.alura.forum.service.infra.MailServiceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NewReplyProcessorService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private ForumMailService forumMailService;
	
	public void execute(Answer answer) {
		this.answerRepository.save(answer);
		
		try {
			this.forumMailService.sendNewReplyMail(answer);
		} catch (MailServiceException e) {
			Topic answeredTopic = answer.getTopic();
			log.error("Não foi possível notificar o usúario {} enviando email para {}", 
					answeredTopic.getOwnerName(), answeredTopic.getOwnerEmail());;
		}
	}
}
