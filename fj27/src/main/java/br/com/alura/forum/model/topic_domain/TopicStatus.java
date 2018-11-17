package br.com.alura.forum.model.topic_domain;

import br.com.alura.forum.model.Answer;

public enum TopicStatus implements TopicState {

	NOT_ANSWERED {

		@Override
		public void registerNewReply(Topic topic, Answer newReply) {
			if (! topic.getOwner().equals(newReply.getOwner())) {
				topic.setStatus(NOT_SOLVED);
			}

			topic.addAnswer(newReply);
		}

		@Override
		public void markAsSolved(Topic topic, Answer solution) {
			throw new RuntimeException("Ainda não implementamos essa feature!");
		}

		@Override
		public void close(Topic topic) {
			throw new RuntimeException("Ainda não implementamos essa feature!");
		}
	},

	NOT_SOLVED {

		@Override
		public void registerNewReply(Topic topic, Answer newReply) {
			topic.addAnswer(newReply);
		}

		@Override
		public void markAsSolved(Topic topic, Answer solution) {
			throw new RuntimeException("Ainda não implementamos essa feature!");
		}

		@Override
		public void close(Topic topic) {
			throw new RuntimeException("Ainda não implementamos essa feature!");
		}
	},

	SOLVED {

		@Override
		public void registerNewReply(Topic topic, Answer newReply) {
			topic.addAnswer(newReply);
		}

		@Override
		public void markAsSolved(Topic topic, Answer solution) {
			throw new RuntimeException("Ainda não implementamos essa feature!");
		}

		@Override
		public void close(Topic topic) {
			throw new RuntimeException("Ainda não implementamos essa feature!");
		}
	},

	CLOSED {

		@Override
		public void registerNewReply(Topic topic, Answer newReply) {
			throw new RuntimeException("Tópico fechado! Não é possível adicionar novas respostas");
		}

		@Override
		public void markAsSolved(Topic topic, Answer solution) {
			throw new RuntimeException("Ainda não implementamos essa feature!");
		}

		@Override
		public void close(Topic topic) {
			throw new RuntimeException("Ainda não implementamos essa feature!");
		}
	};
}
