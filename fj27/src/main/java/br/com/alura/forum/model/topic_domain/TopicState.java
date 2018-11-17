package br.com.alura.forum.model.topic_domain;

import br.com.alura.forum.model.Answer;

public interface TopicState {

    void registerNewReply(Topic topic, Answer newReply);
	void markAsSolved(Topic topic, Answer solution);
	void close(Topic topic);
}
